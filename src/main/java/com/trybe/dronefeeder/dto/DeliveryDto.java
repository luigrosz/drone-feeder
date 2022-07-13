package com.trybe.dronefeeder.dto;

public class DeliveryDto {
  private String delivery;
  private String time;

  public String getDelivery() {
    return this.delivery;
  }

  public void setDelivery(String delivery) {
    this.delivery = delivery;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}