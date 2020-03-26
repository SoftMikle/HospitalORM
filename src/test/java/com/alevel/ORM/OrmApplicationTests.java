package com.alevel.ORM;

import com.alevel.ORM.dao.PatientDAO;
//import com.alevel.ORM.entities.Disease;
import com.alevel.ORM.entities.Patient;
import com.alevel.ORM.entities.PatientHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class OrmApplicationTests {
    public static final String WHATISLOVE = "Whatislove";
    private static final String MIKLE = "Mikle";
    private static final String SAVCHENKO = "Savchenko";
    private static final String KHARKIV = "Kharkiv";
    PatientDAO patientDAO;
    private Patient patient;

    @BeforeEach
    void setup() {
        patient = new Patient(MIKLE, SAVCHENKO, KHARKIV);
        patientDAO = new PatientDAO();
    }

    @Test
    void contextLoads() {
        List<Patient> patients = new ArrayList();
        for (int i = 0; i < 5; i++) {
            patients.add(new Patient(patient.getFirstName() + i, patient.getLastName() + i, patient.getAddress() + i));
        }
        PatientHistory patientHistory = new PatientHistory(Date.valueOf("1993-09-12"));
        patient.setPatientHistory(patientHistory);
        patients.forEach(patient1 -> patientDAO.createPatient(patient1));
    }

//    @Test
//    void diseaseAdding() {
//        Disease disease = new Disease("Fever \t Cough \t Shortness of breath","Stay at home!","aspirine");
//        Patient patient = patientDAO.readPatient(1);
//        patientDAO.updatePatient(patient.getId(), disease);
//        System.out.println(patientDAO.readPatient(1));
//    }

    @Test
    void getAllEntitiesTest() {
        List<Patient> allPatients = patientDAO.readAllPatients();
        assertNotNull(allPatients);
        allPatients.forEach(System.out::println);
    }

    @Test
    void getPatientTest() {
        Patient patient = patientDAO.readPatient(5);
        assertEquals(MIKLE + 2, patient.getFirstName());
        System.out.println("patientInformation = " + patient);
    }

    @Test
    void updatePatientTest() {
        Patient patient = patientDAO.readPatient(4);
        patient.setFirstName(WHATISLOVE);
        patientDAO.updatePatient(patient);
        Patient updatedPatient = patientDAO.readPatient(4);
        assertEquals(WHATISLOVE, updatedPatient.getFirstName());
        assertEquals(patient.getLastName(), updatedPatient.getLastName());
        assertEquals(patient.getAddress(), updatedPatient.getAddress());
        System.out.println("updatedPatient = " + updatedPatient);
    }

    @Test
    void deletePatientTest() {
        patientDAO.deletePatient(7);
        patientDAO.readPatient(7);
    }

}
