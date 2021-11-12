package vaccinationcard.hospitalstaff;

import vaccinationcard.patient.*;
import vaccinationcard.vaccinationdrive.VaccinationEvent;
import vaccinationcard.vaccineInventory.*;

import java.util.*;

public class NurseAssignment {

    VaccinationEvent vaccinationEvent;
    NurseProfile nurseProfile;
    Boolean isAvailable = true;

    public NurseAssignment(NurseProfile np){
        nurseProfile = np;
    }
    public void vaccinatePatient(Appointment appointment) {
//        System.out.println("Patient is vaccinated now: " +appointment.getAssignedPatient());
        System.out.println("Patient has been vaccinated by assigned nurse. Nurse Details are given below: \n"+this.toString());
        Patient p = appointment.getAssignedPatient();

        if(!appointment.getVaccinationEvent().nurseAssignmentList.contains(this)) {
            throw new IllegalArgumentException("Nurse is not allowed to vaccinate the patient, as he/she is not part of vaccination event "+this.toString());
        }
        VaccinationCard vaccinationCard =  p.getVaccinationCard();
       Optional<VaccineQuantity> vaccineQuantityOptional = vaccinationEvent.getAvailableVaccine();
       if(vaccineQuantityOptional.isPresent()) {
           vaccinationCard.addRecord(this, appointment, vaccineQuantityOptional.get().getVaccine());
       } else {
           throw new IllegalArgumentException("No Vaccine is present in the inventory");

       }
        System.out.println("**************************************************************************");
    }


    public NurseProfile getNurseProfile(){

        return nurseProfile;
    }
    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public VaccinationEvent getVaccinationEvent() {
        return vaccinationEvent;
    }

    public void setVaccinationEvent(VaccinationEvent vaccinationEvent) {
        this.vaccinationEvent = vaccinationEvent;
    }

    @Override
    public String toString() {
        return "Nurse Information:" +
                ",=" + nurseProfile +
                '}';
    }
}
