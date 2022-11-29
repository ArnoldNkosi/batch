package com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository;
import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentDataRepository  extends JpaRepository<BillPayment,Long> {
}
