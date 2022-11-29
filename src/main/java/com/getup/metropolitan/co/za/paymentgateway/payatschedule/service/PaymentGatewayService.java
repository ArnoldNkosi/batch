package com.getup.metropolitan.co.za.paymentgateway.payatschedule.service;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto.PremiumAllocationDto;
import com.google.gson.Gson;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentGatewayService {
    private static final Logger log = LoggerFactory.getLogger(PaymentGatewayService.class);
    @Value("${paymentGateway_endpoint}")
    private String paymentGateway_endpoint;
    @Value("${payment_gateway_username}")
    private String payment_gateway_username;
    @Value("${payment_gateway_password}")
    private String payment_gateway_password;

    public void createPremiumAllocation(List<PremiumAllocationDto> request) throws Exception {
        for (PremiumAllocationDto premiumDto : request) {
            callService(premiumDto);
        }
    }

    public void callService(PremiumAllocationDto request) throws Exception {
        HttpHeaders headers = this.createClientHttpHeaders();
        String url = paymentGateway_endpoint;
        log.info("URL " + url);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        log.info("CREATE Payment Premium Allocation REQUEST " + json);
        json = json.replace("publicComment", "public");
        ResponseEntity<String> entityResponse = this.callPostService(url, headers, json);
        log.info("CREATE Payment Premium Allocation RESPONSE " + entityResponse.toString());
        log.info("CREATE Payment Premium Allocation RESPONSE STATUS " + entityResponse.getStatusCode());

    }

    public ResponseEntity<String> callPostService(String url, HttpHeaders headers, String jsonRequest) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, headers);
        ResponseEntity<String> result;
        RestTemplate restTemplate = this.restTemplateWithoutSSL();
        result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return result;
    }

    public RestTemplate restTemplateWithoutSSL() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    public HttpHeaders createClientHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(payment_gateway_username, payment_gateway_password);
        headers.setAccept(mediaTypeList);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
