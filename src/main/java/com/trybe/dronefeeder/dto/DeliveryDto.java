package com.trybe.dronefeeder.dto;

public class DeliveryDto {
  private Long id;
  private String delivery;
  private String time;
  private DroneDto drone;

  public DeliveryDto() {
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
    result = prime * result + ((drone == null) ? 0 : drone.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((time == null) ? 0 : time.hashCode());
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
    DeliveryDto other = (DeliveryDto) obj;
    return delivery.equals(other.delivery)
        && drone.equals(other.drone)
        && id.equals(other.id)
        && time.equals(other.time);
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