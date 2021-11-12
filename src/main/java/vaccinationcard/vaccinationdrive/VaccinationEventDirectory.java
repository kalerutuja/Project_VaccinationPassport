package vaccinationcard.vaccinationdrive;

import java.util.ArrayList;

public class VaccinationEventDirectory {

    private ArrayList<VaccinationEvent> eventList;

    public VaccinationEventDirectory() {
        eventList = new ArrayList();
    }

    // TODO Create factory method for event;

    public ArrayList<VaccinationEvent> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<VaccinationEvent> eventList) {
        this.eventList = eventList;
    }

    public VaccinationEvent addEvents(VaccinationEvent e )
    {
        eventList.add(e);
        return e;
    }
}
