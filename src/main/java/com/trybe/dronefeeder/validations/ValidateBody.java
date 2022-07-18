package com.trybe.dronefeeder.validations;

import com.trybe.dronefeeder.exceptions.BadRequestException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ValidateBody {

  private ValidateBody() {
  }

  /** Validate drone controller latitude. */
  public static void latitude(String latitude) {
    String latitudeRegex = "^-?([1-8]?[1-9]|[1-9]0)\\.{1}\\d{1,6}";
    if (!latitude.matches(latitudeRegex)) {
      throw new BadRequestException("The latitude of the request is wrong");
    }
  }

  /** Validate drone controller longitude. */
  public static void longitude(String longitude) {
    String longitudeRegex = "^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,6}";
    if (!longitude.matches(longitudeRegex)) {
      throw new BadRequestException("The longitude of the request is wrong");
    }
  }

  /** Validate drone controller date. */
  public static Date date(String lastMaintenance) throws Exception {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(lastMaintenance);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate parsedDate = LocalDate.parse(lastMaintenance, formatter);
    if (!parsedDate.isAfter(LocalDate.of(2022, 07, 14))) {
      throw new Exception();
    }
    return date;
  }

}
