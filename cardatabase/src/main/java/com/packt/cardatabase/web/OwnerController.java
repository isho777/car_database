package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@RestController
public class OwnerController {

	@Autowired
	private OwnerRepository repository;
	
	@GetMapping("/owners")
	public Iterable<Owner> getOwners(){ 
		return repository.findAll();
		//fetch and return cars
	}

}