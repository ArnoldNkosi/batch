package com.getup.metropolitan.co.za.paymentgateway.payatschedule.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(schema = "audit", name = "tbl_getup_bill_payment_trailer")
@Getter
@Setter
public class BillPaymentTrailer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Header_Id")
    private Long headerId;

    @Column(name = "Record_Type")
    private String recordType;

    @Column(name = "Record_Count")
    private double recordCount;

    @Column(name = "Total_Amount")
    private double totalAmount;

    @Column(name = "File_Close_Time")
    private Timestamp fileCloseTime;

}

