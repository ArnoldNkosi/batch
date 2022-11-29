package com.getup.metropolitan.co.za.paymentgateway.payatschedule.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(schema = "audit", name = "tbl_getup_bill_payment_header")
@Getter
@Setter
public class BillPaymentHeader {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "process_month")
    private String processmonth;

    @Column(name = "record_type")
    private String recordType;

    @Column(name = "issuer_prefix")
    private String issuerPrefix;

    @Column(name = "file_open_time")
    private Timestamp fileOpenTime;

    @Column(name = "filename")
    private String fileName;


}
