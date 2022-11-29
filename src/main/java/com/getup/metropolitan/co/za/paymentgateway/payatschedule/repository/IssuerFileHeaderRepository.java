package com.getup.metropolitan.co.za.paymentgateway.payatschedule.repository;

import com.getup.metropolitan.co.za.paymentgateway.payatschedule.model.IssuerFileHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssuerFileHeaderRepository extends JpaRepository<IssuerFileHeader,Long> {
    public List<IssuerFileHeader> findByWasCollectionReceived(boolean was_collection_received);
}
