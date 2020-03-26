//package com.alevel.ORM.entities;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "diseases", catalog = "hospital")
//public class Disease {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private int id;
//
//    @Column(name = "first_visit_info", length = 1023)
//    private String firstExamination;
//
//    @Column(name = "recommendations", length = 1023)
//    private String recommendations;
//
//    @Column(name = "medicines")
//    private String medicines;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patient_history_id", nullable = false)
//    private PatientHistory patientHistory;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Analysis> analyses;
//
//    public Disease() {
//    }
//
//    public Disease(String firstExamination) {
//        this.firstExamination = firstExamination;
//    }
//
//    public Disease(String firstExamination, String recommendations, String medicines) {
//        this.firstExamination = firstExamination;
//        this.recommendations = recommendations;
//        this.medicines = medicines;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstExamination() {
//        return firstExamination;
//    }
//
//    public void setFirstExamination(String firstExamination) {
//        this.firstExamination = firstExamination;
//    }
//
//    public String getRecommendations() {
//        return recommendations;
//    }
//
//    public void setRecommendations(String recommendations) {
//        this.recommendations = recommendations;
//    }
//
//    public String getMedicines() {
//        return medicines;
//    }
//
//    public void setMedicines(String medicines) {
//        this.medicines = medicines;
//    }
//
//    public PatientHistory getPatientHistory() {
//        return patientHistory;
//    }
//
//    public void setPatientHistory(PatientHistory patientHistory) {
//        this.patientHistory = patientHistory;
//    }
//
//    public List<Analysis> getAnalyses() {
//        return analyses;
//    }
//
//    public void setAnalyses(List<Analysis> analyses) {
//        this.analyses = analyses;
//    }
//}
