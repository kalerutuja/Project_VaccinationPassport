package vaccinationcard.patient;

public enum DiseaseStatus {
    Unknown,
    Intermittent,
    Active,
    Inactive,
    Other;

    public static DiseaseStatus getByIndex(int i){
        if (i<=0 || i< values().length){
            return values()[i];
            } return Other;
        }
    }
