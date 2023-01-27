import java.util.ArrayList;

public class SwimmingActivity extends Activity {
    private int lapLengthInMeters;
    private int numberOfLaps;
    private Float distanceInKm;

    // Constructor
    public SwimmingActivity(String device, int durationInMins, String description, int lapLengthInMeters,
            int numberOfLaps, ArrayList<Coach> activityCoachList) {
        super(device, durationInMins, description, activityCoachList);
        super.activityType = "Swimming";
        this.lapLengthInMeters = lapLengthInMeters;
        this.numberOfLaps = numberOfLaps;
        this.distanceInKm = (float) ((lapLengthInMeters * numberOfLaps) / 1000);
    }

    // Getters & Setters
    public int getLapLengthInMeters() {
        return lapLengthInMeters;
    }

    public void setLapLengthInMeters(int lapLengthInMeters) {
        this.lapLengthInMeters = lapLengthInMeters;
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    public Float getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Float distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    @Override
    public String toString() {
        if (App.currentLanguage.equals("nl")) {
            return "*** Zwem activiteit ***" +
                "\n" + "Activiteitdatum: " + dateOfCreation +
                "\n" + "Duratie:         " + durationInMins + " minuten" +
                "\n" + "Apparaat:        " + device +
                "\n" + "Omschrijving:    " + description +
                "\n" + "Afstand:         " + distanceInKm + " km" +
                "\n" + "Rondes:          " + numberOfLaps +
                "\n" + "Ronde lengte:    " + lapLengthInMeters +
                "\n" + "Coach(es):       " + activityCoachList;
        } else {
            return "*** Swimming activity ***" +
            "\n" + "Activitydate: " + dateOfCreation +
            "\n" + "Duration:     " + durationInMins + " minutes" +
            "\n" + "Device used:  " + device +
            "\n" + "Description:  " + description +
            "\n" + "Distance:     " + distanceInKm + " km" +
            "\n" + "Laps:         " + numberOfLaps +
            "\n" + "Lap length:   " + lapLengthInMeters +
            "\n" + "Coach(es):    " + activityCoachList;
        }
    }
}
