package com.chartercom.rewardsprogram.vo;

import java.time.LocalDate;
import java.util.List;

import com.chartercom.rewardsprogram.domain.Customer;
import com.chartercom.rewardsprogram.domain.PurchaseReward;

public class CustomerPointsResponse {
	private Customer customer;
	private List<RewardPoint> rewardPoints;
	private Integer totalEarnedPoints;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<RewardPoint> getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(List<RewardPoint> rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Integer getTotalEarnedPoints() {
		return totalEarnedPoints;
	}
	public void setTotalEarnedPoints(Integer totalEarnedPoints) {
		this.totalEarnedPoints = totalEarnedPoints;
	}
	
	public static class RewardPoint {
		private Integer pointsEarned;
		private LocalDate dateCreated;
		
		public Integer getPointsEarned() {
			return pointsEarned;
		}
		public void setPointsEarned(Integer pointsEarned) {
			this.pointsEarned = pointsEarned;
		}
		
		public LocalDate getDateCreated() {
			return dateCreated;
		}
		public void setDateCreated(LocalDate dateCreated) {
			this.dateCreated = dateCreated;
		}
	}
}
