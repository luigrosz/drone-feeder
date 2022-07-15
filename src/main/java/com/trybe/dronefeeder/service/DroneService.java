package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DroneDto;
import com.trybe.dronefeeder.exceptions.BadRequestException;
import com.trybe.dronefeeder.exceptions.ResourceNotFoundException;
import com.trybe.dronefeeder.model.DroneModel;
import com.trybe.dronefeeder.repository.DroneRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {
  private String latitudeRegex = "^-?([1-8]?[1-9]|[1-9]0)\\.{1}\\d{1,6}";
  private String longitudeRegex = "^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,6}";

  @Autowired
  private DroneRepository droneRepository;

  /** find all. */
  public List<DroneModel> findAll() {
    return droneRepository.findAll();
  }

  /** create. */
  public DroneModel create(DroneDto drone) {
    DroneModel droneModel = new DroneModel();
    if (!drone.getLatitude().matches(latitudeRegex)) {
      throw new BadRequestException("The latitude of the request is wrong");
    }
    if (!drone.getLongitude().matches(longitudeRegex)) {
      throw new BadRequestException("The longitude of the request is wrong");
    }
    droneModel.setLatitude(drone.getLatitude());
    droneModel.setLongitude(drone.getLongitude());
    try {
      Date date = new SimpleDateFormat("yyyy-MM-dd").parse(drone.getLastMaintenance());

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate parsedDate = LocalDate.parse(drone.getLastMaintenance(), formatter);
      if (!parsedDate.isAfter(LocalDate.of(2022, 07, 14))) {
        throw new Exception();
      }

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
      if (!drone.getLatitude().matches(latitudeRegex)) {
        throw new BadRequestException("The latitude of the request is wrong");
      }
      if (!drone.getLongitude().matches(longitudeRegex)) {
        throw new BadRequestException("The longitude of the request is wrong");
      }
      toUpdate.setLatitude(drone.getLatitude());
      toUpdate.setLongitude(drone.getLongitude());

      try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(drone.getLastMaintenance());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(drone.getLastMaintenance(), formatter);
        if (!parsedDate.isAfter(LocalDate.of(2022, 07, 14))) {
          throw new Exception();
        }
        toUpdate.setLastMaintenance(date.toString());
      } catch (Exception e) {
        throw new BadRequestException("The date of the request is not valid");
      }
      droneRepository.save(toUpdate);
      return toUpdate;
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