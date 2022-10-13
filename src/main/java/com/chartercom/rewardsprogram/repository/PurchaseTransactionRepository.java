package com.chartercom.rewardsprogram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chartercom.rewardsprogram.domain.PurchaseTransaction;

public interface PurchaseTransactionRepository extends CrudRepository<PurchaseTransaction,Integer>{

	@Query("SELECT t from PurchaseTransaction t where t.processIndicator='N'")
	List<PurchaseTransaction> findAllUnprocessedTransactions();
}
