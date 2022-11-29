package com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPaymentHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentHeaderRepository  extends JpaRepository<BillPaymentHeader,Long> {
}
