package vaccinationcard.vaccinationdrive;

import vaccinationcard.hospitalstaff.NurseProfile;
import vaccinationcard.patient.Appointment;
import vaccinationcard.patient.Patient;

import java.util.ArrayList;

public class VaccineManagement {
    private ArrayList<NurseProfile> Volunteer;
    private ArrayList<Appointment> appointmentList;

    public VaccineManagement() {
        Volunteer = new ArrayList<>();
        appointmentList = new ArrayList<>();
    }

    public ArrayList<NurseProfile> getVolunteer() {
        return getVolunteer();
    }

    public void setVolunteer(ArrayList<NurseProfile> volunteer) {
        Volunteer = volunteer;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}