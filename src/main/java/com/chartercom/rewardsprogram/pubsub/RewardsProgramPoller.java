package com.chartercom.rewardsprogram.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chartercom.rewardsprogram.business.RewardsProgramProcessor;
import com.chartercom.rewardsprogram.domain.PurchaseReward;
import com.chartercom.rewardsprogram.domain.PurchaseTransaction;
import com.chartercom.rewardsprogram.repository.PurchaseRewardRepository;
import com.chartercom.rewardsprogram.repository.PurchaseTransactionRepository;

@Component
public class RewardsProgramPoller {
	@Autowired
	private PurchaseTransactionRepository transactionRepository;

	@Autowired
	private PurchaseRewardRepository rewardRepository;

	@Autowired
	private RewardsProgramProcessor processor;

	private Thread pollerThread;
	
	private static final Logger logger = LogManager.getLogger(RewardsProgramPoller.class);

	public RewardsProgramPoller() {
		logger.info("Poller has been initialized");
	}

	public void processCustomerRewards() {
		try {
			while (true) {
				Thread.sleep(5000L);
				logger.info("Checking purchase transaction table...");
				List<PurchaseTransaction> purchaseTransactions = (List<PurchaseTransaction>) transactionRepository
						.findAllUnprocessedTransactions();

				List<PurchaseReward> purchaseRewards=new ArrayList<>();
				if (purchaseTransactions.size() > 0) {
					System.out.println("Calculating rewards points...");
					purchaseRewards =  processor.processPurchaseTransactions(purchaseTransactions);
				}
				
				purchaseRewards.forEach(reward -> {
					
					logger.info("Processing " + reward);

					PurchaseTransaction purchaseTransaction = purchaseTransactions.stream()
							.filter(tran -> tran.getId() == reward.getPurchaseTransactionId()).findFirst().get();
					purchaseTransaction.setProcessIndicator("C");

					transactionRepository.save(purchaseTransaction);
					rewardRepository.save(reward);

					logger.info("Completed processing " + reward);
				});

				logger.info("Processed Transactions: " + purchaseRewards.size());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void start() {
		logger.info("Poller has been started");
		pollerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				processCustomerRewards();
			}

		});

		pollerThread.start();
	}
}
