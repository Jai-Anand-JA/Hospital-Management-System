package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Doctor;
import com.example.demo.services.DoctorService;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    
    @Autowired
    DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        System.out.println("All Doctor");
        return doctorService.getAllDoctors(); 
    }
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        System.out.println(id);
        return doctorService.getDoctorById(id);
    }
    
    @PostMapping()
    public Doctor createPatient(@RequestBody Doctor doctor) {
        System.out.println("New doctor created");
        return doctorService.createDoctor(doctor);
    }
    
    @PutMapping("/{id}")
    public Doctor updatePatient(@PathVariable Long id, @RequestBody Doctor doctor) {
        System.out.println("Doctor with id: "+id+" updated");
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        System.out.println("Doctor Deleted Successfully");
    }
}
