package vaccinationcard.vaccinationdrive;

import com.github.javafaker.*;
import vaccinationcard.hospital.Hospital;
import vaccinationcard.hospitalstaff.NurseAssignment;
import vaccinationcard.hospitalstaff.NurseDirectory;
import vaccinationcard.hospitalstaff.NurseProfile;
import vaccinationcard.patient.*;
import vaccinationcard.vaccine.Vaccine;
import vaccinationcard.vaccineInventory.VaccineQuantity;

import java.util.*;
import java.util.stream.*;

public class VaccinationEvent {
    private String name;
    private Date startDate;
    private int capacity;
    private Hospital hospital;
    private String Status;
    private VaccineManagement eventManagement;
    private NurseProfile nurseProfile;

    Faker faker;

    public Set<NurseAssignment> nurseAssignmentList;

    public List<VaccinePreqQuestion> getQuestionnaire() {
        return questionnaire;
    }
    public List<VaccinePreqQuestion> questionnaire;

    private List<VaccineQuantity> vaccineInventoryArrayList;

    public VaccinationEvent(List<VaccinePreqQuestion> questionnaire, List<VaccineQuantity> vaccineInventoryArrayList,Set<NurseAssignment> nurseAssignmentList, Hospital hospital) {
        this.questionnaire = questionnaire;
        this.vaccineInventoryArrayList = vaccineInventoryArrayList;
        this.nurseAssignmentList = nurseAssignmentList;
        faker = new Faker();
        nurseAssignmentList.forEach( nurseAssignment -> {
            nurseAssignment.setVaccinationEvent(this);
            this.hospital = hospital;
        });
        setStatus("vaccination event started ");
    }

    public Optional<VaccineQuantity> getAvailableVaccine() {
        List<VaccineQuantity> list = vaccineInventoryArrayList.stream().filter(vi-> vi.getQuantity()> 0).collect(Collectors.toList());
        if(list.size() ==0) return Optional.empty();
       return Optional.of(list.get(faker.random().nextInt(list.size())));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public VaccineManagement getEventManagement() {
        return eventManagement;
    }

    public void setEventManagement(VaccineManagement eventManagement) {
        this.eventManagement = eventManagement;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<VaccineQuantity> getVaccineInventoryArrayList() {
        return this.vaccineInventoryArrayList;
    }

    public void setVaccineInventoryArrayList(ArrayList<VaccineQuantity> vaccineInventoryArrayList) {
        this.vaccineInventoryArrayList = vaccineInventoryArrayList;
    }

    public void setNurseAssignmentList(Set<NurseAssignment> nurseAssignmentList) {
        this.nurseAssignmentList = nurseAssignmentList;
    }

    public Set<NurseAssignment> getNurseAssignmentList() {
        return nurseAssignmentList;
    }

    public NurseProfile getNurseProfile() {
        return nurseProfile;
    }

    public void setNurseProfile(NurseProfile nurseProfile) {
        this.nurseProfile = nurseProfile;
    }

    public boolean process(Appointment appointment) {
       List<NurseAssignment> list  = nurseAssignmentList.stream().filter(n-> n.getAvailable() == true).collect(Collectors.toList());
       if(list.size() == 0) return false;
        NurseAssignment nurseAssignment = list.get(faker.random().nextInt(list.size()));
        if(appointment.isQualified()) {
            System.out.println("Patient is qualified for vaccination based on Questionnaire filled.");
            nurseAssignment.vaccinatePatient(appointment);
        } else {
            String msg = "Caught Cheating ...xxxxxxxxxxxxx : Patient is NOT qualified for vaccination based on Questionnaire filled.";
            System.out.println(msg);
            throw new IllegalArgumentException(msg);
        }
        return true;
    }

    @Override
    public String toString() {
        return "VaccinationEvent Detail:" + " "+ hospital +
                "";
    }
}



