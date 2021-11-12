package vaccinationcard.vaccine;

import vaccinationcard.patient.*;

public class Vaccine {

    private String vaccineName;
    private String vaccineId;
    private Disease disease;
    private int quantity;
    private float price;
    private int numOfDose;


    public Vaccine(String vaccineName, String vaccineId, Disease disease, int quantity, float price, int numOfDose) {
        this.vaccineName = vaccineName;
        this.vaccineId = vaccineId;
        this.disease = disease;
        this.quantity = quantity;
        this.price = price;
        this.numOfDose = numOfDose;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumOfDose() {
        return numOfDose;
    }

    public void setNumOfDose(int numOfDose) {
        this.numOfDose = numOfDose;
    }

    @Override
    public String toString() {
        return "\nVaccine Information: " +
                ",vaccine Name='" + vaccineName + '\'' +
                ",vaccine lot number=" + vaccineId + '\'' +
                ",Disease Name=" + disease + '\'' +
                ",Dose Of Vaccine=" + numOfDose + '\'' +
                "";
    }
}

