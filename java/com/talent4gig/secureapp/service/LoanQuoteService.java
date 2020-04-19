package com.talent4gig.secureapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent4gig.secureapp.entity.Lender;
import com.talent4gig.secureapp.exception.InsufficientLendersException;
import com.talent4gig.secureapp.repository.LenderRepository;
import com.talent4gig.secureapp.resource.LoanQuote;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class LoanQuoteService {
    /**
     * Minimum loan amount in pounds sterling that is allowed to be requested by the user
     */
    final static int MIN_LOAN_AMOUNT = 1000;

    /**
     * Maximum loan amount in pounds sterling that is allowed to be requested by the user
     */
    final static int MAX_LOAN_AMOUNT = 15000;

    /**
     * Loan amount increments that the user is allowed to request in
     */
    final static int LOAN_AMOUNT_INCREMENT = 100;
    
    @Autowired private LenderRepository lenderRepository;
    @Autowired private LoanQuoteCalculator loanQuoteCalculator;
    
	public LoanQuote calculateLoanQuote(int loanAmount) {

		LoanQuote quote = null;

		try {
			List<Lender> lenders = lenderRepository.findAll();
	        lenders.sort((lender1, lender2) -> {
	            final int rateComparison = lender1.getRate().compareTo(lender2.getRate());
	            return rateComparison != 0 ? rateComparison : lender2.getAmount() - lender1.getAmount();
	        });
			quote = loanQuoteCalculator.getQuote(lenders, loanAmount);
		} catch (InsufficientLendersException e) {
			log.info("Insufficient offers from lenders to satisfy the loan. Try a smaller loan amount.");
		}

		return quote;
	}
}
