package com.trybe.dronefeeder.repository;

import com.trybe.dronefeeder.model.DeliveryModel;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@PersistenceContext
public interface DeliveryRepository extends JpaRepository<DeliveryModel, Long> {
}
