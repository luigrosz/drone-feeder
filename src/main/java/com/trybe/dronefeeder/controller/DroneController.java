package com.trybe.dronefeeder.controller;

import com.trybe.dronefeeder.dto.DroneDto;
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
  public ResponseEntity<DroneDto> create(@RequestBody DroneDto drone) {
    DroneDto createdEntity = droneService.create(drone);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
  }

  /** getAll controller. */
  @GetMapping()
  public ResponseEntity<List<DroneDto>> findAll() {
    List<DroneDto> drones = droneService.findAll();
    return ResponseEntity.ok(drones);
  }

  /** update controller. */
  @PutMapping("/{id}")
  public ResponseEntity<DroneDto> update(@RequestBody DroneDto drone, @PathVariable("id") Long id) {
    DroneDto updatedEntity = droneService.update(drone, id);
    return ResponseEntity.ok(updatedEntity);
  }

  /** delete controller. */
  @DeleteMapping("/{id}")
  public ResponseEntity<DroneDto> delete(@PathVariable("id") Long id) {
    DroneDto deletedEntity = droneService.delete(id);
    return ResponseEntity.ok(deletedEntity);
  }
}