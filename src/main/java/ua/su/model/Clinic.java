package ua.su.model;

import java.util.List;

public class Clinic {

    private String name;
    private String address;
    private String phone;
    private Boolean isClinicPrivate;
    private Boolean isInsuranceSupported;
    private Integer numberOfDoctors;
    private List<MedicalProcedure> medicalProcedures;

    public Clinic(String name, String address, String phone, Boolean isClinicPrivate, Boolean isInsuranceSupported,
                  Integer numberOfDoctors, List<MedicalProcedure> medicalProcedures) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isClinicPrivate = isClinicPrivate;
        this.isInsuranceSupported = isInsuranceSupported;
        this.numberOfDoctors = numberOfDoctors;
        this.medicalProcedures = medicalProcedures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isPrivateClinic() {
        return isClinicPrivate;
    }

    public void setPrivateClinic(boolean privateClinic) {
        isClinicPrivate = privateClinic;
    }

    public Boolean isInsuranceSupported() {
        return isInsuranceSupported;
    }

    public void setInsuranceSupported(boolean insuranceSupported) {
        isInsuranceSupported = insuranceSupported;
    }

    public Integer getNumberOfDoctors() {
        return numberOfDoctors;
    }

    public void setNumberOfDoctors(Integer numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    public List<MedicalProcedure> getMedicalProcedures() {
        return medicalProcedures;
    }

    public void setMedicalProcedures(List<MedicalProcedure> medicalProcedures) {
        this.medicalProcedures = medicalProcedures;
    }
}
