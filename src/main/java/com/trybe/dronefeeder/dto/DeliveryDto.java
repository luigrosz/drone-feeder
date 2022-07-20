package com.trybe.dronefeeder.dto;

import com.trybe.dronefeeder.model.DeliveryModel;

public class DeliveryDto {
  private Long id;
  private String delivery;
  private String time;
  private DroneDto drone;

  /** DeliveryDto entity converter. */
  public DeliveryDto(DeliveryModel entity) {
    this.id = entity.getId();
    this.delivery = entity.getDelivery();
    this.time = entity.getTime();
    this.drone = new DroneDto(entity.getDrone());
  }

  /** DeliveryDto complete constructor. */
  public DeliveryDto(Long id, String delivery, String time, DroneDto drone) {
    this.id = id;
    this.delivery = delivery;
    this.time = time;
    this.drone = drone;
  }

  /** DeliveryDto no id constructor. */
  public DeliveryDto(String delivery, String time, DroneDto drone) {
    this.delivery = delivery;
    this.time = time;
    this.drone = drone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDelivery() {
    return delivery;
  }

  public void setDelivery(String delivery) {
    this.delivery = delivery;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public DroneDto getDrone() {
    return drone;
  }

  public void setDrone(DroneDto drone) {
    this.drone = drone;
  }

}