package com.alevel.ORM.dao;

//import com.alevel.ORM.entities.Analysis;
//import com.alevel.ORM.entities.Disease;
import com.alevel.ORM.entities.Patient;
import com.alevel.ORM.entities.PatientHistory;
import com.alevel.ORM.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Session session = null;

    public void createPatient(Patient patient) {
        session = getSession();
        session.beginTransaction();

        PatientHistory patientHistory = patient.getPatientHistory();
        patientHistory.setPatient(patient);
        patient.setPatientHistory(patientHistory);
        session.save(patient);
        session.save(patientHistory);
        session.getTransaction().commit();
    }

    public Patient readPatient(int id) {
        session = getSession();
        Patient patient = new Patient();
        patient = session.get(Patient.class, id);
        return patient;
    }

    public List<Patient> readAllPatients() {
        List<Patient> patients = new ArrayList<>();
        session = getSession();
        try {
            patients = session.createCriteria(Patient.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    public void updatePatient(Patient patient) {
        session = getSession();
        session.evict(patient);
        session.update(patient);
    }
//    public void addDisease(Disease disease){
//
//    }

//    public void updatePatient(int id, Disease disease) {
//        session = getSession();
//        Patient patient = session.get(Patient.class, id);
//        PatientHistory patientHistory = patient.getPatientHistory();
//        List<Disease> diseases = new ArrayList<Disease>();
//        try{
//            diseases = patientHistory.getDiseases();
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            diseases.add(disease);
//        }
//        disease.setPatientHistory(patientHistory);
//        patientHistory.setDiseases(diseases);
//        session.update(patient);
//    }

    public void deletePatient(int id) {
        session = getSession();
        session.delete(id);
    }

    public Session getSession() {
        if (session == null) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
        }
        return session;
    }
}
