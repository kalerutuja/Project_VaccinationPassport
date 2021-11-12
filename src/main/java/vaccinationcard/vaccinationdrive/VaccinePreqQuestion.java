package vaccinationcard.vaccinationdrive;

public class VaccinePreqQuestion {
    String question;

    @Override
    public String toString() {
        return "VaccinePreqQuestion{" +
                "question='" + question + '\'' +
                ", expectedAns=" + expectedAns +
                '}';
    }

    Boolean expectedAns;

    public VaccinePreqQuestion(String question, Boolean expectedAns) {
        this.question = question;
        this.expectedAns = expectedAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Boolean getExpectedAns() {
        return expectedAns;
    }

    public void setExpectedAns(Boolean expectedAns) {
        this.expectedAns = expectedAns;
    }
}
