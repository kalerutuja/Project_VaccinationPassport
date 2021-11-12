package vaccinationcard.distributor;


import vaccinationcard.patient.VaccinationCard;

import java.util.*;

public class DistributorDirectory {

    ArrayList<DistributorCenter> distributorCenters;

    public DistributorDirectory() {

        distributorCenters = new ArrayList();
    }

    public ArrayList<DistributorCenter> getDistributorCenters() {

        return distributorCenters;
    }

    public DistributorCenter newDistributorCenter(String name){
        DistributorCenter dc = new DistributorCenter(name);
        distributorCenters.add(dc);

        return dc;

    }

    public void removeDistributorCenter(DistributorCenter s) {

        distributorCenters.remove(s);
    }

    public DistributorCenter searchDistributorCenter(String keyword) {
        for (DistributorCenter distributorCenter : distributorCenters) {
            if (distributorCenter.getName().equals(keyword)) {
                return distributorCenter;
            }
        }
        return null;
    }

}

