package vaccinationcard.vaccineInventory;

import vaccinationcard.vaccine.Vaccine;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private Vaccine vaccine;
    private String status;
    VaccineQuantity vaccineQuantity;

    private ArrayList<Vaccine> vaccineInventory;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void addVaccineToInventory(Vaccine vaccine) {
        boolean foundUpdate = false;
        if (vaccineInventory.contains(vaccine)) {
            Vaccine vacc = null;
            for (Vaccine v : vaccineInventory) {
                if (vaccine.equals(v)) {
                    vacc = v;
                    foundUpdate = true;
                    vacc.setQuantity(vacc.getQuantity() + vaccine.getQuantity());
                }
            }
        } else {
            vaccineInventory.add(vaccine);
        }
    }

    public void deleteVaccine(Vaccine vaccine)
    {
        vaccineInventory.remove(vaccine);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "vaccine=" + vaccine +
                ", status='" + status + '\'' +
                ", vaccineQuantity=" + vaccineQuantity +
                ", vaccineInventory=" + vaccineInventory +
                '}';
    }
}



