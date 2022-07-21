package com.trybe.dronefeeder.controller;

import com.trybe.dronefeeder.dto.DroneDto;
import com.trybe.dronefeeder.model.DroneModel;
import com.trybe.dronefeeder.service.DroneService;

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
@RequestMapping("/drone")
public class DroneController {
  @Autowired
  private DroneService droneService;

  /** create controller. */
  @PostMapping()
  public ResponseEntity<DroneModel> create(@RequestBody DroneDto drone) {
    DroneModel createdEntity = droneService.create(drone);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
  }

  /** getAll controller. */
  @GetMapping()
  public ResponseEntity<List<DroneModel>> findAll() {
    List<DroneModel> drones = droneService.findAll();
    return ResponseEntity.ok(drones);
  }

  /** findById controller. */
  @GetMapping("/{id}")
  public ResponseEntity<DroneModel> findById(@PathVariable("id") Long id) {
    DroneModel drone = droneService.findById(id);
    return ResponseEntity.ok(drone);
  }

  /** update controller. */
  @PutMapping("/{id}")
  public ResponseEntity<DroneModel> update(@RequestBody DroneDto drone,
      @PathVariable("id") Long id) {
    DroneModel updatedEntity = droneService.update(drone, id);
    return ResponseEntity.ok(updatedEntity);
  }

  /** delete controller. */
  @DeleteMapping("/{id}")
  public ResponseEntity<DroneModel> delete(@PathVariable("id") Long id) {
    DroneModel deletedEntity = droneService.delete(id);
    return ResponseEntity.ok(deletedEntity);
  }
}