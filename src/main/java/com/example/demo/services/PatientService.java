package com.example.demo.services;

import com.example.demo.models.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        try {
            return patientRepository.findAll();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try {
            return patientRepository.findById(id).orElse(null);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            patientRepository.save(patient);
            return patient;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Patient updatePatient(Long id, Patient patient) {
        try {
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if(!existingPatient.isPresent()) {
                System.out.println("Patient doesn't exist");
                return null;
            } else {
                Patient p = existingPatient.get();
                p.setName(patient.getName());
                p.setAge(patient.getAge());
                p.setGender(patient.getGender());
                patientRepository.save(p);
                return p;
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            patientRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
