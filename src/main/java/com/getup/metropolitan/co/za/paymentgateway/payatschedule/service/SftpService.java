package com.getup.metropolitan.co.za.paymentgateway.payatschedule.service;

import com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto.PayatFileDto;
import com.jcraft.jsch.ChannelSftp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SftpService {

    private static final Logger log = LoggerFactory.getLogger(SftpService.class);
    @Autowired
    private Transformer transformer;
    @Autowired
    PaymentGatewayService paymentGatewayService;
    @Value("${sftp.host}")
    private String host;
    @Value("${sftp.user}")
    private String user;
    @Value("${sftptest.key}")
    private Resource prvKey;

    public void WriteTodb(String pathName) throws Exception {
        SftpSession sftpSession = sftpFactory().getSession();
        ChannelSftp channelSftp = sftpSession.getClientInstance();
        InputStream inputStream = channelSftp.get(pathName);
        List<PayatFileDto> payatFileDtoList = new ArrayList<>();
        int count = 0;
        Long headerId = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                log.info("READING DATA :" + line);
                String[] data = line.split("\\|");
                if (data.length == 0) continue;

                if (data[0].equals("H")) {
                    headerId = transformer.createBillPaymentHeader(data, pathName);
                    continue;
                }
                if (data[0].equals("T")) {
                    transformer.createBillPaymentData(payatFileDtoList);
                    transformer.createBillPaymentTrailer(data, headerId);
                    continue;
                }
                PayatFileDto fileDto = new PayatFileDto();
                fileDto.setHeaderId(headerId);
                fileDto.setRecordType(data[0]);
                fileDto.setTransactionId(data[1]);
                fileDto.setIssuerTransactionId(data[2]);
                fileDto.setAccountNumber(data[3]);
                fileDto.setTransactionDate(data[4]);
                fileDto.setAmount(data[5]);
                fileDto.setTransactionFee(data[6]);
                fileDto.setMerchantFee(data[7]);
                fileDto.setCashHandlingFee(data[8]);
                fileDto.setSettlementAmount(data[9]);
                fileDto.setTenderType(data[10]);
                fileDto.setNetworkName(data[11]);
                fileDto.setNetworkReferenceNo(data[12]);
                fileDto.setTransactionPointId(data[13]);
                fileDto.setTerminalId(data[14]);
                fileDto.setTransactionStatus(data[15]);
                payatFileDtoList.add(fileDto);
            }
       } catch (IOException e) {
            channelSftp.disconnect();
            sftpSession.close();
            throw new RuntimeException(e);
        }
        finally {
            channelSftp.disconnect();
            sftpSession.close();
        }

//       paymentGatewayService.createPremiumAllocation(transformer.transformDto(payatFileDtoList));
    }
    public DefaultSftpSessionFactory sftpFactory() {

        log.info("host :" + host);
        log.info("user : "+ user);
        log.info("prvKey : "+ prvKey );

        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
        factory.setHost(host);
        factory.setPort(22);
        factory.setAllowUnknownKeys(true);
        factory.setUser(user);
        factory.setPrivateKey(prvKey);
        factory.getSession().close();
        return factory;
    }
}

