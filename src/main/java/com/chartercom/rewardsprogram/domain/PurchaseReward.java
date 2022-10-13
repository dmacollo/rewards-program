package com.chartercom.rewardsprogram.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE_REWARD",schema="CUSTOMER_SCHEMA")
public class PurchaseReward {
	@Id	
	private Integer id;
	private Integer customerId;
	private Integer purchaseTransactionId;
	private Integer pointsEarned;
	private LocalDate dateCreated;
	
	public PurchaseReward() {}
	
	
	
	public PurchaseReward(Integer id, Integer customerId, Integer purchaseTransactionId, Integer pointsEarned) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.purchaseTransactionId = purchaseTransactionId;
		this.pointsEarned = pointsEarned;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getPurchaseTransactionId() {
		return purchaseTransactionId;
	}
	public void setPurchaseTransactionId(Integer purchaseTransactionId) {
		this.purchaseTransactionId = purchaseTransactionId;
	}
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
	
	@Override
	public String toString() {
		return "PurchaseReward [id=" + id + ", customerId=" + customerId + ", purchaseTransactionId="
				+ purchaseTransactionId + ", pointsEarned=" + pointsEarned + "]";
	}
	
	
}
