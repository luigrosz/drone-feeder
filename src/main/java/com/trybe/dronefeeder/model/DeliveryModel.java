package com.trybe.dronefeeder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Entity. */
@Entity
@Table(name = "delivery")
public class DeliveryModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String delivery;
  private String time;
  
  @ManyToOne
  @JoinColumn(name = "drone_id")
  private DroneModel drone;

  public DeliveryModel() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public DroneModel getDrone() {
    return this.drone;
  }

  public void setDrone(DroneModel drone) {
    this.drone = drone;
  }

}