package com.example.hackweekbackend.driver.repository;

import com.example.hackweekbackend.driver.model.Driver;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface JpaDriverRepo extends ListCrudRepository<Driver, UUID> {}