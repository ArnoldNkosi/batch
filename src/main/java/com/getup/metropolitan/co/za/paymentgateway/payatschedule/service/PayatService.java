package com.getup.metropolitan.co.za.paymentgateway.payatschedule.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class PayatService {

    private static final Logger log = LoggerFactory.getLogger(PayatService.class);
    @Autowired
    private SftpService sftpService;

    @Autowired
    PaymentGatewayService paymentGatewayService;

    String line = "";
    //  String path = "C:\\Users\\arnkosi\\Desktop\\sftpstuff\\UPLOAD-11098-20210412.csv";

  //  @Value("${payatFileDirectory}")
  //  private String path;
    public void fetchPremiumAllocations(String path) {
        try {
            log.info("..START READING FILE " + path);
            sftpService.WriteTodb(path);
        } catch (FileNotFoundException e) {
            log.info("PAYAT UPLOAD FILE WAS NOT FOUND:"+ path);
           // throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
