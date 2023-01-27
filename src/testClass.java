
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class testClass {
    RunningActivity activity = new RunningActivity();
    Coach coach = new Coach("Hendrik", "Janssen", "Fysiotherapeut");
    Scanner in = new Scanner(System.in);

    @Test
    public void addCoachTest() {
        activity.activityCoachList.add(coach);
        assertTrue("Coach bestaat niet", activity.activityCoachList.get(0).getFirstName().equals("Hendrik"));
    }
}
