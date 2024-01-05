package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="vehicles") //if needed to rename the repository end point from usage point of view e.g. you will define controller for  http://localhost:8080/api/vehicles
@RepositoryRestResource // helps to enlist other available endpoints when call http://localhost:8080/api/cars/search
public interface CarRepository extends CrudRepository<Car, Long> { // CrudRepository is already extended by
																	// PagingAndSortingRepository. this is to do help
																	// save processing time in large volume of data

	// Fetch cars by brand
	// List<Car> findByBrand(String brand);//method name is known by repository
	// Alternatively...
	  List<Car> findByBrand(@Param("brand") String brand);

	// Fetch cars by color
	// List<Car> findByColor(String color);
	// Alternatively...
	List<Car> findByColor(@Param("color") String color);

	// Fetch cars by year
	List<Car> findByYear(int year);

	// Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model); // Note the And keyword: its known to the repository for
																// selective process

	List<Car> findByBrandOrColor(String brand, String color); // Note the Or keyword its known to repository for
																// selective process

	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYearAsc(String brand); // NOte the order by

	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1") // ?1 = first parameter, ?2 = second parameter, etc. But Cannot
														// reference ?2 alone in the query without referencing ?1. else
														// require single parameter in the method
	List<Car> findByBrand_Custom1(String v1); // method name does not matter as @query annotation is used for selection

	// @Query("select c from Car c where c.brand like %?1")
	// List<Car> findByBrandEndsWith(String brand);

	// Fetch cars by color

}