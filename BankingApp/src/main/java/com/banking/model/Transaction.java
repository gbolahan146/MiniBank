package com.banking.model;



import javax.persistence.UniqueConstraint;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String transactionType;
	
	private double amount;
	
	private String sender;
	
	private String recipient;
	
	private String paymentMethod;
	
	private Date date;

	
//	@ManyToOne
//    @JoinColumn(name="customer_id")
//    private Customer customer;

	
	public Transaction() {
	}


	
	public Transaction(String transactionType, double amount, String sender, String recipient, String paymentMethod, Date date) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.sender = sender;
		this.recipient = recipient;
		this.paymentMethod = paymentMethod;
		this.date = date;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getRecipient() {
		return recipient;
	}


	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	

	
	
}
