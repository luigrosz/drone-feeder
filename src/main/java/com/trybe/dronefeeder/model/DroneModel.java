package com.trybe.dronefeeder.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Entity. */
@Entity
@Table(name = "drone")
public class DroneModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String latitude;
  private String longitude;
  private String lastMaintenance;

  @OneToMany(
      mappedBy = "drone",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  private List<DeliveryModel> deliveries;

  public DroneModel() {
    // JPA empty constructor
  }

  /** DroneModel constructor for unit tests. */
  public DroneModel(Long id, 
      String latitude, 
      String longitude,
      String lastMaintenance) {
    this.id = id;
    this.latitude = latitude;
    this.longitude = longitude;
    this.lastMaintenance = lastMaintenance;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLatitude() {
    return this.latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return this.longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLastMaintenance() {
    return this.lastMaintenance;
  }

  public void setLastMaintenance(String lastMaintenance) {
    this.lastMaintenance = lastMaintenance;
  }

  public List<DeliveryModel> getDeliveries() {
    return this.deliveries;
  }

  public void setDeliveries(List<DeliveryModel> deliveries) {
    this.deliveries = deliveries;
  }

}