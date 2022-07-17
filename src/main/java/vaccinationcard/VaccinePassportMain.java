package vaccinationcard;

import com.github.javafaker.*;
import com.google.common.collect.*;
import vaccinationcard.distributor.DistributorCenter;
import vaccinationcard.distributor.DistributorDirectory;
import vaccinationcard.hospital.Hospital;
import vaccinationcard.hospital.HospitalDirectory;
import vaccinationcard.hospitalstaff.*;
import vaccinationcard.organization.Organization;
import vaccinationcard.organization.VaccinationCardAuthority;
import vaccinationcard.patient.*;
import vaccinationcard.person.Person;
import vaccinationcard.person.PersonDirectory;
import vaccinationcard.vaccinationdrive.*;
import vaccinationcard.vaccine.*;
import vaccinationcard.vaccineInventory.*;

//import javax.jws.soap.SOAPBinding;
//import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class VaccinePassportMain {


    public static void main(String[] args) {

        Faker faker = new Faker();

        Organization organization = new Organization(faker.company().name());
        DistributorDirectory cd = new DistributorDirectory();
        DistributorCenter distributorCenter = cd.newDistributorCenter(faker.company().name());

        HospitalDirectory hospitalDirectory = new HospitalDirectory();
        Hospital hospital = new Hospital(faker.company().name(), String.valueOf(faker.address().country()));
        hospitalDirectory.addHospital(hospital);

        VaccineDirectory vaccineDirectory = new VaccineDirectory();
        Disease disease1 = new Disease("COVID 19", 25);
        Vaccine vaccine1 = new Vaccine("Pfizer", "#1234", disease1, 20000, 200.50f, 1);
        Vaccine vaccine2 = new Vaccine("Johnson & Johnson", "#1235", disease1, 2500, 280.30f, 1);
        vaccineDirectory.addVaccine(vaccine1);
        vaccineDirectory.addVaccine(vaccine2);

        List<VaccineQuantity> vaccineInventoryArrayList = Lists.newArrayList(new VaccineQuantity(vaccine1, 1000, "1"));
        vaccineInventoryArrayList.add(new VaccineQuantity(vaccine2,25000,"2"));
        List<VaccinePreqQuestion> questionnaire = Lists.newArrayList(
                new VaccinePreqQuestion("Are you feeling sick today?", false),
                new VaccinePreqQuestion("Have you ever received a dose of COVID-19 vaccine?", false),
                new VaccinePreqQuestion("Do you have a weakened immune system caused by something such as HIV infection or cancer", false),
                new VaccinePreqQuestion("Have you ever had a severe allergic reaction", false),
                new VaccinePreqQuestion("Is the patient below 18 years old?", false));
        PersonDirectory pd = new PersonDirectory();

        Set<NurseAssignment> nurseAssignmentSet = Sets.newHashSet();
        for(int n=0; n<10; n++) {
            nurseAssignmentSet.add(new NurseAssignment(new NurseProfile(pd.newPerson(String.valueOf(faker.name().fullName()), (faker.date().birthday()), faker.random().nextInt(10000, 500000)))));
        }
        VaccinationEventDirectory vaccinationEventDirectory = new VaccinationEventDirectory();
        VaccinationEvent vaccinationEvent = new VaccinationEvent(questionnaire, vaccineInventoryArrayList, nurseAssignmentSet, hospital);
        vaccinationEventDirectory.addEvents(vaccinationEvent);
        vaccinationEvent.getVaccineInventoryArrayList();

        PatientDirectory patientDirectory = new PatientDirectory();
        VaccinationCardAuthority vaccinationCardAuthority = patientDirectory.getVaccinationCardAuthority();
        for (int i = 0; i < 4; i++) {
            Person person = pd.newPerson(String.valueOf(faker.name().fullName()), (faker.date().birthday()), faker.random().nextInt(10000, 500000));
            Patient patient = patientDirectory.newPatient(person);
            Person nurse = pd.newPerson(String.valueOf(faker.name().firstName()), (faker.date().birthday()), faker.random().nextInt(40000, 60000));
                NurseDirectory nurseDirectory = new NurseDirectory();
                NurseProfile nurseProfile = nurseDirectory.newNurseProfile(nurse);
                // System.out.println("\n Is person is vaccinated :" + vaccinationCardAuthority.verify(patient, patient1.getVaccinationCard()));
                for (int app=0; app<2; app++) {
                    Appointment appointment = new Appointment(faker.random().nextInt(100), LocalDate.now(), patient, vaccinationEvent);
                    appointment.bookAppointment(patient);
                    appointment.fillPreReqQuestions(getRandomAns(appointment.getQuestionnaire()));
                    appointment.printQuestionnaire(true);
                    appointment.checkInAtVaccinnationEvent();
                    System.out.println(patient.getVaccinationCard());

                    // Verifying the VC
                    boolean result = vaccinationCardAuthority.verify(person, patient.getVaccinationCard());
                    System.out.println("Is person is vaccinated, Verification Result: "+result);


                    // Cheating Scenarios:
                    try {
                        NurseAssignment fakeNurseAssignment = new NurseAssignment(new NurseProfile(pd.newPerson(String.valueOf(faker.name().fullName()), (faker.date().birthday()), faker.random().nextInt(10000, 500000))));
                        fakeNurseAssignment.vaccinatePatient(appointment);
                    } catch (Exception e) {
                        //e.printStackTrace();
                        System.out.println("NOT ALLOWED: Caught cheating nurse "+e.getMessage());
                    }
                }
            }
        }

        private static List<Boolean> getRandomAns (List < VaccinePreqQuestion > questionnaire) {
            return questionnaire.stream().map(q -> q.getExpectedAns()).collect(Collectors.toList());
        }

        private static List<Boolean> getWrongAns (List < VaccinePreqQuestion > questionnaire) {
            return questionnaire.stream().map(q -> !q.getExpectedAns()).collect(Collectors.toList());
        }

    }