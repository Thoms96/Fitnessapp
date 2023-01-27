import java.util.ArrayList;

public class PowerActivity extends Activity {
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    
    // Constructor
    public PowerActivity(String device, int durationInMins, String description, ArrayList<Coach> activityCoachList) {
        super(device, durationInMins, description, activityCoachList);
        super.activityType = "Power";
    }

    public void getExercises() {
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
        System.out.println("----------------------------------");
    }

    public String getDetails() {
        return activityType + " | " + dateOfCreation + " | " + description + " | " + activityID;
    }

    @Override
    public String toString() {
        if (App.currentLanguage.equals("nl")) {
            return "*** Kracht activiteit ***" +
                    "\n" + "Activiteitdatum: " + dateOfCreation +
                    "\n" + "Duratie:         " + durationInMins + " minuten" +
                    "\n" + "Apparaat:        " + device +
                    "\n" + "Coach(es):       " + activityCoachList +
                    "\n" + "Oefeningen       " + "\n----------------------------------";
        } else {
            return "*** Power activity ***" +
                    "\n" + "Activitydate: " + dateOfCreation +
                    "\n" + "Duration:     " + durationInMins + " minutes" +
                    "\n" + "Device used:  " + device +
                    "\n" + "Coach(es):    " + activityCoachList +
                    "\n" + "Exercises:    " + "\n----------------------------------";
        }
    }
}
