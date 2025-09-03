package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Appointment;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.services.AppointmentService;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    
    @Autowired
    AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        System.out.println("All Appointments");
        return appointmentService.getAllAppointments(); 
    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        System.out.println(id);
        return appointmentService.getAppointmentById(id);
    }
    
    @PostMapping()
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        System.out.println("New Appointment created");
        return appointmentService.createAppointment(appointment);
    }
    
    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        System.out.println("Appointment with id: "+id+" updated");
        return appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        System.out.println("Appointment Deleted Successfully");
    }
}
