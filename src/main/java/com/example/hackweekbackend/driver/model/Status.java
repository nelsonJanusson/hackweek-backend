package com.example.hackweekbackend.driver.model;

public enum Status {
    UNASSIGNED("Unassigned"), ASSIGNED("Assigned");

    public final String status;

    Status(String status) {
        this.status = status;
    }
}
