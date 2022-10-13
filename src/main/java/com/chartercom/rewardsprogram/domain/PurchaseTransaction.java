package com.chartercom.rewardsprogram.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE_TRANSACTION",schema="CUSTOMER_SCHEMA")
public class PurchaseTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer customerId;
	private Double amount;
	private LocalDate transactionDate;
	private String processIndicator;
	
	public PurchaseTransaction() {}
	
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getProcessIndicator() {
		return processIndicator;
	}
	public void setProcessIndicator(String processIndicator) {
		this.processIndicator = processIndicator;
	}
	
}
