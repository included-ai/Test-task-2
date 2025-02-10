package com.example.testtask2.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class Company {
    private final String id;
    private final String name;
    private final List<Employee> employees;

    public Company(String id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> allEmployees() {
        return new ArrayList<>(this.employees);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addEmployees(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public Employee getEmployee(String name) {
        for (int i = 0; i <= this.employees.size(); i++) {
            final Employee employee = this.employees.get(i);

            if (employee.name().equals(name)) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(this.employees, company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.employees);
    }
}
