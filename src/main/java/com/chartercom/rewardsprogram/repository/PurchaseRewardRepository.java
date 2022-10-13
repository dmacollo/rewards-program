package com.chartercom.rewardsprogram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chartercom.rewardsprogram.domain.PurchaseReward;

public interface PurchaseRewardRepository extends CrudRepository<PurchaseReward,Integer>{
	@Query("SELECT p from PurchaseReward p where p.customerId=:id")
	List<PurchaseReward> findAllbyCustomerId(Integer id);
}
