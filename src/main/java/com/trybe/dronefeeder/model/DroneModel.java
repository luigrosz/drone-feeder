package com.trybe.dronefeeder.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

  @JsonManagedReference
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((deliveries == null) ? 0 : deliveries.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((lastMaintenance == null) ? 0 : lastMaintenance.hashCode());
    result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
    result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    DroneModel castedObject = (DroneModel) obj;
    return deliveries.equals(castedObject.deliveries)
        && id.equals(castedObject.id)
        && lastMaintenance.equals(castedObject.lastMaintenance)
        && latitude.equals(castedObject.latitude)
        && longitude.equals(castedObject.longitude);
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