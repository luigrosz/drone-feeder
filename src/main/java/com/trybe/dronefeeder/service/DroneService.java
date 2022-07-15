package com.trybe.dronefeeder.service;

import com.trybe.dronefeeder.dto.DroneDto;
import com.trybe.dronefeeder.model.DroneModel;
import com.trybe.dronefeeder.repository.DroneRepository;

import java.util.List;

import javax.ws.rs.NotFoundException;

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
    droneModel.setLatitude(drone.getLatitude());
    droneModel.setLongitude(drone.getLongitude());
    droneModel.setLastMaintenance(drone.getLastMaintance());
    return droneRepository.save(droneModel);
  }

  /** find by Id. */
  public DroneModel findById(Long id) {
    return droneRepository.findById(id).map(drone -> drone)
        .orElseThrow(() -> new NotFoundException("Nenhum registro foi encontrado!"));
  }

  /** update. */
  public DroneModel edit(DroneDto drone, Long id) {
    return droneRepository.findById(id).map(toUpdate -> {
      toUpdate.setLatitude(drone.getLatitude());
      toUpdate.setLongitude(drone.getLongitude());
      toUpdate.setLastMaintenance(drone.getLastMaintance());
      droneRepository.save(toUpdate);
      return toUpdate;
    }).orElseThrow(() -> new NotFoundException("Não é possível editar, o ID informado não existe"));
  }

  /** delete. */
  public DroneModel delete(Long id) {
    return droneRepository.findById(id).map(toDelete -> {
      droneRepository.deleteById(id);
      return toDelete;
    }).orElseThrow(
      () -> new NotFoundException("Não é possível deletar, o ID informado não existe"));
  }
}