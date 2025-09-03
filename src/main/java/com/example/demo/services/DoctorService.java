package com.example.demo.services;

import com.example.demo.models.Doctor;
import com.example.demo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        try {
            return doctorRepository.findAll();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            return doctorRepository.findById(id).orElse(null);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try {
            doctorRepository.save(doctor);
            return doctor;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        try {
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if(!existingDoctor.isPresent()) {
                System.out.println("Doctor doesn't exist");
                return null;
            } else {
                Doctor d = existingDoctor.get();
                d.setName(doctor.getName());
                d.setSpeciality(doctor.getSpeciality());
                doctorRepository.save(d);
                return d;
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        try {
            doctorRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
