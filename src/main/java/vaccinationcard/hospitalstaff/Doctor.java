package vaccinationcard.hospitalstaff;

import vaccinationcard.hospital.Hospital;
import vaccinationcard.person.Person;

public class Doctor {
    Person person;
    Hospital hospital;

    public Doctor(Person person) {
        this.person = person;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "person=" + person +
                ", hospital=" + hospital +
                '}';
    }
}
