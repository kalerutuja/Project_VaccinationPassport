package vaccinationcard.organization;

import vaccinationcard.patient.*;
import vaccinationcard.person.*;

import java.util.*;

public class VaccinationCardAuthority {
    Map<Person, VaccinationCard> personVaccinationCardMap;

    public VaccinationCardAuthority() {
        this.personVaccinationCardMap = new HashMap<>();
    }

    public void add(Patient patient) {
        this.personVaccinationCardMap.put(patient.getPerson(), patient.getVaccinationCard());
    }

    public boolean verify(Person person, VaccinationCard vaccinationCard) {
        if (personVaccinationCardMap.containsKey(person)) {
            VaccinationCard original = personVaccinationCardMap.get(person);
            if (original == vaccinationCard) {
                System.out.println("Person is Vaccinated");
                return true;
            }
        }
        System.out.println("Person's vaccination card  doesnt exist ");
        return false;
    }
}
