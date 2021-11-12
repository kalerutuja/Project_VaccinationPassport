package vaccinationcard.vaccine;

import vaccinationcard.patient.*;

import java.util.ArrayList;

public class VaccineDirectory {
    ArrayList<Vaccine> vaccineList;

    public VaccineDirectory(){
        vaccineList = new ArrayList();
    }

    public Vaccine createVaccine(String vaccineName, String vaccineId, Disease disease, int quantity, float price, int numOfDose) {
        Vaccine vaccine = new Vaccine(vaccineName, vaccineId, disease, quantity, price, numOfDose);
        addVaccine(vaccine);
        return vaccine;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(ArrayList<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }


    public void addVaccine(Vaccine vaccine) { //add vaccine to directory
        vaccineList.add(vaccine);
    }

    public void removeVaccine(Vaccine vaccine) { // remove vaccine from directory
        vaccineList.remove(vaccine);
    }
}
