package vaccinationcard.hospitalstaff;

import vaccinationcard.hospital.Hospital;
import vaccinationcard.patient.*;
import vaccinationcard.person.Person;
import vaccinationcard.vaccinationdrive.VaccinationEvent;
import vaccinationcard.vaccinationdrive.VaccineManagement;

import java.util.ArrayList;

public class NurseProfile {
    Person person;
    Hospital hospital;
    ArrayList<NurseAssignment> nurseAssignments;

    public NurseProfile(Person person) {
        this.person = person;
        this.hospital = hospital;
        this.nurseAssignments = nurseAssignments;
    }

    public ArrayList<NurseAssignment> getNurseAssignments() {
        return nurseAssignments;
    }

    public void setNurseAssignments(ArrayList<NurseAssignment> nurseAssignments) {
        this.nurseAssignments = nurseAssignments;
    }

    public NurseAssignment AssignAsVolunteer(VaccinationEvent va) {

        NurseAssignment na = new NurseAssignment(this);
        nurseAssignments.add(na);

        return na;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ""+
                "'" + person +
                '}';
    }
}

