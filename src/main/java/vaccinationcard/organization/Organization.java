package vaccinationcard.organization;

import vaccinationcard.distributor.DistributorCenter;
import vaccinationcard.patient.Patient;
import vaccinationcard.patient.VaccinationCard;
import vaccinationcard.person.Person;

import java.util.*;

public class Organization {
    private String name;
    private int ID;


    public Organization(String name) {
        this.name = name;
        this.ID = ID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}