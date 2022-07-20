package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DeliveryDto;
import com.trybe.dronefeeder.model.DeliveryModel;
import com.trybe.dronefeeder.repository.DeliveryRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
  @Autowired
  private DeliveryRepository deliveryRepository;

  private DeliveryDto  convertToDto(DeliveryModel entity) {
    return new DeliveryDto(entity);
  }

  /** find all. */
  public List<DeliveryDto> findAll() {
    return deliveryRepository.findAll().stream()
    .map(this::convertToDto).collect(Collectors.toList());
  }

  /** create. */
  public DeliveryDto create(DeliveryDto delivery) {
    DeliveryModel deliveryModel = new DeliveryModel();
    deliveryModel.setDelivery(delivery.getDelivery());
    deliveryModel.setTime(delivery.getTime());
    return new DeliveryDto(deliveryRepository.save(deliveryModel));
  }

  /** find by Id. */
  public DeliveryDto findById(Long id) {
    return deliveryRepository.findById(id).map(this::convertToDto)
        .orElseThrow(() -> new NotFoundException("No id was found"));
  }

  /** update. */
  public DeliveryDto update(DeliveryDto delivery, Long id) {
    return deliveryRepository.findById(id).map(toUpdate -> {
      toUpdate.setDelivery(delivery.getDelivery());
      toUpdate.setTime(delivery.getTime());
      
      return new DeliveryDto(deliveryRepository.save(toUpdate));
    }).orElseThrow(() -> new NotFoundException(
      "Not possible to edit, the provided id does not exist"));
  }

  /** delete. */
  public DeliveryDto delete(Long id) {
    return deliveryRepository.findById(id).map(toDelete -> {
      deliveryRepository.deleteById(id);
      return new DeliveryDto(toDelete);
    }).orElseThrow(
        () -> new NotFoundException(
          "Not possible to delete, the provided id does not exist"));
  }
}