package ua.su.model;

import java.util.ArrayList;

public class Clinic {

    private String name;
    private String address;
    private String phone;
    private boolean isPrivateClinic;
    private boolean isInsuranceSupported;
    private ArrayList<Doctor> doctors;
    private ArrayList<MedicalService> services;

    public Clinic(String name, String address, String phone, boolean isPrivateClinic, boolean isInsuranceSupported,
                  ArrayList<Doctor> doctors, ArrayList<MedicalService> services) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isPrivateClinic = isPrivateClinic;
        this.isInsuranceSupported = isInsuranceSupported;
        this.doctors = doctors;
        this.services = services;
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

    public boolean isPrivateClinic() {
        return isPrivateClinic;
    }

    public void setPrivateClinic(boolean privateClinic) {
        isPrivateClinic = privateClinic;
    }

    public boolean isInsuranceSupported() {
        return isInsuranceSupported;
    }

    public void setInsuranceSupported(boolean insuranceSupported) {
        isInsuranceSupported = insuranceSupported;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<MedicalService> getServices() {
        return services;
    }

    public void setServices(ArrayList<MedicalService> services) {
        this.services = services;
    }
}
