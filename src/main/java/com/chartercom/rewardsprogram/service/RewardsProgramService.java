package com.chartercom.rewardsprogram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chartercom.rewardsprogram.domain.Customer;
import com.chartercom.rewardsprogram.domain.PurchaseReward;
import com.chartercom.rewardsprogram.exceptions.CustomerNotFoundException;
import com.chartercom.rewardsprogram.repository.CustomerRepository;
import com.chartercom.rewardsprogram.repository.PurchaseRewardRepository;
import com.chartercom.rewardsprogram.vo.CustomerPointsResponse;

@Service
public class RewardsProgramService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PurchaseRewardRepository purchaseRewardRepository;
	
	public CustomerPointsResponse getCustomerPoints(Integer id) {
		//Fetch Customer Information
		Optional<Customer> customerOpt=customerRepository.findById(id);
		CustomerPointsResponse customerPointsResponse=new CustomerPointsResponse();
		if (customerOpt.isPresent()) {
			customerPointsResponse.setCustomer(customerOpt.get());
		} else {
			throw new CustomerNotFoundException("Customer not found!");
		}
		
		
		//Fetch Rewards Points
		List<PurchaseReward> purchaseRewards=purchaseRewardRepository.findAllbyCustomerId(id);
		if (purchaseRewards!=null && purchaseRewards.size()>0) {
			List<CustomerPointsResponse.RewardPoint> rewardPoints=new ArrayList<>();
			for (PurchaseReward purchaseReward:purchaseRewards) {
				CustomerPointsResponse.RewardPoint rewardPoint=new CustomerPointsResponse.RewardPoint();
				rewardPoint.setPointsEarned(purchaseReward.getPointsEarned());
				rewardPoint.setDateCreated(purchaseReward.getDateCreated());
				rewardPoints.add(rewardPoint);
			}
			customerPointsResponse.setRewardPoints(rewardPoints);
		}
		
		//Get Total Reward Points
		int totalRewardPoints=0;
		if (purchaseRewards!=null && purchaseRewards.size()>0) {
			totalRewardPoints=purchaseRewards.stream().map(tran->tran.getPointsEarned()).reduce(0,Integer::sum);
			customerPointsResponse.setTotalEarnedPoints(totalRewardPoints);
		}
		
		
		return customerPointsResponse;
	}
}
