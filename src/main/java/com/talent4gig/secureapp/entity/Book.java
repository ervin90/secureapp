package com.talent4gig.secureapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "libri")
public class Book {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "genere")
	private String genre;
	
	@Column(name = "scrittore")
	private String author;
}
