package vaccinationcard.patient;

import java.util.*;

public class MedicalHistory {

    List<Disease> diseasesList;

    public MedicalHistory() {
        diseasesList= new ArrayList<>();
    }

    public void add(Disease disease) {
        diseasesList.add(disease);
    }

}




