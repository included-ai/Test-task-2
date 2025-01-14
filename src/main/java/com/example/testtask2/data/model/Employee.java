package com.example.testtask2.data.model;

public final class Employee {

    private final String name;
    private final Integer startYear;

    public Employee(final String name, final Integer startYear) {
        this.name = name;
        this.startYear = startYear;
    }

    public String name() {
        return this.name;
    }

    public Integer startYear() {
        return this.startYear;
    }

}
