package com.trybe.dronefeeder.dto;

public class DroneDto {
  private String latitude;
  private String longitude;
  private String lastMaintance;

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
}