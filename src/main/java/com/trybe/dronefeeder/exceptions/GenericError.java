package com.trybe.dronefeeder.exceptions;

public class GenericError {
  private String message;
  
  public GenericError(String message) {
    this.message = message;
  }
  
  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}