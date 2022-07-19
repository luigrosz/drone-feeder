package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DeliveryDto;
import com.trybe.dronefeeder.model.DeliveryModel;
import com.trybe.dronefeeder.repository.DeliveryRepository;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
  @Autowired
  private DeliveryRepository deliveryRepository;

  /** find all. */
  public List<DeliveryModel> findAll() {
    return deliveryRepository.findAll();
  }

  /** create. */
  public DeliveryModel create(DeliveryDto delivery) {
    DeliveryModel deliveryModel = new DeliveryModel();
    deliveryModel.setDelivery(delivery.getDelivery());
    deliveryModel.setTime(delivery.getTime());
    return deliveryRepository.save(deliveryModel);
  }

  /** find by Id. */
  public DeliveryModel findById(Long id) {
    return deliveryRepository.findById(id).map(delivery -> delivery)
        .orElseThrow(() -> new NotFoundException("Nenhum registro foi encontrado!"));
  }

  /** update. */
  public DeliveryModel edit(DeliveryDto delivery, Long id) {
    return deliveryRepository.findById(id).map(toUpdate -> {
      toUpdate.setDelivery(delivery.getDelivery());
      toUpdate.setTime(delivery.getTime());
      deliveryRepository.save(toUpdate);
      return toUpdate;
    }).orElseThrow(() -> new NotFoundException("Não é possível editar, o ID informado não existe"));
  }

  /** delete. */
  public DeliveryModel delete(Long id) {
    return deliveryRepository.findById(id).map(toDelete -> {
      deliveryRepository.deleteById(id);
      return toDelete;
    }).orElseThrow(
      () -> new NotFoundException("Não é possível deletar, o ID informado não existe"));
  }
}