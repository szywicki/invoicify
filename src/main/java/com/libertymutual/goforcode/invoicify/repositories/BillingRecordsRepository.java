package com.libertymutual.goforcode.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.invoicify.models.BillingRecord;

@Repository
public interface BillingRecordsRepository extends JpaRepository<BillingRecord, Long> {

}
