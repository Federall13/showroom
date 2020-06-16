package com.example.showroom.controller;

import com.example.showroom.model.Car;
import com.example.showroom.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carRepository.findById(id);
    }

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable Long id) {
        Car carDb = carRepository.getOne(id);
        carDb.setColor(car.getColor());
        carDb.setYear(car.getYear());
        return carRepository.save(carDb);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
       carRepository.deleteById(id);
       return "delete " + id;
    }
}
