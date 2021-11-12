package vaccinationcard.person;

import vaccinationcard.organization.VaccinationCardAuthority;

import java.util.Date;

public class Person {
    String id;
    Date DOB;
    int PassportNumber;
    VaccinationCardAuthority vaccinationCardAuthority;

    public Person(String id,Date DOB, int passportNumber) {
        this.id = id;
        this.DOB = DOB;
        PassportNumber = passportNumber;
    }

    public Date getDOB() {
        return DOB;
    }

    public int getPassportNumber() {
        return PassportNumber;
    }

    public String getPersonId(){

        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public VaccinationCardAuthority getVaccinationCardAuthority() {
        return vaccinationCardAuthority;
    }

    public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + id + '\'' +
                ", Date of Birth':" + DOB +
                ", Passport Number' :" + PassportNumber + '\'' +
                "";
    }
}
