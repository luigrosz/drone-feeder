package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DroneDto;
import com.trybe.dronefeeder.exceptions.BadRequestException;
import com.trybe.dronefeeder.exceptions.ResourceNotFoundException;
import com.trybe.dronefeeder.model.DroneModel;
import com.trybe.dronefeeder.repository.DroneRepository;
import com.trybe.dronefeeder.validations.ValidateBody;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

  @Autowired
  private DroneRepository droneRepository;

  /** find all. */
  public List<DroneModel> findAll() {
    return droneRepository.findAll();
  }

  /** create. */
  public DroneModel create(DroneDto drone) {
    DroneModel droneModel = new DroneModel();
    ValidateBody.latitude(drone.getLatitude());
    ValidateBody.longitude(drone.getLongitude());
    droneModel.setLatitude(drone.getLatitude());
    droneModel.setLongitude(drone.getLongitude());
    try {
      Date date = ValidateBody.date(drone.getLastMaintenance());
      droneModel.setLastMaintenance(date.toString());
    } catch (Exception e) {
      throw new BadRequestException("The date of the request is not valid");
    }
    return droneRepository.save(droneModel);
  }

  /** find by Id. */
  public DroneModel findById(Long id) {
    return droneRepository.findById(id).map(drone -> drone)
        .orElseThrow(() -> new ResourceNotFoundException("No id was found"));
  }

  /** update. */
  public DroneModel edit(DroneDto drone, Long id) {
    return droneRepository.findById(id).map(toUpdate -> {
      ValidateBody.latitude(drone.getLatitude());
      ValidateBody.longitude(drone.getLongitude());
      toUpdate.setLatitude(drone.getLatitude());
      toUpdate.setLongitude(drone.getLongitude());
      try {
        Date date = ValidateBody.date(drone.getLastMaintenance());
        toUpdate.setLastMaintenance(date.toString());
      } catch (Exception e) {
        throw new BadRequestException("The date of the request is not valid");
      }
      return droneRepository.save(toUpdate);
    }).orElseThrow(() -> new ResourceNotFoundException(
        "Not possible to edit, the provided id does not exist"));
  }

  /** delete. */
  public DroneModel delete(Long id) {
    return droneRepository.findById(id).map(toDelete -> {
      droneRepository.deleteById(id);
      return toDelete;
    }).orElseThrow(
        () -> new ResourceNotFoundException(
            "Not possible to delete, the provided id does not exist"));
  }
}