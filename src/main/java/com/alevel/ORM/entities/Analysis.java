//package com.alevel.ORM.entities;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Entity
//@Table(name = "analyses", catalog = "hospital")
//public class Analysis {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private int id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "result", length = 511)
//    private String result;
//
//    @Column(name = "date")
//    private Date date;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "disease_id", nullable = false)
//    private Disease disease;
//
//    public Analysis() {
//    }
//
//    public Analysis(String name) {
//        this.name = name;
//    }
//
//    public Analysis(String name, String result) {
//        this.name = name;
//        this.result = result;
//    }
//
//    public Analysis(String name, String result, Date date) {
//        this.name = name;
//        this.result = result;
//        this.date = date;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Disease getDisease() {
//        return disease;
//    }
//
//    public void setDisease(Disease disease) {
//        this.disease = disease;
//    }
//}
