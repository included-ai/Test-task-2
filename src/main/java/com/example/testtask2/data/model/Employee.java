package com.example.testtask2.data.model;

public final class Employee {

    private final String name;
    private final Integer startYear;
    private final Integer startMonth;
    private final Integer starDay;
    private final Integer age;

    public Employee(final String name, final Integer startYear, Integer startMonth, Integer starDay, Integer age) {
        this.name = name;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.starDay = starDay;
        this.age = age;
    }

    public String name() {
        return this.name;
    }

    public Integer startYear() {
        return this.startYear;
    }

    public Integer startMonth() {
        return this.startMonth;
    }

    public Integer starDay() {
        return this.starDay;
    }

    public Integer age() {
        return age;
    }
}
