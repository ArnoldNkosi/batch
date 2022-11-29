package com.getup.metropolitan.co.za.paymentgateway.payatschedule.service;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto.PayatFileDto;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto.PremiumAllocationDto;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPayment;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPaymentHeader;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPaymentTrailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@Service
public class Transformer {

    @Autowired
    BillPaymentService service;

    public List<PremiumAllocationDto> transformDto(List<PayatFileDto> fileDto) throws ParseException {
        List<PremiumAllocationDto> premiumAllocationDtoList = new ArrayList<>();
        for (PayatFileDto file : fileDto) {
            PremiumAllocationDto allocationDto = new PremiumAllocationDto();
            allocationDto.setProcessMonth(createProcessMonth(file.getTransactionDate()));
            allocationDto.setGetupPlanType("GetUp MFP");
            allocationDto.setMethodOfPayment("Stop Order");
            allocationDto.setPolicyNumber(file.getAccountNumber());
            allocationDto.setPaymentPartner("Pay@");
            allocationDto.setPremium_allocation_amount(Double.valueOf(file.getAmount()));

            premiumAllocationDtoList.add(allocationDto);
        }
        return premiumAllocationDtoList;
    }

    public Long createBillPaymentHeader(String[] data,String path) throws Exception {
        BillPaymentHeader header = new BillPaymentHeader();
        header.setProcessmonth(createProcessMonth(data[2]));
        header.setRecordType(data[0]);
        header.setIssuerPrefix(data[1]);
        header.setFileOpenTime(new Timestamp(System.currentTimeMillis()));
        header.setFileName(path);
        return service.saveBillPaymentHeader(header);
    }


    public void createBillPaymentData(List<PayatFileDto> fileDto) throws Exception {
        for (PayatFileDto file : fileDto) {
            BillPayment data = new BillPayment();
            data.setHeaderId(file.getHeaderId());
            data.setRecordType(file.getRecordType());
            data.setTransactionId(file.getTransactionId());
            data.setIssuerTransactionId(file.getIssuerTransactionId());
            data.setAccountNumber(file.getAccountNumber());
            data.setTransactiontsp(Timestamp.valueOf(file.getTransactionDate()));
            data.setAmount(Double.parseDouble(file.getAmount()));
            data.setTransactionFee(Double.parseDouble(file.getTransactionFee()));
            data.setMerchantFee(Double.parseDouble(file.getMerchantFee()));
            data.setCashHandlingFee(Double.parseDouble(file.getCashHandlingFee()));
            data.setSettlementAmount(Double.parseDouble(file.getSettlementAmount()));
            data.setTenderType(file.getTenderType());
            data.setNetworkName(file.getNetworkName());
            data.setNetworkReferenceNumber(file.getNetworkReferenceNo());
            data.setTransactionPointId(file.getTransactionPointId());
            data.setTerminalId(file.getTerminalId());
            data.setTransactionStatus(Integer.parseInt(file.getTransactionStatus()));
            service.saveBillPaymentData(data);
        }
    }

    public void createBillPaymentTrailer(String[] data, Long headerId) throws Exception {
        BillPaymentTrailer trailer = new BillPaymentTrailer();
        trailer.setHeaderId(headerId);
        trailer.setRecordType(data[0]);
        trailer.setRecordCount(Double.valueOf(data[1]));
        trailer.setTotalAmount(Double.parseDouble(data[2]));
        trailer.setFileCloseTime(new Timestamp(System.currentTimeMillis()));
        service.saveBillPaymentTrailer(trailer);
    }

    public String createProcessMonth(String timeProvided){
        String processMonth = null;
        String year = timeProvided.substring(0,4);
        String month = timeProvided.substring(5,7);
        processMonth = year+month;
        return processMonth;
    }
}
