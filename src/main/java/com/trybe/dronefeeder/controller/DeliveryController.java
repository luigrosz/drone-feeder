package com.trybe.dronefeeder.controller;

import com.trybe.dronefeeder.dto.DeliveryDto;
// import com.trybe.dronefeeder.model.DroneModel;
// import com.trybe.dronefeeder.service.DroneService;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

  // @Autowired
  // private DeliveryController droneService;

  /** create controller. */
  @PostMapping()
  public ResponseEntity<DeliveryDto> create(@RequestBody DeliveryDto delivery) {
  //   droneService.create(drone);
    return ResponseEntity.status(HttpStatus.CREATED).body(delivery);
  }

  /** getAll controller. */
  @GetMapping()
  public ResponseEntity<String> findAll() {
    // public ResponseEntity<List<DroneModel>> findAll() {
    // List<DroneModel> drones = droneService.findAll();
    return ResponseEntity.ok("drones");
  }

  /** update controller. */
  @PutMapping("/{id}")
  public ResponseEntity<String> edit(@RequestBody DeliveryDto delivery, @PathVariable("id") Long id) {
    // droneService.edit(drone, id);
    String message = String.format("ID [%d] atualizado", id);
    return ResponseEntity.ok(message);
  }

  /** delete controller. */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") Long id) {
    // droneService.delete(id);
    String message = String.format("ID [%d] removido", id);
    return ResponseEntity.status(HttpStatus.).body(message);
  }
} 