import java.util.ArrayList;

public class RunningActivity extends Activity {
    private Float distanceInKm;
    private int minPerKm;

    // Constructor
    public RunningActivity(String device, int durationInMins, String description, Float distanceInKm,
            ArrayList<Coach> activityCoachList) {
        super(device, durationInMins, description, activityCoachList);
        super.activityType = "Running";
        this.distanceInKm = distanceInKm;
        this.minPerKm = (int) (60 / (distanceInKm / (durationInMins / 60)));
    }
    
    public RunningActivity() {
    }

    // Getters & Setters
    public Float getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Float distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public int getMinPerKm() {
        return minPerKm;
    }

    // Methods
    @Override
    public String toString() {
        if (App.currentLanguage.equals("nl")) {
            return "*** Hardloop activity ***" +
                    "\n" + "Activiteitdatum: " + dateOfCreation +
                    "\n" + "Duratie:         " + durationInMins + " minuten" +
                    "\n" + "Apparaat:        " + device +
                    "\n" + "Omschrijving:    " + description +
                    "\n" + "Afstand:         " + distanceInKm + " km" +
                    "\n" + "Tempo:           " + minPerKm + " min/km" +
                    "\n" + "Coach(es):       " + activityCoachList;
        } else {
            return "*** Running activity ***" +
                    "\n" + "Activitydate: " + dateOfCreation +
                    "\n" + "Duration:     " + durationInMins + " minutes" +
                    "\n" + "Device used:  " + device +
                    "\n" + "Description:  " + description +
                    "\n" + "Distance:     " + distanceInKm + " km" +
                    "\n" + "Pace:         " + minPerKm + " min/km" +
                    "\n" + "Coach(es):    " + activityCoachList;
        }
    }
}
