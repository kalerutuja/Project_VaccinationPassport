package vaccinationcard.patient;

import java.util.*;

public class Disease {
    private String name;
    private int criticalLevel;
    DiseaseStatus diseaseStatus;

    DiseaseStatus currentStatus = DiseaseStatus.Unknown; // Active or Inactive or Intermittent
    private Date startDate = null;
    private Date endDate = null;
    Map<Date, String> dateToMedicationMap;

    public Disease(String name, int criticalLevel) {
        this.name = name;
        this.criticalLevel = criticalLevel;
        this.dateToMedicationMap = new HashMap<>();
        this.diseaseStatus = diseaseStatus;
    }
    public DiseaseStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(DiseaseStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void addMedications(Date date, String medicines) {
        dateToMedicationMap.put(date, medicines);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCriticalLevel() {
        return criticalLevel;
    }

    public void setCriticalLevel(int criticalLevel) {
        this.criticalLevel = criticalLevel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "" + name + '\'' +
                "";
    }
}
