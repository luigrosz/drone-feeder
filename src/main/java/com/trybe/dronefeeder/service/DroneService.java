package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DroneDto;
import com.trybe.dronefeeder.exceptions.ResourceNotFoundException;
import com.trybe.dronefeeder.model.DroneModel;
import com.trybe.dronefeeder.repository.DroneRepository;
import com.trybe.dronefeeder.validations.ValidateBody;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

  @Autowired
  private DroneRepository droneRepository;

  private DroneDto convertToDto(DroneModel entity) {
    return new DroneDto(entity);
  }

  /** find all. */
  public List<DroneDto> findAll() {
    return droneRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
  }

  /** create. */
  public DroneDto create(DroneDto drone) {
    DroneModel droneModel = new DroneModel();
    ValidateBody.latitude(drone.getLatitude());
    ValidateBody.longitude(drone.getLongitude());
    droneModel.setLatitude(drone.getLatitude());
    droneModel.setLongitude(drone.getLongitude());
    String date = ValidateBody.date(drone.getLastMaintenance());
    droneModel.setLastMaintenance(date);

    return new DroneDto(droneRepository.save(droneModel));
  }

  /** find by Id. */
  public DroneDto findById(Long id) {
    return droneRepository.findById(id).map(this::convertToDto)
        .orElseThrow(() -> new ResourceNotFoundException("No id was found"));
  }

  /** update. */
  public DroneDto update(DroneDto drone, Long id) {
    return droneRepository.findById(id).map(toUpdate -> {
      ValidateBody.latitude(drone.getLatitude());
      ValidateBody.longitude(drone.getLongitude());
      toUpdate.setLatitude(drone.getLatitude());
      toUpdate.setLongitude(drone.getLongitude());
      String date = ValidateBody.date(drone.getLastMaintenance());
      toUpdate.setLastMaintenance(date);
      return new DroneDto(droneRepository.save(toUpdate));
    }).orElseThrow(() -> new ResourceNotFoundException(
        "Not possible to edit, the provided id does not exist"));
  }

  /** delete. */
  public DroneDto delete(Long id) {
    return droneRepository.findById(id).map(toDelete -> {
      droneRepository.deleteById(id);
      return new DroneDto(toDelete);
    }).orElseThrow(
        () -> new ResourceNotFoundException(
            "Not possible to delete, the provided id does not exist"));
  }
}