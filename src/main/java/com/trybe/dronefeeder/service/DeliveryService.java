package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DeliveryDto;
import com.trybe.dronefeeder.exceptions.BadRequestException;
import com.trybe.dronefeeder.model.DeliveryModel;
import com.trybe.dronefeeder.repository.DeliveryRepository;
import com.trybe.dronefeeder.repository.DroneRepository;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
  @Autowired
  private DeliveryRepository deliveryRepository;

  @Autowired
  private DroneRepository droneRepository;

  /** find all. */
  public List<DeliveryModel> findAll() {
    return deliveryRepository.findAll();
  }

  /** create. */
  public DeliveryModel create(DeliveryDto delivery) {
    DeliveryModel deliveryModel = new DeliveryModel();

    return droneRepository.findById(delivery.getDrone().getId()).map(drone -> {
      deliveryModel.setDelivery(delivery.getDelivery());
      deliveryModel.setTime(delivery.getTime());
      deliveryModel.setDrone(drone);
      return deliveryRepository.save(deliveryModel);
    }).orElseThrow(() -> new BadRequestException("Drone id does not exist"));

  }

  /** find by Id. */
  public DeliveryModel findById(Long id) {
    return deliveryRepository.findById(id).map(delivery -> delivery)
        .orElseThrow(() -> new NotFoundException("No id was found"));
  }

  /** update. */
  public DeliveryModel update(DeliveryDto delivery, Long id) {
    return deliveryRepository.findById(id).map(toUpdate -> {
      toUpdate.setDelivery(delivery.getDelivery());
      toUpdate.setTime(delivery.getTime());

      return deliveryRepository.save(toUpdate);
    }).orElseThrow(() -> new NotFoundException(
        "Not possible to edit, the provided id does not exist"));
  }

  /** delete. */
  public DeliveryModel delete(Long id) {
    return deliveryRepository.findById(id).map(toDelete -> {
      deliveryRepository.deleteById(id);
      return toDelete;
    }).orElseThrow(
        () -> new NotFoundException(
            "Not possible to delete, the provided id does not exist"));
  }
}