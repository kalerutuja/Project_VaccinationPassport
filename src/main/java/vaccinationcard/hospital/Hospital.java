package vaccinationcard.hospital;

import vaccinationcard.hospitalstaff.Doctor;
import vaccinationcard.hospitalstaff.NurseProfile;
import vaccinationcard.patient.Appointment;
import vaccinationcard.vaccinationdrive.VaccineManagement;

import java.util.ArrayList;

public class Hospital {
    private String hName;
    private String hAddress;
    private int requestedQty;
    private int usedQty;
    private float vaccineUsage;
    private float vaccineWaste;
    NurseProfile nurseProfile;
    Doctor doctor;
    VaccineManagement vaccineManagement;

    public Hospital(String hName, String hAddress) {
        this.hName = hName;
        this.hAddress = hAddress;
    }


    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }
    public boolean isMatch(String id){
        if(gethName().equals(id)) return true;
        return false;
    }

    public int getRequestedQty() {
        return requestedQty;
    }

    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }

    public int getUsedQty() {
        return usedQty;
    }

    public void setUsedQty(int usedQty) {
        this.usedQty = usedQty;
    }

    public float getVaccineUsage() {
        return vaccineUsage;
    }

    public void setVaccineUsage(float vaccineUsage) {
        this.vaccineUsage = vaccineUsage;
    }

    public float getVaccineWaste() {
        return vaccineWaste;
    }

    public void setVaccineWaste(float vaccineWaste) {
        this.vaccineWaste = vaccineWaste;
    }

    public NurseProfile getNurseProfile() {
        return nurseProfile;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public VaccineManagement getVaccineManagement() {
        return vaccineManagement;
    }

    @Override
    public String toString() {
        return "" +
                "Hospital Name='" + hName + '\'' +
                ",Hospital Address='" + hAddress + '\'' +
                "";
    }
}
