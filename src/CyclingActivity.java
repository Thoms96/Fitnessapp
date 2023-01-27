import java.util.ArrayList;

public class CyclingActivity extends Activity {
    private Float distanceInKm;
    private int kmPerHour;

    // Constructor
    public CyclingActivity(String device, int durationInMins, String description, Float distanceInKm, int kmPerHour,
            ArrayList<Coach> activityCoachList) {
        super(device, durationInMins, description, activityCoachList);
        super.activityType = "Cycling";
        this.distanceInKm = distanceInKm;
        this.kmPerHour = kmPerHour;
    }

    // Getters & Setters
    public Float getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Float distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public int getKmPerHour() {
        return kmPerHour;
    }

    public void setKmPerHour(int kmPerHour) {
        this.kmPerHour = kmPerHour;
    }

    @Override
    public String toString() {
        if (App.currentLanguage.equals("nl")) {
            return "*** Fiets activiteit ***" +
                    "\n" + "Activiteitdatum: " + dateOfCreation +
                    "\n" + "Duratie:         " + durationInMins + " minuten" +
                    "\n" + "Apparaat:        " + device +
                    "\n" + "Omschrijving:    " + description +
                    "\n" + "Afstand:         " + distanceInKm + " km" +
                    "\n" + "Snelheid:        " + kmPerHour + " km/pu" +
                    "\n" + "Coach(es):       " + activityCoachList;
        } else {
            return "*** Cycling activity ***" +
                    "\n" + "Activitydate: " + dateOfCreation +
                    "\n" + "Duration:     " + durationInMins + " minutes" +
                    "\n" + "Device used:  " + device +
                    "\n" + "Description:  " + description +
                    "\n" + "Distance:     " + distanceInKm + " km" +
                    "\n" + "Speed:        " + kmPerHour + " km/h" +
                    "\n" + "Coach(es):    " + activityCoachList;
        }
    }
}
