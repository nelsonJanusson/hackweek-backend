package com.example.hackweekbackend.assignment.repository;


import com.example.hackweekbackend.assignment.model.Assignment;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface AssignmentRepo extends ListCrudRepository<Assignment, UUID> {}