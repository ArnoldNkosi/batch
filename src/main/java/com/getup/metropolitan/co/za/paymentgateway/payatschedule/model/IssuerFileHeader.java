package com.getup.metropolitan.co.za.paymentgateway.payatschedule.model;


import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "audit", name = "tbl_getup_issuer_account_header")
public class IssuerFileHeader {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "process_month")
    private String processMonth;

    @Column(name = "record_type")
    private String recordType;

    @Column(name = "load_Type")
    private String loadType;

    @Column(name = "version")
    private String version;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "getup_filename")
    private String fileName;

    @Column(name = "was_Response_Received")
    private Boolean wasResponseReceived;


    @Column(name = "was_Collection_Received")
    private Boolean wasCollectionReceived;

}
