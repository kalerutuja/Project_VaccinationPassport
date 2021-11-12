package vaccinationcard.distributor;

import vaccinationcard.vaccine.VaccineDirectory;

public class DistributorCenter {
    String name;
    private VaccineDirectory distVaccineDirectory;

    public DistributorCenter(String name) {
        this.name = name;
        this.distVaccineDirectory = distVaccineDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VaccineDirectory getDistVaccineDirectory() {
        return distVaccineDirectory;
    }

    public void setDistVaccineDirectory(VaccineDirectory distVaccineDirectory) {
        this.distVaccineDirectory = distVaccineDirectory;
    }

    @Override
    public String toString() {
        return "DistributorCenter{" +
                "name='" + name + '\'' +
                ", distVaccineDirectory=" + distVaccineDirectory +
                '}';
    }
}
