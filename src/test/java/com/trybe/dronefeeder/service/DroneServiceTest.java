package com.trybe.dronefeeder.service;

import static org.mockito.Mockito.when;

import com.trybe.dronefeeder.model.DroneModel;
import com.trybe.dronefeeder.repository.DroneRepository;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DroneServiceTest {

  @InjectMocks
  private DroneService service;

  @Mock
  private DroneRepository repository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void findAll() {
    DroneModel drone1 = new DroneModel((long) 1, "90.0", "180.0", "2022-07-18");
    DroneModel drone2 = new DroneModel((long) 2, "0.0", "0.0", "2022-07-17");
    when(repository.findAll()).thenReturn(Arrays.asList(drone1, drone2));
    List<DroneModel> drones = service.findAll();
    Assertions.assertEquals(2, drones.size(), "findAll should return 2 drones");
  }

}
