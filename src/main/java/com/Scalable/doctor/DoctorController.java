package com.Scalable.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Doctors")
@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("getdoctorbyid/{id}")
    public ResponseEntity<Doctor> getPatient(@PathVariable("id") Long id) {

        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    @PostMapping("/createdoctor")
    public ResponseEntity<Doctor> createPatient(@RequestBody Doctor doctor) {
        Doctor createddoctor = doctorRepository.save(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createddoctor);
    }

    @PutMapping("/updatedoctor/{id}")
    public ResponseEntity<Doctor> updatePatient(@PathVariable("id") Long id, @RequestBody Doctor patient) {
        Doctor existingdoctor  = doctorRepository.findById(id).orElse(null);
        if (existingdoctor == null) {
            return ResponseEntity.notFound().build();
        }
        existingdoctor.setName(patient.getName());
        existingdoctor.setAddress(patient.getAddress());
        existingdoctor.setPhoneNumber(patient.getPhoneNumber());
        Doctor updateddoctor = doctorRepository.save(existingdoctor);
        return ResponseEntity.ok(updateddoctor);
    }
    @GetMapping("/hello")
    public String gethello() {
        return "hello world";
    }
    @DeleteMapping("/deletedoctor/{id}")
    public ResponseEntity<Void> deletedoctor(@PathVariable("id") Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        doctorRepository.delete(doctor);
        doctorRepository.delete(doctor);
        return ResponseEntity.noContent().build();
    }
}