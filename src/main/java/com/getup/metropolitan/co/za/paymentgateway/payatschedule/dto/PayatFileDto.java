package com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto;

public class PayatFileDto {

    private Long headerId;
    private String recordType;
    private String transactionId;
    private String issuerTransactionId;
    private String accountNumber;
    private String transactionDate;
    private String amount;
    private String transactionFee;
    private String merchantFee;
    private String cashHandlingFee;
    private String settlementAmount;
    private String tenderType;
    private String networkName;
    private String networkReferenceNo;
    private String transactionPointId;
    private String terminalId;
    private String transactionStatus;

    private String processMonth;
    private String issuerPrefix;
    private String fileOpenTime;
    private String fileCloseTime;
    private double recordCount;
    private double totalAmount;

private String fileName;
    public PayatFileDto() {
    }


    public PayatFileDto(Long headerId,String recordType, String processMonth, String issuerPrefix, String fileOpenTime,String fileName) {
        this.headerId = headerId;
        this.recordType = recordType;
        this.processMonth = processMonth;
        this.issuerPrefix = issuerPrefix;
        this.fileOpenTime = fileOpenTime;
        this.fileName = fileName;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getfileName() {
        return fileName;
    }

    public void setfileName(String fileName) {
        fileName = fileName;
    }

    public String getProcessMonth() {
        return processMonth;
    }

    public void setProcessMonth(String processMonth) {
        this.processMonth = processMonth;
    }

    public String getIssuerPrefix() {
        return issuerPrefix;
    }

    public void setIssuerPrefix(String issuerPrefix) {
        this.issuerPrefix = issuerPrefix;
    }

    public String getFileOpenTime() {
        return fileOpenTime;
    }

    public void setFileOpenTime(String fileOpenTime) {
        this.fileOpenTime = fileOpenTime;
    }

    public String getFileCloseTime() {
        return fileCloseTime;
    }

    public void setFileCloseTime(String fileCloseTime) {
        this.fileCloseTime = fileCloseTime;
    }

    public double getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(double recordCount) {
        this.recordCount = recordCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getIssuerTransactionId() {
        return issuerTransactionId;
    }

    public void setIssuerTransactionId(String issuerTransactionId) {
        this.issuerTransactionId = issuerTransactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(String transactionFee) {
        this.transactionFee = transactionFee;
    }

    public String getMerchantFee() {
        return merchantFee;
    }

    public void setMerchantFee(String merchantFee) {
        this.merchantFee = merchantFee;
    }

    public String getCashHandlingFee() {
        return cashHandlingFee;
    }

    public void setCashHandlingFee(String cashHandlingFee) {
        this.cashHandlingFee = cashHandlingFee;
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkReferenceNo() {
        return networkReferenceNo;
    }

    public void setNetworkReferenceNo(String networkReferenceNo) {
        this.networkReferenceNo = networkReferenceNo;
    }

    public String getTransactionPointId() {
        return transactionPointId;
    }

    public void setTransactionPointId(String transactionPointId) {
        this.transactionPointId = transactionPointId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
