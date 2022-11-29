package com.getup.metropolitan.co.za.paymentgateway.payatschedule.schedule;

import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.IssuerFileHeader;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository.IssuerFileHeaderRepository;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.service.PayatService;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.service.PaymentGatewayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PayatAccountFileSchedule {
    private static final Logger log = LoggerFactory.getLogger(PayatAccountFileSchedule.class);
    @Autowired
    PaymentGatewayService paymentGatewayService;

    @Autowired
    private PayatService payatService;

    @Autowired
    private IssuerFileHeaderRepository issuerFileHeaderRepository;
    @Scheduled(cron = "${payatscheduler_time}")
    //every day at 07:00
    public  void processAccountFile() {

        log.info("...START PROCESSING PAYAT ACCOUNT FILE...");
        try {
            log.info("...PROCESSING PAYAT ACCOUNT FILE");

          SelectNonProcessedCollections();

            } catch (Exception e) {
            log.info("ERROR OCCURRED:" + e.getMessage());
            throw new RuntimeException(e);
        }

        log.info("...FINISHED PROCESSING MFP MONTHLY PREMIUMS ALLOCATIONS");
    }


    public void SelectNonProcessedCollections() throws Exception {
        log.info("...READING UNPROCESSED ISSUER FILES ");
        List<IssuerFileHeader> headerList = issuerFileHeaderRepository.findByWasCollectionReceived(false);
        if (headerList != null && headerList.size() > 0) {

            for (IssuerFileHeader header : headerList) {

                String fileName = header.getFileName();
                if (fileName != null) {
                    log.info("...READING RESPONSE FILE " + fileName);
                    // String path = fileName.replace("\\bACCOUNT\\b","UPLOAD");

                    String path = "UPLOAD-" + fileName.substring(8, 13);
                    String date = fileName.substring(21, 31);
                    date = date.replace("_", "");
                    payatService.fetchPremiumAllocations(path + "-" + date + ".csv");

                }
                header.setWasCollectionReceived(true);
                issuerFileHeaderRepository.saveAndFlush(header);
            }
        }
        else{
            log.info(".... NO FILE TO BE PROCESSED");
        }
    }
}
