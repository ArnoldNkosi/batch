package com.getup.metropolitan.co.za.paymentgateway.payatschedule.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "audit", name = "tbl_getup_bill_payment_data")
public class BillPayment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Header_Id")
    private Long headerId;

    @Column(name = "Record_Type")
    private String recordType;

    @Column(name = "Transaction_Id")
    private String transactionId;

    @Column(name = "Issuer_Transaction_Id")
    private String issuerTransactionId;

    @Column(name = "Account_Number")
    private String accountNumber;

    @Column(name = "Transaction_tsp")
    private Timestamp transactiontsp;

    @Column(name = "Amount")
    private double amount;

    @Column(name = "Transaction_Fee")
    private double transactionFee;

    @Column(name = "Merchant_Fee")
    private double merchantFee;

    @Column(name = "Cash_Handling_Fee")
    private double cashHandlingFee;

    @Column(name = "Settlement_Amount")
    private double settlementAmount;

    @Column(name = "Tender_Type")
    private String tenderType;

    @Column(name = "Network_Name")
    private String networkName;

    @Column(name = "Network_Reference_Number")
    private String networkReferenceNumber;

    @Column(name = "Transaction_Point_Id")
    private String transactionPointId;

    @Column(name = "Terminal_Id")
    private String terminalId;

    @Column(name = "Transaction_Status")
    private int transactionStatus;
}