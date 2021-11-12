package vaccinationcard.hospitalstaff;

import vaccinationcard.person.Person;

import java.util.ArrayList;

public class NurseDirectory {
    ArrayList<NurseProfile> NurseList;

    public NurseDirectory() {

        NurseList = new ArrayList();

    }

    public ArrayList<NurseProfile> getNurseList() {
        return NurseList;
    }

    public void setNurseList(ArrayList<NurseProfile> NurseList) {
        NurseList = NurseList;
    }


    public NurseProfile newNurseProfile(Person p) {

        NurseProfile sp = new NurseProfile(p);
        NurseList.add(sp);
        return sp;
    }

    public NurseProfile findNurse(String id) {

        for (NurseProfile sp : NurseList) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null;
    }

}
