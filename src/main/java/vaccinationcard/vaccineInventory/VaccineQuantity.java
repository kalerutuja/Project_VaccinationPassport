package vaccinationcard.vaccineInventory;

import vaccinationcard.vaccine.*;

public class VaccineQuantity {
    Vaccine vaccine;
    int quantity;
    String batchNumber;

    public VaccineQuantity(Vaccine vaccine, int quantity, String batchNumber) {
        this.vaccine = vaccine;
        this.quantity = quantity;
        this.batchNumber = batchNumber;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

}

