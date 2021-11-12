package vaccinationcard.hospitalstaff;

import vaccinationcard.person.Person;

import java.util.ArrayList;

public class DoctorDirectory {
    ArrayList<Doctor> DoctorList;

    public DoctorDirectory() {

        DoctorList = new ArrayList();

    }

    public ArrayList<Doctor> getDoctorList() {
        return DoctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        DoctorList = doctorList;
    }

    public Doctor newDoctorProfile(Person p) {

        Doctor d = new Doctor(p);
        DoctorList.add(d);
        return d;
    }

    public Doctor findDoctor(String id) {

        for (Doctor d : DoctorList) {

            if (d.isMatch(id)) {
                return d;
            }
        }
        return null;
    }
}
