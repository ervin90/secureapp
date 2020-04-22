package com.talent4gig.secureapp.api;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talent4gig.secureapp.resource.LoanQuote;
import com.talent4gig.secureapp.service.LoanQuoteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/loans")
public class LoanController {
	
	@Autowired private LoanQuoteService loanQuoteService;
	
	@GetMapping("/calculate")
	@Transactional
	public LoanQuote getAllBooks(@RequestParam("amount") Integer amount) {
		log.info("Required loan of amount {}.", amount);	
		return loanQuoteService.calculateLoanQuote(amount);
	}
}
