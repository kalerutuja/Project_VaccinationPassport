package vaccinationcard.patient;

import vaccinationcard.organization.VaccinationCardAuthority;
import vaccinationcard.person.Person;

import java.util.List;

public class Patient {

    Person person;
    private String FullName;
    private String DOB;
    private int MedicalNumber;
    protected String patientVaccinationStatus;

    private List<Appointment> appointments;

    MedicalHistory medicalHistory;
    VaccinationCard vaccinationCard;


    public Patient(Person p) {
        this.person = p;
        this.medicalHistory= new MedicalHistory();
        this.vaccinationCard = new VaccinationCard(this);
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }
    public Person getPerson() {
        return person;
    }

    public VaccinationCard getVaccinationCard() {
        return vaccinationCard;
    }

    public void addToMedicalHistory(Disease disease) {
        this.medicalHistory.add(disease);
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getMedicalNumber() {
        return MedicalNumber;
    }

    public void setMedicalNumber(int medicalNumber) {
        MedicalNumber = medicalNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public String getPatientVaccinationStatus() {
        return patientVaccinationStatus;
    }

    public void setPatientVaccinationStatus(String patientVaccinationStatus) {
        this.patientVaccinationStatus = patientVaccinationStatus;
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + person+"";
    }
}

