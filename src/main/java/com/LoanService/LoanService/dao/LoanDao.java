package com.LoanService.LoanService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoanService.LoanService.model.Loan;
import com.LoanService.LoanService.repository.LoanRepository;

@Service
public class LoanDao {

	@Autowired
	LoanRepository loanRepository;
	
	public List<Loan> findAll(){
		return loanRepository.findAll();
	}
	
	public Loan findById(Long id) {
		return loanRepository.findById(id).get(); 
	}
	
	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}
	
	public void delete(Long id) {
		loanRepository.deleteById(id);
	}
}
