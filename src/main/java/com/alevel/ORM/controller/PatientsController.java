package com.alevel.ORM.controller;

import com.alevel.ORM.dao.PatientDAO;
//import com.alevel.ORM.entities.Disease;
import com.alevel.ORM.entities.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class PatientsController {
    PatientDAO patientDAO;

    @PostConstruct
    void setup() {
        patientDAO = new PatientDAO();
    }

    @GetMapping("/hospital/patient/")
    public List<Patient> getAllPatients() {
        return patientDAO.readAllPatients();
    }

    @GetMapping("/hospital/patient/{id}")
    public Patient getAllPatients(@PathVariable int id) {
        return patientDAO.readPatient(id);
    }

    @PutMapping("/hospital/patient/")
    public HttpStatus createPatient(@RequestBody Patient patient){
        patientDAO.createPatient(patient);
        return HttpStatus.OK;
    }

//    @PutMapping("/hospital/patient/{id}/add_visit_info")
//    public HttpStatus createPatientsHistory(@PathVariable int id, @RequestBody Disease disease){
//        patientDAO.updatePatient(id, disease);
//        return HttpStatus.OK;
//    }

    @PostMapping("/hospital/patient/")
    public HttpStatus updatePatient(@RequestBody Patient patient){
        patientDAO.updatePatient(patient);
        return HttpStatus.OK;
    }
}
