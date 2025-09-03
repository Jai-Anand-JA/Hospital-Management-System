package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Patient;
import com.example.demo.services.PatientService;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    PatientService patientService;
    
    @GetMapping
    public List<Patient> getAllPatients() {
        System.out.println("All Patients");
        return patientService.getAllPatients();     
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        System.out.println(id);
        return patientService.getPatientById(id);
    }
    
    @PostMapping()
    public Patient createPatient(@RequestBody Patient patient) {
        System.out.println("New patient created");
        return patientService.createPatient(patient);
    }
    
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        System.out.println("Patient with id: "+id+" updated");
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        System.out.println("Patient Deleted Successfully");
    }
}
