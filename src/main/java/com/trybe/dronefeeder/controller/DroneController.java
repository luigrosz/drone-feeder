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
  @PostMapping("/hello")
  public ResponseEntity<String> create(@RequestBody DroneDto drone) {
    droneService.create(drone);
    
    return ResponseEntity.status(HttpStatus.CREATED).body("Inserido");
  }

  /** getAll controller. */
  @GetMapping()
  public ResponseEntity<List<DroneModel>> findAll() {
    List<DroneModel> drones = droneService.findAll();
    return ResponseEntity.ok(drones);
  }

  /** update controller. */
  @PutMapping("/{id}")
  public ResponseEntity<String> edit(@RequestBody DroneDto drone, @PathVariable("id") Long id) {
    droneService.edit(drone, id);
    String message = String.format("ID [%d] atualizado", id);
    return ResponseEntity.ok(message);
  }

  /** delete controller. */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") Long id) {
    droneService.delete(id);
    String message = String.format("ID [%d] removido", id);
    return ResponseEntity.ok(message);
  }
} 