package com.talent4gig.secureapp.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "prestatori")
public class Lender {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "tasso")
	private BigDecimal rate;

	@Column(name = "disponibilita")
	private Integer amount;
}
