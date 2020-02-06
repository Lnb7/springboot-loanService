package com.LoanService.LoanService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoanService.LoanService.dao.LoanDao;
import com.LoanService.LoanService.model.Loan;

@RestController
@RequestMapping("/bank")
public class LoanController {

	@Autowired
	LoanDao dao;
	
	@GetMapping("/loans")
	public List<Loan> getAllLoans(){
		return dao.findAll();
	}
	
	@GetMapping("/loans/{id}")
	public Loan findLoanById(@PathVariable(value = "id")Long id) {
		return dao.findById(id);
	}
	
	@PostMapping("/loans")
	public Loan saveLoan(@Valid @RequestBody Loan loan) {
		return dao.save(loan);
	}
	
	@PutMapping("/loans/{id}")
	public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id")Long id,@Valid @RequestBody Loan loan) {
		
		Loan findLoan = dao.findById(id);
		
		if(findLoan == null) {
			ResponseEntity.notFound().build();
		}
		
		findLoan.setAmount(loan.getAmount());
		findLoan.setInterest(loan.getInterest());
		
		Loan updateLoan = dao.save(findLoan);
		return ResponseEntity.ok().body(updateLoan);
	}
	
	@DeleteMapping("/loan/{id}")
	public ResponseEntity<Loan> deleteLoan(Long id){
		
		Loan findLoan = dao.findById(id);
		
		if(findLoan == null) {
			ResponseEntity.notFound().build();
		}
		
		dao.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
