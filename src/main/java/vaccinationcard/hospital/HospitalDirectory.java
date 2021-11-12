package vaccinationcard.hospital;

import vaccinationcard.person.Person;

import java.util.ArrayList;

public class HospitalDirectory {
    ArrayList<Hospital> ClinicList ;

    public HospitalDirectory (){

        ClinicList = new ArrayList();

    }

    public Hospital addHospital(Hospital hospital) {

        ClinicList.add(hospital);
        return hospital ;
    }

    public Hospital findHospital(String hName) {

        for (Hospital h : ClinicList) {

            if (h.isMatch(hName)) {
                return h;
            }
        }
        return null;

    }

}
