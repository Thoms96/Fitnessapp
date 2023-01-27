import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Activity {
    protected Long activityID;
    protected LocalDate dateOfCreation;
    protected String device;
    protected int durationInMins;
    protected String description;
    protected String activityType;
    protected ArrayList<Coach> activityCoachList = new ArrayList<Coach>();

    public Activity(String device, int durationInMins, String description, ArrayList<Coach> activityCoachList) {
        this.device = device;
        this.durationInMins = durationInMins;
        this.description = description;
        this.activityID = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        this.dateOfCreation = LocalDate.now();
        this.activityCoachList = activityCoachList;
    }

    public Activity() {
    }

    // Getters & Setters
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = stringToDate(dateOfCreation);
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getDurationInMins() {
        return durationInMins;
    }

    public void setDurationInMins(int durationInMins) {
        this.durationInMins = durationInMins;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getActivityID() {
        return activityID;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public static LocalDate stringToDate(String rawDate) {
        try {
            rawDate = rawDate.replace("/", "");
            rawDate = rawDate.replace("-", "");
            String day = rawDate.substring(0, 2);
            String month = rawDate.substring(2, 4);
            String year = rawDate.substring(4, 8);
            String convertedDate = year + "-" + month + "-" + day;
            LocalDate parsedDate = LocalDate.parse(convertedDate);
            return parsedDate;
        } catch (Exception e) {
            System.out.println("Error: invalid date.");
            return null;
        }
    }

    public static ArrayList<Coach> addActivityCoach() {
        // English
        ArrayList<Coach> activityCoachList = new ArrayList<Coach>();
        Scanner in = new Scanner(System.in);
        if (App.currentLanguage.equals("en")) {
            loop1: while (true) {
                System.out.println("Do you want to add a coach for this activity? (1. Yes | 2. No)");
                String choice = in.nextLine();
                if (choice.equals("1")) {
                    if (App.activeUser.coachList.size() > 0) {
                        while (true) {
                            for (int i = 0; i < App.activeUser.coachList.size(); i++) {
                                System.out.println(i + 1 + ". " + (App.activeUser.coachList.get(i)).toString());
                            }
                            System.out.println("Enter a coachnumber from above to add:");
                            int choiceInt = Integer.parseInt(in.nextLine());
                            if (choiceInt > 0 && choiceInt <= App.activeUser.coachList.size()) {
                                activityCoachList.add(App.activeUser.coachList.get(choiceInt - 1));
                                System.out.println("~ Coach added to activity.");
                                break loop1;
                            } else {
                                System.out.println("Coach does not exists. Try an existing coach number.");
                            }
                        }
                    } else {
                        System.out.println(
                                "~ No coaches added yet. You can add a coach in \"Manage coaches\" from the mainmenu.");
                        break;
                    }
                } else if (choice.equals("2")) {
                    break;
                } else {
                    System.out.println("~ Invalid input.");
                }
            }
        // Dutch
        } else if (App.currentLanguage.equals("nl")) {
            loop1: while (true) {
                System.out.println("Wil je een coach toevoegen voor deze activiteit? (1. Ja | 2. Nee)");
                String choice = in.nextLine();
                if (choice.equals("1")) {
                    if (App.activeUser.coachList.size() > 0) {
                        while (true) {
                            for (int i = 0; i < App.activeUser.coachList.size(); i++) {
                                System.out.println(i + 1 + ". " + (App.activeUser.coachList.get(i)).toString());
                            }
                            System.out.println("Kies een coachnummer van boven om toe te voegen:");
                            int choiceInt = Integer.parseInt(in.nextLine());
                            if (choiceInt > 0 && choiceInt <= App.activeUser.coachList.size()) {
                                activityCoachList.add(App.activeUser.coachList.get(choiceInt - 1));
                                System.out.println("~ Coach toegevoegd aan activiteit.");
                                break loop1;
                            } else {
                                System.out.println("Coach bestaat niet. Probeer een ander coach nummer.");
                            }
                        }
                    } else {
                        System.out.println(
                                "~ Je hebt nog geen coaches toegevoegd. Je kan er een toevoegen in \"Manage coaches\" in het hoofdmenu.");
                        break;
                    }
                } else if (choice.equals("2")) {
                    break;
                } else {
                    System.out.println("~ Verkeerde invoer.");
                }
            }
        }
            return activityCoachList;
    }

    public String getDetails() {
        return activityType + " | " + dateOfCreation + " | " + description + " | " + activityID;
    }
}
