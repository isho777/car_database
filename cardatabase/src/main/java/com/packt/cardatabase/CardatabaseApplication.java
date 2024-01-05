package com.packt.cardatabase;
    
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
@SpringBootApplication
public class CardatabaseApplication  implements CommandLineRunner{
		
	@Autowired
    private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	private static final Logger logger = LoggerFactory.getLogger (CardatabaseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
    
	@Override
	public void run(String... args) throws Exception {
		
    
		//Add owner objects and save these to db
		 //Owner owner1 = new Owner("John" , "Johnson");
		 //Owner owner2 = new Owner("Mary" , "Robinson");
		 //ownerRepository.saveAll(Arrays.asList( owner1, owner2));
		 
		//carRepository.save(new Car("Ford", "Mustang","Red","ADF-1121", 2021, 59000, owner1));
		//carRepository.save(new Car("Nissan", "Leaf","White","SSJ-3002", 2019, 29000, owner2));
		//carRepository.save(new Car("Toyota", "Prius","Silver","KKO-0212", 2020, 39000, owner2));		
		
		//var cars = carRepository.findAll();
		//var cars = carRepository.findByColor("Red");
		//var cars = carRepository.findByBrandAndModel("Ford", "Leaf");
		//var cars = carRepository.findByBrandOrColor("Nissan", "Red");
		//var cars = carRepository.findByBrandOrderByYearAsc("Ford");
		//  var cars = carRepository.findAll();
		//var cars = carRepository.findByBrandEndsWith("rd");
		
		
             
	}
}
