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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String latitude;
  private String longitude;
  private String lastMaintance;

  @OneToMany(mappedBy = "drone",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  private List<DeliveryModel> deliveries;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
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

  public String getLastMaintance() {
    return this.lastMaintance;
  }

  public void setLastMaintance(String lastMaintance) {
    this.lastMaintance = lastMaintance;
  }

  public List<DeliveryModel> getDeliveries() {
    return this.deliveries;
  }

  public void setDeliveries(List<DeliveryModel> deliveries) {
    this.deliveries = deliveries;
  }

}