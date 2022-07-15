package com.trybe.dronefeeder.dto;

public class DroneDto {
  private String latitude;
  private String longitude;
  private String lastMaintenance;

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
}