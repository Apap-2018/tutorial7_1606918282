package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.CarDb;
import com.apap.tutorial7.repository.DealerDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDb carDb;
	private DealerDb dealerDb;
	
	@Override
	public Optional<CarModel> getCarDetailById(Long id) {
		// TODO Auto-generated method stub
		return carDb.findById(id);
	}

	@Override
	public CarModel addCar(CarModel car) {
		// TODO Auto-generated method stub
		System.out.println(car);
//		DealerModel dealer = dealerDb.getOne(car);
//		car.setDealer(dealer);
		return carDb.save(car);
	}
	
	@Override
	public void deleteCar(CarModel car){
		// TODO Auto-generated method stub
		carDb.delete(car);
		
	}
	
	@Override
	public List<CarModel> allCar() {
		// TODO Auto-generated method stub
		return carDb.findAll();
	}

	public List<CarModel> getListCarOrderByPriceAsc(Long dealerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCar(long id, CarModel car) {
		// TODO Auto-generated method stub
		CarModel updated = carDb.getOne(id);
		updated.setBrand(car.getBrand());
		updated.setAmount(car.getAmount());
		updated.setPrice(car.getPrice());
		updated.setType(car.getType());
		
		carDb.save(updated);
	}

}