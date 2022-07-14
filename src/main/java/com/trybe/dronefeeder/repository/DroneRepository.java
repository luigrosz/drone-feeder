package com.trybe.dronefeeder.repository;

import com.trybe.dronefeeder.model.DroneModel;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<DroneModel, Long> {
}
