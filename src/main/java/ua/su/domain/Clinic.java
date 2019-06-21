package ua.su.domain;

import java.util.List;

public class Clinic extends ID {

    private String name;
    private String address;
    private String phone;
    private Boolean isInsuranceSupported;
    private ClinicType clinicType;
    private Integer numberOfDoctors;
    private List<MedicalProcedure> medicalProcedures;

    //  Spring displays an error without empty constructor at the runtime
    public Clinic() {

    }

    public Clinic(Long id, String name, String address, String phone, Boolean isInsuranceSupported, ClinicType clinicType,
                  Integer numberOfDoctors, List<MedicalProcedure> medicalProcedures) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isInsuranceSupported = isInsuranceSupported;
        this.clinicType = clinicType;
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

    public ClinicType getClinicType() {
        return clinicType;
    }

    public void setClinicType(ClinicType clinicType) {
        this.clinicType = clinicType;
    }

    public Boolean getIsInsuranceSupported() {
        return isInsuranceSupported;
    }

    public void setIsInsuranceSupported(boolean insuranceSupported) {
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
