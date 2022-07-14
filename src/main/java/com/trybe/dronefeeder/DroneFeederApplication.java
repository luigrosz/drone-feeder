package com.trybe.dronefeeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DroneFeederApplication {

  public static void main(String[] args) {
    SpringApplication.run(DroneFeederApplication.class, args);
  }

}
