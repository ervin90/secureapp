package com.talent4gig.secureapp.resource;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanQuote {
	private int loanAmount;
	private BigDecimal rate;
	private BigDecimal monthlyPayment;
	private BigDecimal totalPayment;
}
