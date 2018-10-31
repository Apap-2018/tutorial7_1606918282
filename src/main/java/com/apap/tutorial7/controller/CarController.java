package com.apap.tutorial7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.service.CarService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		System.out.println(car.getDealer());
		return carService.addCar(car);
	}
	
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarDetailById(carId).get();
	}
	
	@DeleteMapping()
	private String deleteCar(@RequestParam ("carId") long id, Model model) {
		CarModel car = carService.getCarDetailById(id).get();
		carService.deleteCar(car);
		return "Car has been deleted";
	}
	
	@PutMapping(value = "/{id}")
	private String updateCarSubmit(
			@PathVariable (value = "id") long id,
			@RequestParam("brand") String brand,
			@RequestParam("type") String type,
			@RequestParam("price") long price,
			@RequestParam("amount") int amount){
		
		CarModel car = (CarModel) carService.getCarDetailById(id).get();
		if(car.equals(null)) {
			return "Couldn't find your dealer";
		}
		
		car.setBrand(brand);
		car.setType(type);
		car.setPrice(price);
		car.setAmount(amount);
		
		carService.updateCar(id, car);
		return "car update success";
	}

	@GetMapping()
	private List<CarModel> viewAllCar(Model model){
		return carService.allCar();
	}

}
