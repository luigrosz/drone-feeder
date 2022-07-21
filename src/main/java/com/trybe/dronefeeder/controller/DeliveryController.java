package com.trybe.dronefeeder.controller;

import com.trybe.dronefeeder.dto.DeliveryDto;
import com.trybe.dronefeeder.model.DeliveryModel;
import com.trybe.dronefeeder.service.DeliveryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

  @Autowired
  private DeliveryService deliveryService;

  /** create controller. */
  @PostMapping()
  public ResponseEntity<DeliveryModel> create(@RequestBody DeliveryDto delivery) {
    DeliveryModel deliveryCreated = deliveryService.create(delivery);
    return ResponseEntity.status(HttpStatus.CREATED).body(deliveryCreated);
  }

  /** getAll controller. */
  @GetMapping()
  public ResponseEntity<List<DeliveryModel>> findAll() {
    List<DeliveryModel> delivery = deliveryService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(delivery);
  }

  /** findById controller. */
  @GetMapping("/{id}")
  public ResponseEntity<DeliveryModel> findById(@PathVariable("id") Long id) {
    DeliveryModel delivery = deliveryService.findById(id);
    return ResponseEntity.ok(delivery);
  }

  /** update controller. */
  @PutMapping("/{id}")
  public ResponseEntity<DeliveryModel> edit(
      @RequestBody DeliveryDto delivery,
      @PathVariable("id") Long id) {
    DeliveryModel edited = deliveryService.update(delivery, id);
    return ResponseEntity.status(HttpStatus.OK).body(edited);
  }

  /** delete controller. */
  @DeleteMapping("/{id}")
  public ResponseEntity<DeliveryModel> delete(@PathVariable("id") Long id) {
    DeliveryModel removed = deliveryService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body(removed);
  }
}