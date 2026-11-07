package org.top.springplanexample.datamodel.entity;

import jakarta.persistence.*;

import java.util.Date;

// SafetyMetric - метрика безнопасности, вносится вручную
@Entity
@Table(name="t_safety_metric")
public class SafetyMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="f_travmatism_plan", nullable = false)
    private Integer travmatismPlan;

    @Column(name="f_travmatism_fact", nullable = false)
    private Integer travmatismFact;

    @Column(name="f_braki_plan", nullable = false)
    private Integer brakiPlan;

    @Column(name="f_braki_fact", nullable = false)
    private Integer brakiFact;

    @Column(name="f_month", nullable = false)
    private Integer month;

    @Column(name="f_year", nullable = false)
    private Integer year;

    @Column(name="f_write_date", nullable = false)
    private Date writeDate;

    public SafetyMetric() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTravmatismPlan() {
        return travmatismPlan;
    }

    public void setTravmatismPlan(Integer travmatismPlan) {
        this.travmatismPlan = travmatismPlan;
    }

    public Integer getTravmatismFact() {
        return travmatismFact;
    }

    public void setTravmatismFact(Integer travmatismFact) {
        this.travmatismFact = travmatismFact;
    }

    public Integer getBrakiPlan() {
        return brakiPlan;
    }

    public void setBrakiPlan(Integer brakiPlan) {
        this.brakiPlan = brakiPlan;
    }

    public Integer getBrakiFact() {
        return brakiFact;
    }

    public void setBrakiFact(Integer brakiFact) {
        this.brakiFact = brakiFact;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
}
