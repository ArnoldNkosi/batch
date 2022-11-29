package com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssuerFileHeader {
    private Long id;
    private String processMonth;
    private String recordType;
    private String loadType;
    private String version;
    private String fileName;

    private Boolean wasResponseReceived;
    private Boolean wasCollectionReceived;
}
