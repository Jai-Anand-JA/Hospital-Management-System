package com.example.demo.services;

import com.example.demo.models.Appointment;
import com.example.demo.repositories.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AppointmentService {
  
    @Autowired
    AppointmentRepository appointmentRepository;
    
    public List<Appointment> getAllAppointments() {
        try {
            return appointmentRepository.findAll();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Appointment getAppointmentById(Long id) {
        try {
            return appointmentRepository.findById(id).orElse(null); 
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Appointment createAppointment(Appointment appointment) {
        try {
            appointmentRepository.save(appointment);
            return appointment;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Appointment updateAppointment(Long id, Appointment appointment) {
        try {
            Optional<Appointment> existingAppointment=appointmentRepository.findById(id);
            if(!existingAppointment.isPresent()) {
                System.out.println("Appointment doesn't exists");
                return null;
            }
            else {
                Appointment ap=existingAppointment.get();
                ap.setDate(appointment.getDate());
                ap.setDoctorId(appointment.getDoctorId());
                ap.setPatientId(appointment.getPatientId());
                appointmentRepository.save(ap);
                return ap;
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteAppointment(Long id) {
        try {
            appointmentRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
