package com.chartercom.rewardsprogram.business;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.chartercom.rewardsprogram.domain.PurchaseReward;
import com.chartercom.rewardsprogram.domain.PurchaseTransaction;

@Component
public class RewardsProgramProcessor {
    private static final Logger logger = LogManager.getLogger(RewardsProgramProcessor.class);

	public int calculateRewardsPoints(PurchaseTransaction transaction) {
		double transactionAmount=transaction.getAmount();
		int processAmount=(int) transactionAmount;
		int pointsEarnedBracket100=0;
		int pointsEarnedBracket50=0;
		
		if (processAmount>100) {
			pointsEarnedBracket100=(processAmount-100)*2;
			processAmount=100;
		}
		
		if (processAmount>50) {
			pointsEarnedBracket50=(processAmount-50)*1;
		}
		
		
		return (pointsEarnedBracket100+pointsEarnedBracket50);
	}
	
	public List<PurchaseReward> processPurchaseTransactions(List<PurchaseTransaction> transactions) {
		List<PurchaseReward> rewards=transactions.stream()
		.map(transaction->{
			PurchaseReward reward=new PurchaseReward();
			reward.setId(transaction.getId());
			reward.setCustomerId(transaction.getCustomerId());
			reward.setPurchaseTransactionId(transaction.getId());
			reward.setPointsEarned(calculateRewardsPoints(transaction));
			reward.setDateCreated(LocalDate.now());
			return reward;
		})
		.collect(Collectors.toList());		
		return rewards;
	}
}
