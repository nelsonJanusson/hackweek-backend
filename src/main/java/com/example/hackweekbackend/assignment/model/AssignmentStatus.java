package com.example.hackweekbackend.assignment.model;

public enum AssignmentStatus {
    UNASSIGNED("Unassigned"), ACTIVE("Active"), FINISHED("Finished") ;

    public final String status;

    AssignmentStatus(String status) {
        this.status = status;
    }
}
