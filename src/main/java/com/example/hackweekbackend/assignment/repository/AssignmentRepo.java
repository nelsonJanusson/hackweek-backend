package com.example.hackweekbackend.assignment.repository;

import com.example.hackweekbackend.assignment.model.Assignment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class AssignmentRepo{
    private final JpaAssignmentRepo jpaAssignmentRepo;


    public Assignment createAssignment(Assignment assignment) {
        return jpaAssignmentRepo.save(assignment);
    }

    public Assignment getAssignment(UUID assignmentId) {
        return jpaAssignmentRepo.findById(assignmentId)
                .orElseThrow(() -> new NoSuchElementException("no assignment with matching id found"));
    }

    public Assignment updateAssignment(Assignment assignment) {
        return jpaAssignmentRepo.save(assignment);
    }

    public void deleteAssignment(UUID assignmentId) {
        if (!jpaAssignmentRepo.existsById(assignmentId)) {
            throw new NoSuchElementException("no assignment with matching id found");
        }
        jpaAssignmentRepo.deleteById(assignmentId);
    }

    public List<Assignment> getAssignments() {
        return jpaAssignmentRepo.findAll();
    }
}
