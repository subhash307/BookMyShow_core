package com.subhash.bookmyshow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Screen {
	
	@Id
	@GeneratedValue
	private Long id;
	private String screenName;
	@OneToOne(targetEntity = Movie.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "sm_fk", referencedColumnName = "id")
	private Movie movie;


}
