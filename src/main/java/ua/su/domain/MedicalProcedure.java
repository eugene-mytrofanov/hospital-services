package ua.su.domain;

public class MedicalProcedure extends ID {

    private String title;
    private Double price;
    private Integer insuranceCoverage;
    private Integer procedureDuration;

    public MedicalProcedure(){

    }

    public MedicalProcedure(Long id, String title, Double price, Integer insuranceCoverage, Integer procedureDuration) {
        super(id);
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

    public Integer getInsuranceCoverage() {
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
