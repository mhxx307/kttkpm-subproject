package com.sv.iuh.motorbikeserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.iuh.motorbikeserver.model.MotorBike;

@Repository
public interface MotorBikeRepository extends JpaRepository<MotorBike, Integer>{
	

}
