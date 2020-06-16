package com.example.showroom.repository;

import com.example.showroom.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
