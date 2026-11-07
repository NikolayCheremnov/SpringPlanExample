package org.top.springplanexample.service.safetymetric;

public class SafetyMetricValues {
    private int travmatismPlan;
    private int travmatismFact;
    private int brakiPlan;
    private int brakiFact;

    public SafetyMetricValues(int travmatismPlan, int travmatismFact, int brakiPlan, int brakiFact) {
        this.travmatismPlan = travmatismPlan;
        this.travmatismFact = travmatismFact;
        this.brakiPlan = brakiPlan;
        this.brakiFact = brakiFact;
    }

    public int getTravmatismPlan() {
        return travmatismPlan;
    }

    public void setTravmatismPlan(int travmatismPlan) {
        this.travmatismPlan = travmatismPlan;
    }

    public int getTravmatismFact() {
        return travmatismFact;
    }

    public void setTravmatismFact(int travmatismFact) {
        this.travmatismFact = travmatismFact;
    }

    public int getBrakiPlan() {
        return brakiPlan;
    }

    public void setBrakiPlan(int brakiPlan) {
        this.brakiPlan = brakiPlan;
    }

    public int getBrakiFact() {
        return brakiFact;
    }

    public void setBrakiFact(int brakiFact) {
        this.brakiFact = brakiFact;
    }
}
