package vaccinationcard.organization;

import java.util.ArrayList;

public class OrganizationDirectory {
    ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

}
