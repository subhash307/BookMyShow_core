package com.subhash.bookmyshow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Theater {
	
	@Id
	@GeneratedValue
	private Long id;
	private String theaterName;
	@OneToMany(targetEntity = Screen.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ts_fk", referencedColumnName = "id")
	private List<Screen> screen;
	private String owner;


}
