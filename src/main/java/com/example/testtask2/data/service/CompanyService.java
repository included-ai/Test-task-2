package com.example.testtask2.data.service;

import com.example.testtask2.data.model.Company;
import com.example.testtask2.data.model.Employee;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CompanyService {
    private static final String STATS_FILE = "stats/company.txt";

    private final List<Company> companies = new ArrayList<>();

    public void addCompany(String name, List<Employee> employees) {
        this.companies.add(new Company(name, employees));
    }

    public List<Company> getCompanies() {
        return this.companies;
    }


    public Company getCompany(String companyName) {
        Company company = null;
        for (var c : this.companies) {
            if (c.getName() == companyName) {
                company = c;
            }
        }
        return company;
    }

    public Employee mostExperiencedEmployee() {
        return findMostExperiencedEmployee(
            this.companies
                .stream()
                .flatMap(company -> company.allEmployees().stream())
                .toList()
        );
    }

    public Employee mostExperiencedEmployeeOf(List<String> employees)
    {
        List<Employee> selectedEmployees = new ArrayList<>();
        for (var employee : employees) {
            for (var company : this.companies) {
                if (company.getEmployee(employee) != null) {
                    addEmployeeToList(company.getEmployee(employee), selectedEmployees);
                }
            }
        }

        return findMostExperiencedEmployee(selectedEmployees);
    }


    public void saveStats() throws IOException {
        try( var writer = new PrintWriter(STATS_FILE, StandardCharsets.UTF_8)) {
            for (var company : this.companies) {
                writer.printf("Company %s, size: %d\n", company.getName(), company.allEmployees().size());
            }
        }
    }


    private void addEmployeeToList(final Employee employee, final List<Employee> list) {
        list.add(employee);
    }


    private Employee findMostExperiencedEmployee(final List<Employee> employees) {
        return employees.stream().max(Comparator.comparing(Employee::startYear)).orElse(null);
    }
}
