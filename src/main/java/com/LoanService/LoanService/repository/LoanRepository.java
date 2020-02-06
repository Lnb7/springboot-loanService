package com.LoanService.LoanService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LoanService.LoanService.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
