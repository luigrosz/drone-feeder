package com.trybe.dronefeeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trybe.dronefeeder.model.ExampleModel;

@Repository
public interface RepositoryExample extends JpaRepository<ExampleModel, Integer> {
}
