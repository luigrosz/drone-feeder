package com.trybe.dronefeeder.validations;

import com.trybe.dronefeeder.exceptions.BadRequestException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidateBody {

  private ValidateBody() {
  }

  /** Validate drone controller latitude. */
  public static void latitude(String latitude) {
    String latitudeRegex = "^(\\-?([0-8]?\\d(\\.\\d+)?|90(.0+)?))$";
    if (!latitude.matches(latitudeRegex)) {
      throw new BadRequestException("The request latitude is wrong");
    }
  }

  /** Validate drone controller longitude. */
  public static void longitude(String longitude) {
    String longitudeRegex = "(\\-?(1?[0-7]?\\d(\\.\\d+)?|180((.0+)?)))$";
    if (!longitude.matches(longitudeRegex)) {
      throw new BadRequestException("The request longitude is wrong");
    }
  }

  /** Validate drone controller date. */
  public static String date(String lastMaintenance) {
    LocalDate parsedDate;
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      parsedDate = LocalDate.parse(lastMaintenance, formatter);
    } catch (Exception e) {
      throw new BadRequestException("The request date is not valid");
    }
    if (!parsedDate.isAfter(LocalDate.of(2022, 07, 14))) {
      throw new BadRequestException("The request date is not valid");
    }
    return lastMaintenance;
  }

}