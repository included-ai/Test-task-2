package com.example.testtask2.controllers;

import com.example.testtask2.data.model.Employee;
import com.example.testtask2.data.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CompanyService companyService;

    /**
     * Adds company to the service
     */
    @PutMapping("/company")
    public void addCompany(@RequestParam String name, @RequestBody List<Employee> employees) {
        this.companyService.addCompany(name, employees);
    }

    /**
     * Returns list of employees for the given company
     */
    @PostMapping("/employees")
    public List<Employee> employees(@RequestParam String name) {
        return this.companyService.getCompany(name).allEmployees();
    }

    /**
     * Adds employees to the company
     */
    @PutMapping("/employees")
    public void addEmployees(@RequestParam String name, @RequestBody List<Employee> employees) {
        this.companyService.getCompany(name).addEmployees(employees);
    }

    /**
     * Returns the most experienced employee (employee with the longest tenure)
     */
    @PostMapping("/most-experienced")
    public Employee employees() {
        return this.companyService.mostExperiencedEmployee();
    }

    /**
     * Finds the most experienced employee among selected
     */
    @PostMapping("/most-experienced-of")
    public Employee mostExperiencedEmployeeOf(@RequestBody List<String> employees) {
        return this.companyService.mostExperiencedEmployeeOf(employees);
    }

    /**
     * Saves stats about companies to the temporary file for later usage
     */
    @GetMapping("/save-stats")
    public ResponseEntity<?> saveStats() {
        try {
            this.companyService.saveStats();
            return ResponseEntity.ok("saved");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}
