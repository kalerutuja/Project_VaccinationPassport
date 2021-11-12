package vaccinationcard.person;

import java.util.ArrayList;
import java.util.Date;

public class PersonDirectory {
    ArrayList<Person> PersonList ;

    public PersonDirectory (){

        PersonList = new ArrayList();

    }

    public Person newPerson(String id, Date date, int passportNumber) {

        Person p = new Person(id,date,passportNumber);
        PersonList.add(p);
        return p;
    }

    public Person findPerson(String id) {

        for (Person p : PersonList) {

            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; //not found after going through the whole list

    }
}
