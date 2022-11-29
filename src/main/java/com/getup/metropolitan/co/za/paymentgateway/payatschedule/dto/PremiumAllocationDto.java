package com.getup.metropolitan.co.za.paymentgateway.payatschedule.dto;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class PremiumAllocationDto implements Serializable {

    private String processMonth;
    private String paymentPartner;
    private String getupPlanType;
    private String policyNumber;
    private String methodOfPayment;
    private Double premium_allocation_amount;
    private String created_at;
}
