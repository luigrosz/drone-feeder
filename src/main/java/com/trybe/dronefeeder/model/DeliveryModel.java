package com.trybe.dronefeeder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class DeliveryModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String delivery;
  private String time;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "drone_id")
  private DroneModel drone;

  public DeliveryModel() {
    // JPA empty constructor
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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