package com.sv.iuh.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.iuh.server.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {

}
