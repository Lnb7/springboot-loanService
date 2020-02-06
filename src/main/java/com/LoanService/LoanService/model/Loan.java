package com.LoanService.LoanService.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "LoanTable")
@EntityListeners(AuditingEntityListener.class)
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanId;
	
	
	private Long amount;
	
	
	private Long interest;


	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getInterest() {
		return interest;
	}

	public void setInterest(Long interest) {
		this.interest = interest;
	}
	
	
}
