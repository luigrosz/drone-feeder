package com.trybe.dronefeeder.repository;

import com.trybe.dronefeeder.model.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryDto extends JpaRepository<DeliveryModel, Integer> {
}
