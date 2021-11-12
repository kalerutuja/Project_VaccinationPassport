package vaccinationcard.patient;

import vaccinationcard.organization.*;
import vaccinationcard.person.Person;

import java.util.ArrayList;

public class PatientDirectory {
    ArrayList<Patient> patientList;
    VaccinationCardAuthority vaccinationCardAuthority ;

    public VaccinationCardAuthority getVaccinationCardAuthority() {
        return vaccinationCardAuthority;
    }

    public PatientDirectory() {
        patientList  = new ArrayList();
        vaccinationCardAuthority = new VaccinationCardAuthority();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public Patient newPatient(Person p) {
        Patient patient = new Patient(p);
        patientList.add(patient);
        vaccinationCardAuthority.add(patient);
        return patient;
    }

    public Patient findPatient(String id) {

        for (Patient d : patientList) {

            if (d.isMatch(id)) {
                return d;
            }
        }
        return null;
    }
}
