package com.alevel.ORM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient_history", catalog = "hospital")
public class PatientHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date")
    private Date date;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "disease_id")
//    private List<Disease> diseases;

    public PatientHistory() {
    }

    public PatientHistory(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

//    public List<Disease> getDiseases() {
//        return diseases;
//    }
//
//    public void setDiseases(List<Disease> diseases) {
//        this.diseases = diseases;
//    }

    @Override
    public String toString() {
        return "PatientHistory{" +
                "id=" + id +
                ", date=" + date +
                ',' + '}';
    }
}
