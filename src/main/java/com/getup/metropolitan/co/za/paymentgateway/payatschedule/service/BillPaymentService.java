package com.getup.metropolitan.co.za.paymentgateway.payatschedule.service;

import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPayment;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPaymentHeader;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPaymentTrailer;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository.BillPaymentDataRepository;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository.BillPaymentHeaderRepository;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository.BillPaymentTrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillPaymentService {

    @Autowired
    BillPaymentDataRepository billPaymentDataRepository;

    @Autowired
    BillPaymentHeaderRepository billPaymentHeaderRepository;

    @Autowired
    BillPaymentTrailerRepository billPaymentTrailerRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Long saveBillPaymentHeader(BillPaymentHeader header) throws Exception {
        try{
       return  billPaymentHeaderRepository.save(header).getId();}
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveBillPaymentData(BillPayment data)throws Exception{
      try { billPaymentDataRepository.saveAndFlush(data);
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
}

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveBillPaymentTrailer(BillPaymentTrailer trailer)throws Exception {
        try {
            billPaymentTrailerRepository.saveAndFlush(trailer);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
