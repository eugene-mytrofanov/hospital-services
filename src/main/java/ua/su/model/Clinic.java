package ua.su.model;

import java.util.List;

public class Clinic {

    private String name;
    private String address;
    private String phone;
    private Boolean isClinicPrivate;
    private Boolean isInsuranceSupported;
    private Integer numberOfDoctors;
    private List<MedicalService> medicalServices;

    public Clinic(String name, String address, String phone, Boolean isClinicPrivate, Boolean isInsuranceSupported,
                  Integer numberOfDoctors, List<MedicalService> medicalServices) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isClinicPrivate = isClinicPrivate;
        this.isInsuranceSupported = isInsuranceSupported;
        this.numberOfDoctors = numberOfDoctors;
        this.medicalServices = medicalServices;
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

    public List<MedicalService> getMedicalServices() {
        return medicalServices;
    }

    public void setMedicalServices(List<MedicalService> medicalServices) {
        this.medicalServices = medicalServices;
    }
}
