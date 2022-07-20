package com.trybe.dronefeeder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
  /** Exception Handler. */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<GenericError> handleResourceNotFoundException(
      RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new GenericError(exception.getMessage()));
  }

  /** Exception Handler Wrong Body. */
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<GenericError> handleBadRequestException(
      RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new GenericError(exception.getMessage()));
  }
}