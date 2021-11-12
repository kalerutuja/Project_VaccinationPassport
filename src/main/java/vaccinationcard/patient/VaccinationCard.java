package vaccinationcard.patient;

import com.github.javafaker.*;
import vaccinationcard.distributor.DistributorDirectory;
import vaccinationcard.hospital.Hospital;
import vaccinationcard.hospital.HospitalDirectory;
import vaccinationcard.hospitalstaff.*;
import vaccinationcard.organization.Organization;
import vaccinationcard.organization.OrganizationDirectory;
import vaccinationcard.person.Person;
import vaccinationcard.person.PersonDirectory;
import vaccinationcard.vaccinationdrive.VaccinationEvent;
import vaccinationcard.vaccinationdrive.VaccinationEventDirectory;
import vaccinationcard.vaccine.*;

import java.sql.Time;
import java.util.*;
import java.util.stream.IntStream;

public class VaccinationCard {
    Date createdDate;
    Patient patient;

    Map<Appointment, Vaccine> appointmentVaccineMap;

    public VaccinationCard(Patient patient) {
        this.patient = patient;
        appointmentVaccineMap = new HashMap<>();
        createdDate = new Date();

    }


    @Override
    public String toString() {
        return "\nVaccination Card of the Patient:" +
                "\nVaccination card created Date:'" + createdDate +
                "\nPatient Information:'" + patient +
                "\nPatient vaccination Detail:'" +appointmentVaccineMap +
                "";
    }
        public void addRecord(NurseAssignment nurseAssignment, Appointment appointment, Vaccine vaccine) {
        if (appointment.getVaccinationEvent().nurseAssignmentList.contains(nurseAssignment)) {
            appointmentVaccineMap.put(appointment, vaccine);
        } else {
            throw new IllegalArgumentException("\n Nurse does not belong to given vaccination event, " + nurseAssignment);
        }
    }

    //*********Cheating Scenario**************//

}

