package ua.su.model;

public class MedicalService {

    private String title;
    private double price;
    private int insuranceCoverage;
    private int procedureDuration;

    public MedicalService(String title, double price, int insuranceCoverage, int procedureDuration) {
        this.title = title;
        this.price = price;
        this.insuranceCoverage = insuranceCoverage;
        this.procedureDuration = procedureDuration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(int insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    public int getProcedureDuration() {
        return procedureDuration;
    }

    public void setProcedureDuration(int procedureDuration) {
        this.procedureDuration = procedureDuration;
    }
}
