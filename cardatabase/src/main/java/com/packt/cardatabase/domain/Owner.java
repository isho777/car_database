package com.packt.cardatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//This property on the One side (of one to many)If infinite loop happens due to one to many rship
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	// To allow fetching list of Car, under this object (Owner). "owner" is the join column in Car class. 
	//cascade All means delete all cars under owner if owner is deleted!!
	
	@JsonIgnore //If infinite loop happens due to one to many ship
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")													
	private List<Car> cars;           

	public Owner() {
	}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getOwnerid() {
		return id;
	}

	public void setOwnerid(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}