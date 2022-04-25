package com.subhash.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	private String movieName;
	private String movieCost;

	
}
