package com.trybe.dronefeeder.dto;

import java.util.ArrayList;
import java.util.List;

public class DroneDto {
  private Long id;
  private String latitude;
  private String longitude;
  private String lastMaintenance;
  private List<DeliveryDto> deliveries = new ArrayList<>();

  public DroneDto() {
  }

  /** DeliveryDto no id constructor. */
  public DroneDto(String latitude, String longitude, String lastMaintenance) {
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
    DroneDto castedObject = (DroneDto) obj;
    return deliveries.equals(castedObject.deliveries)
        && id.equals(castedObject.id)
        && lastMaintenance.equals(castedObject.lastMaintenance)
        && latitude.equals(castedObject.latitude)
        && longitude.equals(castedObject.longitude);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLastMaintenance() {
    return lastMaintenance;
  }

  public void setLastMaintenance(String lastMaintenance) {
    this.lastMaintenance = lastMaintenance;
  }

  public List<DeliveryDto> getDeliveries() {
    return deliveries;
  }

  public void setDeliveries(List<DeliveryDto> deliveries) {
    this.deliveries = deliveries;
  }

}