package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;


public interface CarService {
	CarModel addCar(CarModel car);
	void deleteCar(CarModel car);
	void updateCar(long id, CarModel car);
	List<CarModel> allCar();
	Optional<CarModel> getCarDetailById(Long id);
}
