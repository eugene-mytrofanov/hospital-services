package ua.su.model;

public class MedicalProcedure {

    private String title;
    private Double price;
    private Integer insuranceCoverage;
    private Integer procedureDuration;

    public MedicalProcedure(String title, Double price, Integer insuranceCoverage, Integer procedureDuration) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer InsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(Integer insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    public Integer getProcedureDuration() {
        return procedureDuration;
    }

    public void setProcedureDuration(Integer procedureDuration) {
        this.procedureDuration = procedureDuration;
    }
}
