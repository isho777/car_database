package com.packt.cardatabase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;


@Entity
//@Table(name="'car'") // Optional annotation to force usage of reserved words in sql
//@Transactional
public class Car {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)		
	 @Column(name="\"id\"") 
	 private long id;		
	 @Column(name="\"brand\"") 
	 private String brand;	
	 @Column(name="\"model\"") 
	 private String model;
	 @Column(name="\"color\"") 
	 private String color;
	 @Column(name="\"registerNumber\"") 	
	 private String registerNumber;
	 @Column(name="\"year\"")// Optional annotation to force usage of reserved words in sql
	 private int year;
	 @Column(name="\"price\"")
	 private int price;
	 	 
	
	 @ManyToOne(fetch=FetchType.LAZY) //many of this class (Car) to one foreign class instance (Owner) 
	 @JoinColumn(name="\"owner\"") //this is a @joincolumn here and does not use @Column annotation. label must match the below entity exactly. 
	 private Owner owner;  //joins to foreign table (Owner) with known id column. will fetch Owner objects in memory but will display only "owner" id/key for this column
	 
	 public Car() {}
	 
	 public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner) {
			 super();
			 this.brand = brand;
			 this.model = model;
			 this.color = color;
			 this.registerNumber = registerNumber;
			 this.year = year;
			 this.price = price;
			 this.owner = owner;
			 }

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

