package vaccinationcard.patient;

import vaccinationcard.vaccinationdrive.VaccinationEvent;
import vaccinationcard.vaccinationdrive.VaccinePreqQuestion;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class Appointment {
    private int appointmentId;
    private LocalDate appointmentDate;
    private Patient assignedPatient;
    private VaccinationEvent vaccinationEvent;
    private boolean appointmentBook;

    Map<VaccinePreqQuestion,Boolean> questionToUserAnsMap = new HashMap<>();

    public Appointment(int appointmentId, LocalDate appointmentDate, Patient assignedPatient, VaccinationEvent vaccinationEvent) {
        this.appointmentId = appointmentId;
        this.assignedPatient = assignedPatient;
        LocalDate today = LocalDate.now();
        this.vaccinationEvent = vaccinationEvent;

        vaccinationEvent.getQuestionnaire().stream().forEach(q-> {
            questionToUserAnsMap.put(q, false);
        });
    }

    public boolean isAppointmentBook() {
        return appointmentBook;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Patient getAssignedPatient() {
        return assignedPatient;
    }

    public void setAssignedPatient(Patient assignedPatient) {
        this.assignedPatient = assignedPatient;
    }

    public VaccinationEvent getVaccinationEvent() {
        return vaccinationEvent;
    }

    public void setVaccinationEvent(VaccinationEvent vaccinationEvent) {
        this.vaccinationEvent = vaccinationEvent;
    }


    public boolean bookAppointment(Patient assignedPatient) {
        setAssignedPatient(assignedPatient);
        appointmentBook = true;
        return true;
    }

    public boolean cancelAppointment(Patient assignedPatient) {
        setAssignedPatient(null);
        return false;
    }

    public void setAppointmentBook(boolean appointmentBook) {
        this.appointmentBook = appointmentBook;
    }

    public Map<VaccinePreqQuestion, Boolean> getQuestionToUserAnsMap() {
        return questionToUserAnsMap;
    }


    public void printQuestionnaire(boolean printAns) {
        System.out.println("************Welcome to the COVID19 Vaccination Portal************\n");
        System.out.println("Filled all the Information to book an Appointment:");
//        System.out.println("\nAnswer to all Questionnaire  ********************** ");
        List<VaccinePreqQuestion> vaccinePreqQuestionsList = getQuestionnaire();
        for (int i=0; i < vaccinePreqQuestionsList.size(); i++) {
            VaccinePreqQuestion question = vaccinePreqQuestionsList.get(i);
            String ans = "\nUser Ans: "+questionToUserAnsMap.get(question);
            if (printAns) {
                System.out.println( question + ans);
            } else {
                System.out.println(question);
            }
        }
        System.out.println("***************************************************************\n");
    }

    public void checkInAtVaccinnationEvent() {
        this.vaccinationEvent.process(this);
    }

    public List<VaccinePreqQuestion> getQuestionnaire() {
        return vaccinationEvent.getQuestionnaire();
    }

    public void fillPreReqQuestions(List<Boolean> userAnsList) {
        List<VaccinePreqQuestion> vaccinePreqQuestionsList = getQuestionnaire();
        if (userAnsList.size() < vaccinePreqQuestionsList.size()) {
           throw new IllegalArgumentException("NOTE: User is required to fill all ans of questions!");
        }
        for (int i=0; i<userAnsList.size(); i++) {
            questionToUserAnsMap.put(vaccinePreqQuestionsList.get(i), userAnsList.get(i));
        }
    }

    public boolean isQualified() {
        boolean isQualified = true;
        Set<VaccinePreqQuestion> keySet = questionToUserAnsMap.keySet();
        for (VaccinePreqQuestion question : keySet) {
            if (question.getExpectedAns() != questionToUserAnsMap.get(question)) {
                isQualified = false;
            }
        }
        return isQualified;
    }


    public String toString() {
        return "Appointment id:'" + appointmentId + " "+vaccinationEvent + "";
    }

}


