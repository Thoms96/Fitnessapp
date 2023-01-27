import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<User> userList = new ArrayList<User>();

    public static User activeUser;
    public static String currentLanguage = "en";

    public static void createNewAccount() {
        // English
        if (currentLanguage.equals("en")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your emailadress (e.g. john.doe@gmail.com):");
            String userEmail = in.nextLine();
            System.out.println("Enter a password:");
            String userPassword = in.nextLine();
            while (true) {
                System.out.println("Enter password again:");
                String userPasswordCheck = in.nextLine();
                if (!userPassword.equals(userPasswordCheck)) {
                    System.out.println("~ Passwords do not match! Please enter password carefully...");
                } else {
                    break;
                }
            }
            App.userList.add(new User(userEmail, userPassword));
            System.out.println("~ Account created successfully.");
            loginMenu();
            in.close();
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Voer je emailadres in (b.v. john.doe@gmail.com):");
            String userEmail = in.nextLine();
            System.out.println("Voer een paswoord in:");
            String userPassword = in.nextLine();
            while (true) {
                System.out.println("Voer paswoord opnieuw in:");
                String userPasswordCheck = in.nextLine();
                if (!userPassword.equals(userPasswordCheck)) {
                    System.out.println("~ Passwoorden zijn niet hetzelfde! Voer wachtwoorden voorzichtig in...");
                } else {
                    break;
                }
            }
            App.userList.add(new User(userEmail, userPassword));
            System.out.println("~ Account succesvol gecreëerd.");
            loginMenu();
            in.close();
        }
    }

    public static void login() {
        // English
        if (currentLanguage.equals("en")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter email:");
            String email = in.nextLine();
            System.out.println("Enter password:");
            String password = in.nextLine();
            for (User user : userList) {
                if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
                    activeUser = user;
                    System.out.println("~ Logged in as: " + activeUser.getUserEmail());
                    if (activeUser.isFirstTimeLogin() == true) {
                        System.out.println(
                                "Since this is your first time logging in, please answer the questions to set up your profile.");
                        loop1: while (true) {
                            System.out.println("\nEnter firstname:");
                            activeUser.setUserFirstName(in.nextLine());

                            System.out.println("\nEnter surname:");
                            activeUser.setUserSurName(in.nextLine());

                            System.out.println("\nEnter date of birth (DD-MM-YYYY):");
                            activeUser.setUserDateOfBirth(in.nextLine());

                            System.out.println("\nEnter your gender (m/f):");
                            activeUser.setUserGender(in.nextLine());

                            System.out.println("\nEnter your height in meters (e.g. 1,85):");
                            activeUser.setUserHeightInMeter(in.nextFloat());

                            System.out.println("\nEnter your weight in kg (e.g. 67,5):");
                            activeUser.setUserWeightInKg(in.nextFloat());
                            WeightBMIRecord record = new WeightBMIRecord(activeUser.getUserWeightInKg());
                            activeUser.weightBMIRecordList.add(record);

                            System.out.println("\nEnter your BPM in rest:");
                            String choice = in.nextLine();
                            choice = in.nextLine();
                            activeUser.setUserBPMRest(Integer.parseInt(choice));
                            activeUser.setUserBPMMax();
                            activeUser.setUserVO2MaxAuto();
                            System.out.println(
                                    "~ Your VO2 Max value has been set to " + activeUser.getUserVO2Max()
                                            + ". You can change this later.");

                            System.out.println("\nWhat device are you using?\n" + "1. Mobile\n" + "2. PC");

                            loop2: while (true) {
                                String input = in.nextLine();
                                switch (input) {
                                    case "1":
                                        activeUser.setUserDevice(1);
                                        break loop2;
                                    case "2":
                                        activeUser.setUserDevice(2);
                                        break loop2;
                                    default:
                                        System.out.println("Error: Please enter a valid command!");
                                        input = in.nextLine();
                                        break;
                                }
                            }
                            showUserData();
                            System.out
                                    .println("**********\n" + "Is everything above correct?\n" + "1. Yes\n" + "2. No");
                            loop3: while (true) {
                                String input = in.nextLine();
                                switch (input) {
                                    case "1":
                                        activeUser.setFirstTimeLogin(false);
                                        System.out.println("~ Profile setup completed.");
                                        mainMenu();
                                        break loop1;
                                    case "2":
                                        System.out.println("Please answer the questions carefully...");
                                        break loop3;
                                    default:
                                        System.out.println("Please use a valid command!");
                                        break;
                                }
                            }
                        }
                        break;
                    } else {
                        mainMenu();
                        break;
                    }
                }
            }
            System.out.println("Account credentials not valid or account does not exist.");
            loginMenu();
            in.close();
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Voer email in:");
            String email = in.nextLine();
            System.out.println("Voer paswoord in:");
            String password = in.nextLine();
            for (User user : userList) {
                if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
                    activeUser = user;
                    System.out.println("~ Ingelogd als: " + activeUser.getUserEmail());
                    if (activeUser.isFirstTimeLogin() == true) {
                        System.out.println(
                                "Omdat dit de eerste keer is dat je inlogd, vragen wij je een paar vragen te beantwoorden om je profiel op te zetten.");
                        loop1: while (true) {
                            System.out.println("\nVoer voornaam in:");
                            activeUser.setUserFirstName(in.nextLine());

                            System.out.println("\nVoer achternaam in:");
                            activeUser.setUserSurName(in.nextLine());

                            System.out.println("\nVoer geboortedatum in (DD-MM-JJJJ):");
                            activeUser.setUserDateOfBirth(in.nextLine());

                            System.out.println("\nKies geslacht (m/f):");
                            activeUser.setUserGender(in.nextLine());

                            System.out.println("\nVoer je lengte in meters in: (b.v. 1,85):");
                            activeUser.setUserHeightInMeter(in.nextFloat());

                            System.out.println("\nVoer je gewicht in kg in (b.v. 67,5):");
                            activeUser.setUserWeightInKg(in.nextFloat());
                            WeightBMIRecord record = new WeightBMIRecord(activeUser.getUserWeightInKg());
                            activeUser.weightBMIRecordList.add(record);

                            System.out.println("\nVoer je hartslag per minuut in rust in:");
                            String choice = in.nextLine();
                            choice = in.nextLine();
                            activeUser.setUserBPMRest(Integer.parseInt(choice));
                            activeUser.setUserBPMMax();
                            activeUser.setUserVO2MaxAuto();
                            System.out.println(
                                    "~ Je VO2 Max waarde is ingesteld op " + activeUser.getUserVO2Max()
                                            + ". Je kan dit later aanpassen.");

                            System.out.println("\nWelk apparaat gebruik je?\n" + "1. Mobiel\n" + "2. PC");

                            loop2: while (true) {
                                String input = in.nextLine();
                                switch (input) {
                                    case "1":
                                        activeUser.setUserDevice(1);
                                        break loop2;
                                    case "2":
                                        activeUser.setUserDevice(2);
                                        break loop2;
                                    default:
                                        System.out.println("Fout: Gebruik een van de nummers uit het menu!");
                                        input = in.nextLine();
                                        break;
                                }
                            }
                            showUserData();
                            System.out
                                    .println("**********\n" + "Is alles correct ingevuld?\n" + "1. Ja\n" + "2. Nee");
                            loop3: while (true) {
                                String input = in.nextLine();
                                switch (input) {
                                    case "1":
                                        activeUser.setFirstTimeLogin(false);
                                        System.out.println("~ Profiel succesvol opgezet.");
                                        mainMenu();
                                        break loop1;
                                    case "2":
                                        System.out.println("Voer de vragen voorzichtig in...");
                                        break loop3;
                                    default:
                                        System.out.println("Gebruik een geldig nummer uit het menu!");
                                        break;
                                }
                            }
                        }
                        break;
                    } else {
                        mainMenu();
                        break;
                    }
                }
            }
            System.out.println("Account gegevens kloppen of bestaan niet.");
            loginMenu();
            in.close();
        }
    }

    // Laat alle userdata zien
    public static void showUserData() {
        // English
        if (currentLanguage.equals("en")) {
            System.out.println("**********");
            System.out.println("Email: " + activeUser.getUserEmail());
            System.out.println("Password: " + activeUser.getUserPassword());
            System.out.println("Name: " + activeUser.getUserFirstName() + " " + activeUser.getUserSurName());
            System.out.println("Date of birth:" + " " + activeUser.getUserDateOfBirth());
            System.out.println("Gender: " + activeUser.getUserGender());
            System.out.printf("Height:" + " " + activeUser.getUserHeightInMeter() + " m" + "\n");
            System.out.printf("Weight: %.2f kg\n", activeUser.getUserWeightInKg());
            System.out.printf("VO2 Max: %.2f\n", activeUser.getUserVO2Max());
            System.out.printf("BMI: %.2f\n", activeUser.getUserCurrentBMI());
            System.out.println("Weight advise: " + activeUser.getUserBMIScore());
            System.out.println("BPM in rest: " + activeUser.getUserBPMRest());
            System.out.println("Max BPM: " + activeUser.getUserBPMMax());
            System.out.println("Userdevice: " + activeUser.getUserDevice());
            System.out.println("Weight progression:\n" + activeUser.weightBMIRecordList.toString());
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            System.out.println("**********");
            System.out.println("Email: " + activeUser.getUserEmail());
            System.out.println("Paswoord: " + activeUser.getUserPassword());
            System.out.println("Naam: " + activeUser.getUserFirstName() + " " + activeUser.getUserSurName());
            System.out.println("Geboortedatum:" + " " + activeUser.getUserDateOfBirth());
            System.out.println("Geslacht: " + activeUser.getUserGender());
            System.out.printf("Lengte:" + " " + activeUser.getUserHeightInMeter() + " m" + "\n");
            System.out.printf("Gewicht: %.2f kg\n", activeUser.getUserWeightInKg());
            System.out.printf("VO2 Max waarde: %.2f\n", activeUser.getUserVO2Max());
            System.out.printf("BMI: %.2f\n", activeUser.getUserCurrentBMI());
            System.out.println("Gewicht advies: " + activeUser.getUserBMIScore());
            System.out.println("Hartslag per minuut in rust: " + activeUser.getUserBPMRest());
            System.out.println("Maximale hartslag per minuut: " + activeUser.getUserBPMMax());
            System.out.println("Apparaat: " + activeUser.getUserDevice());
            System.out.println("Gewichts progressie:\n" + activeUser.weightBMIRecordList.toString());
        }
    }

    // Dit laat de user data veranderen.
    public static void editUserData() {
        // English
        if (currentLanguage.equals("en")) {
            Scanner in = new Scanner(System.in);
            System.out.println("**********");
            System.out.println(
                    "What would you like to edit," + " " + activeUser.getUserFirstName() + "? (Enter a number...)");
            System.out.println("1. Email\n" + "2. Password\n" + "3. Firstname\n" + "4. Surname\n" + "5. Date of birth\n"
                    + "6. Gender\n" + "7. Height\n" + "8. Weight\n" + "9. BPM in rest\n" + "10. VO2 Max\n"
                    + "11. Userdevice\n" + "B. Back");

            loop: while (true) {
                String input = in.nextLine().toUpperCase();
                switch (input) {
                    case "1":
                        System.out.println("Enter new email:");
                        activeUser.setUserEmail(in.nextLine());
                        System.out.println("Email changed succesfully to " + activeUser.getUserEmail() + ".");
                        mainMenu();
                        break loop;
                    case "2":
                        // secondLoop:
                        while (true) {
                            System.out.println("Enter new password:");
                            activeUser.setUserPassword(in.nextLine());
                            System.out.println("Password changed to: [" + activeUser.getUserPassword()
                                    + "]. Is this correct?\n" + "1. Yes\n" + "2. No");
                            thirdLoop: while (true) {
                                String secondInput = in.nextLine();
                                switch (secondInput) {
                                    case "1":
                                        System.err.println("New password saved.");
                                        mainMenu();
                                        break loop;
                                    case "2":
                                        break thirdLoop;
                                    default:
                                        System.out.println("Error: Please use one of the commands!");
                                        break;
                                }
                            }
                        }
                    case "3":
                        System.out.println("Enter new firstname:");
                        activeUser.setUserFirstName(in.nextLine());
                        System.out.println("Firstname changed successfully to " + activeUser.getUserFirstName() + ".");
                        mainMenu();
                        break loop;
                    case "4":
                        System.out.println("Enter new surname (e.g. de_Boer):");
                        activeUser.setUserSurName(in.nextLine());
                        System.out.println("Surname changed succesfully to " + activeUser.getUserSurName() + ".");
                        mainMenu();
                    case "5":
                        System.out.println("Enter new date of birth:");
                        activeUser.setUserDateOfBirth(in.nextLine());
                        System.out
                                .println("Date of birth changed successfully to " + activeUser.getUserDateOfBirth()
                                        + ".");
                        mainMenu();
                    case "6":
                        System.out.println("Enter new gender (M/F):");
                        activeUser.setUserGender(in.nextLine());
                        System.out.println("Gender changed successfully to " + activeUser.getUserGender() + ".");
                        mainMenu();
                    case "7":
                        System.out.println("Enter new height (e.g. 1,90):");
                        activeUser.setUserHeightInMeter(in.nextFloat());
                        System.out
                                .println("Height changed successfully to " + activeUser.getUserHeightInMeter() + " m.");
                        mainMenu();
                    case "8":
                        System.out.println("Enter new weight (e.g. 85,0):");
                        Float weight = in.nextFloat();
                        activeUser.setUserWeightInKg(weight);
                        WeightBMIRecord record = new WeightBMIRecord(weight);
                        activeUser.weightBMIRecordList.add(record);
                        System.out.println("Weight changed successfully to " + activeUser.getUserWeightInKg() + " kg.");
                        mainMenu();
                    case "9":
                        System.out.println("Enter new BPM in rest:");
                        activeUser.setUserBPMRest(in.nextInt());
                        System.out
                                .println("BPM in rest value changed successfully to " + activeUser.getUserBPMRest()
                                        + ".");
                        mainMenu();
                    case "10":
                        System.out.println("Would you like us to calculate your VO2 Max value or set it by yourself?\n"
                                + "1. Set automaticly\n" + "2. Set manually");

                        secondLoop: while (true) {
                            int secondInput = in.nextInt();
                            switch (secondInput) {
                                case 1:
                                    activeUser.setUserVO2MaxAuto();
                                    System.out.println(
                                            "VO2 Max value changed automaticly to " + activeUser.getUserVO2Max() + ".");
                                    break secondLoop;
                                case 2:
                                    Float secondInputFloat = in.nextFloat();
                                    activeUser.setUserVO2MaxManual(secondInputFloat);
                                    break secondLoop;
                                default:
                                    System.out.println("Wrong input! Please choose a number from the menu.");
                                    secondInput = in.nextInt();
                                    break;
                            }
                        }
                    case "11":
                        System.out
                                .println("What device are you using for this app?\n" + "1. Mobile device\n" + "2. PC");
                        secondLoop: while (true) {
                            String secondInput = in.nextLine();
                            switch (secondInput) {
                                case "1":
                                    activeUser.setUserDevice(1);
                                    System.out.println(
                                            "Userdevice has been changed succesfully to "
                                                    + activeUser.getUserDevice() + ".");
                                    mainMenu();
                                    break secondLoop;
                                case "2":
                                    activeUser.setUserDevice(2);
                                    System.out.println(
                                            "Userdevice has been changed succesfully to "
                                                    + activeUser.getUserDevice() + ".");
                                    mainMenu();
                                    break secondLoop;
                                default:
                                    System.out.println("Error: Please enter a valid command!");
                                    input = in.nextLine();
                                    break;
                            }
                        }
                    case "B":
                        mainMenu();
                }
            }
            mainMenu();
            in.close();
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            Scanner in = new Scanner(System.in);
            System.out.println("**********");
            System.out.println(
                    "Wat wil je wijzigen," + " " + activeUser.getUserFirstName() + "? (Kies een nummer...)");
            System.out
                    .println("1. Email\n" + "2. Paswoord\n" + "3. Voornaam\n" + "4. Achternaam\n" + "5. Geboortedatum\n"
                            + "6. Geslacht\n" + "7. Lengte\n" + "8. Gewicht\n" + "9. Hartslag in rust\n"
                            + "10. VO2 Max waarde\n"
                            + "11. Apparaat\n" + "B. Terug");

            loop: while (true) {
                String input = in.nextLine().toUpperCase();
                switch (input) {
                    case "1":
                        System.out.println("Voer nieuwe email in:");
                        activeUser.setUserEmail(in.nextLine());
                        System.out.println("Email veranderd naar " + activeUser.getUserEmail() + ".");
                        mainMenu();
                        break loop;
                    case "2":
                        // secondLoop:
                        while (true) {
                            System.out.println("Voer nieuw paswoord in:");
                            activeUser.setUserPassword(in.nextLine());
                            System.out.println("Paswoord veranderd naar: [" + activeUser.getUserPassword()
                                    + "]. Klopt dit?\n" + "1. Ja\n" + "2. Nee");
                            thirdLoop: while (true) {
                                String secondInput = in.nextLine();
                                switch (secondInput) {
                                    case "1":
                                        System.err.println("Nieuw paswoord opgeslagen.");
                                        mainMenu();
                                        break loop;
                                    case "2":
                                        break thirdLoop;
                                    default:
                                        System.out.println("Fout: Kies een nummer!");
                                        break;
                                }
                            }
                        }
                    case "3":
                        System.out.println("Voer nieuwe voornaam in:");
                        activeUser.setUserFirstName(in.nextLine());
                        System.out.println("Voornaam veranderd naar" + activeUser.getUserFirstName() + ".");
                        mainMenu();
                        break loop;
                    case "4":
                        System.out.println("Voer nieuwe achternaam in (b.v. de_Boer):");
                        activeUser.setUserSurName(in.nextLine());
                        System.out.println("Achternaam veranderd naar" + activeUser.getUserSurName() + ".");
                        mainMenu();
                    case "5":
                        System.out.println("Voer nieuwe geboortedatum in:");
                        activeUser.setUserDateOfBirth(in.nextLine());
                        System.out
                                .println("Geboortedatum succesvol veranderd naar " + activeUser.getUserDateOfBirth()
                                        + ".");
                        mainMenu();
                    case "6":
                        System.out.println("Kies nieuw geslacht (M/F):");
                        activeUser.setUserGender(in.nextLine());
                        System.out.println("Geslacht succesvol veranderd naar " + activeUser.getUserGender() + ".");
                        mainMenu();
                    case "7":
                        System.out.println("Voer nieuwe lengte in (b.v. 1,90):");
                        activeUser.setUserHeightInMeter(in.nextFloat());
                        System.out
                                .println(
                                        "Lengte succesvol veranderd naar " + activeUser.getUserHeightInMeter() + " m.");
                        mainMenu();
                    case "8":
                        System.out.println("Voer nieuw gewicht in (b.v. 85,0):");
                        Float weight = in.nextFloat();
                        activeUser.setUserWeightInKg(weight);
                        WeightBMIRecord record = new WeightBMIRecord(weight);
                        activeUser.weightBMIRecordList.add(record);
                        System.out.println(
                                "Gewicht succesvol veranderd naar: " + activeUser.getUserWeightInKg() + " kg.");
                        mainMenu();
                    case "9":
                        System.out.println("Voer nieuwe hartslag in rust in:");
                        activeUser.setUserBPMRest(in.nextInt());
                        System.out
                                .println("Hartslag in rust veranderd naar  " + activeUser.getUserBPMRest()
                                        + ".");
                        mainMenu();
                    case "10":
                        System.out.println(
                                "Wil je dat wij automatisch je VO2 Max waarde bepalen of wil je die zelf invoeren?\n"
                                        + "1. Zet automatisch\n" + "2. Zet manueel");

                        secondLoop: while (true) {
                            int secondInput = in.nextInt();
                            switch (secondInput) {
                                case 1:
                                    activeUser.setUserVO2MaxAuto();
                                    System.out.println(
                                            "VO2 Max waarde automatisch aangepast naar " + activeUser.getUserVO2Max()
                                                    + ".");
                                    break secondLoop;
                                case 2:
                                    Float secondInputFloat = in.nextFloat();
                                    activeUser.setUserVO2MaxManual(secondInputFloat);
                                    break secondLoop;
                                default:
                                    System.out.println("Verkeerde invoer! Kies alsjeblieft een nummer van het menu.");
                                    secondInput = in.nextInt();
                                    break;
                            }
                        }
                    case "11":
                        System.out
                                .println("Welk apparaat gebruik je voor deze app?\n" + "1. Smartphone\n" + "2. PC");
                        secondLoop: while (true) {
                            String secondInput = in.nextLine();
                            switch (secondInput) {
                                case "1":
                                    activeUser.setUserDevice(1);
                                    System.out.println(
                                            "Apparaat veranderd naar "
                                                    + activeUser.getUserDevice() + ".");
                                    mainMenu();
                                    break secondLoop;
                                case "2":
                                    activeUser.setUserDevice(2);
                                    System.out.println(
                                            "Apparaat veranderd naar "
                                                    + activeUser.getUserDevice() + ".");
                                    mainMenu();
                                    break secondLoop;
                                default:
                                    System.out.println("Fout: Kies een geldig nummer!");
                                    input = in.nextLine();
                                    break;
                            }
                        }
                    case "B":
                        mainMenu();
                }
            }
            mainMenu();
            in.close();
        }
    }

    // Voegt activiteit toe.
    public static void addActivity() {
        // English
        if (currentLanguage.equals("en")) {
            System.out.println("****************************************");
            System.out.println("What type of activity do you want to add?");
            System.out.println("1. Running");
            System.out.println("2. Cycling");
            System.out.println("3. Swimming");
            System.out.println("4. Power training");
            System.out.println("5. Back");
            Scanner in = new Scanner(System.in);

            while (true) {
                String choice = in.nextLine();
                ArrayList<Coach> activityCoachList = new ArrayList<Coach>();
                if (choice.equals("1")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Enter device used:");
                    String device = in.nextLine();
                    System.out.println("Enter duration in minutes (e.g. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Enter brief description of activity:");
                    String description = in.nextLine();
                    System.out.println("Enter distance in KM (e.g. 2.5):");
                    Float distanceInKmRan = in.nextFloat();
                    RunningActivity runningActivity = new RunningActivity(device, durationInMins, description,
                            distanceInKmRan, activityCoachList);
                    activeUser.activityList.add(runningActivity);
                    break;
                } else if (choice.equals("2")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Enter device used:");
                    String device = in.nextLine();
                    System.out.println("Enter duration in minutes (e.g. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Enter brief description of activity:");
                    String description = in.nextLine();
                    System.out.println("Enter distance in KM (e.g. 0,5):");
                    Float distanceInKm = Float.parseFloat(in.nextLine());
                    System.out.println("Enter cycling speed in km/h (e.g. 25):");
                    int kmPerHour = Integer.parseInt(in.nextLine());
                    CyclingActivity cyclingActivity = new CyclingActivity(device, durationInMins, description,
                            distanceInKm, kmPerHour, activityCoachList);
                    activeUser.activityList.add(cyclingActivity);
                    break;
                } else if (choice.equals("3")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Enter device used:");
                    String device = in.nextLine();
                    System.out.println("Enter duration in minutes (e.g. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Enter brief description of activity:");
                    String description = in.nextLine();
                    System.out.println("Enter lap length in meters:");
                    int lapLengthInMeters = in.nextInt();
                    System.out.println("Enter number of laps:");
                    int numberOfLaps = in.nextInt();
                    SwimmingActivity swimmingActivity = new SwimmingActivity(device, durationInMins, description,
                            lapLengthInMeters, numberOfLaps, activityCoachList);
                    activeUser.activityList.add(swimmingActivity);
                    break;
                } else if (choice.equals("4")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Enter device used:");
                    String device = in.nextLine();
                    System.out.println("Enter duration in minutes (e.g. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Enter brief description of activity:");
                    String description = in.nextLine();

                    PowerActivity powerActivity = new PowerActivity(device, durationInMins, description,
                            activityCoachList);
                    System.out.println("~ Now add an exercise.");
                    loop1: while (true) {
                        System.out.println("Enter exercisetype (e.g. Push-up):");
                        String exerciseType = in.nextLine();
                        System.out.println("Enter number of sets:");
                        int numOfSets = Integer.parseInt(in.nextLine());
                        System.out.println("Enter number of exercise repeats:");
                        int numOfReps = Integer.parseInt(in.nextLine());
                        System.out.println("Did you use weights for this exercise? (1. Yes | 2. No)");
                        loop2: while (true) {
                            String choice2 = in.nextLine();
                            if (choice2.equals("1")) {
                                System.out.println("Enter weight in kg:");
                                int weightInKg = Integer.parseInt(in.nextLine());
                                Exercise exercise = new Exercise(exerciseType, numOfSets, numOfReps, weightInKg, true);
                                powerActivity.exercises.add(exercise);
                                break loop2;
                            } else if (choice2.equals("2")) {
                                Exercise exercise = new Exercise(exerciseType, numOfSets, numOfReps, 0, false);
                                powerActivity.exercises.add(exercise);
                                break loop2;
                            } else if (!choice2.equals("1") || !choice2.equals("2")) {
                                System.out.println("~ Invalid input.");
                            }
                        }
                        System.out.println("~ Exercise \"" + description + "\" added to activity.");
                        System.out.println("Would you like to add another exercise? (1. Yes | 2. No)");
                        loop3: while (true) {
                            switch (in.nextLine()) {
                                case "1":
                                    break loop3;
                                case "2":
                                    break loop1;
                                default:
                                    System.out.println("~ Invalid input.");
                            }
                        }
                    }
                    activeUser.activityList.add(powerActivity);
                    break;
                } else if (choice.equals("5")) {
                    App.mainMenu();
                } else {
                    System.out.println("Please use a commandnumber from the menu!");
                }
            }
            System.out.println("~ Activity saved.");
            App.mainMenu();
            in.close();
        }
        // Dutch
        else if (currentLanguage.equals("nl")) {
            System.out.println("****************************************");
            System.out.println("Wat voor activiteit wil je toevoegen?");
            System.out.println("1. Hardlopen");
            System.out.println("2. Fietsen");
            System.out.println("3. Zwemmen");
            System.out.println("4. Kracht training");
            System.out.println("5. Terug");
            Scanner in = new Scanner(System.in);

            while (true) {
                String choice = in.nextLine();
                ArrayList<Coach> activityCoachList = new ArrayList<Coach>();
                if (choice.equals("1")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Voer apparaatsoort in:");
                    String device = in.nextLine();
                    System.out.println("Voer duratie in minuten in (b.v. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Voer korte omschrijving van activiteit in:");
                    String description = in.nextLine();
                    System.out.println("Voer afstand in KM in (b.v. 2.5):");
                    Float distanceInKmRan = in.nextFloat();
                    RunningActivity runningActivity = new RunningActivity(device, durationInMins, description,
                            distanceInKmRan, activityCoachList);
                    activeUser.activityList.add(runningActivity);
                    break;
                } else if (choice.equals("2")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Voer apparaatsoort in:");
                    String device = in.nextLine();
                    System.out.println("Voer duratie in minuten in (b.v. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Voer korte omschrijving van activiteit in:");
                    String description = in.nextLine();
                    System.out.println("Voer afstand in KM in (b.v. 0.5):");
                    Float distanceInKm = Float.parseFloat(in.nextLine());
                    System.out.println("Voer fietssnelheid in km/pu in (b.v. 25):");
                    int kmPerHour = Integer.parseInt(in.nextLine());
                    CyclingActivity cyclingActivity = new CyclingActivity(device, durationInMins, description,
                            distanceInKm, kmPerHour, activityCoachList);
                    activeUser.activityList.add(cyclingActivity);
                    break;
                } else if (choice.equals("3")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Voer apparaatsoort in:");
                    String device = in.nextLine();
                    System.out.println("Voer duratie in minuten in (b.v. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Voer korte omschrijving van activiteit in:");
                    String description = in.nextLine();
                    System.out.println("Voer lengte van een ronde in meters in:");
                    int lapLengthInMeters = in.nextInt();
                    System.out.println("Voer aantal rondes in:");
                    int numberOfLaps = in.nextInt();
                    SwimmingActivity swimmingActivity = new SwimmingActivity(device, durationInMins, description,
                            lapLengthInMeters, numberOfLaps, activityCoachList);
                    activeUser.activityList.add(swimmingActivity);
                    break;
                } else if (choice.equals("4")) {
                    activityCoachList = Activity.addActivityCoach();
                    System.out.println("Voer apparaatsoort in:");
                    String device = in.nextLine();
                    System.out.println("Voer duratie in minuten in (b.v. 180):");
                    int durationInMins = Integer.parseInt(in.nextLine());
                    System.out.println("Voer korte omschrijving van activiteit in:");
                    String description = in.nextLine();

                    PowerActivity powerActivity = new PowerActivity(device, durationInMins, description,
                            activityCoachList);
                    System.out.println("~ Voeg nu een oefening toe.");
                    loop1: while (true) {
                        System.out.println("Voer oefeningsoort in (b.v. Push-up):");
                        String exerciseType = in.nextLine();
                        System.out.println("Voer aantal sets in:");
                        int numOfSets = Integer.parseInt(in.nextLine());
                        System.out.println("Voer aantal reps in:");
                        int numOfReps = Integer.parseInt(in.nextLine());
                        System.out.println("Heb je gewichten gebruikt tijdens deze oefening? (1. Ja | 2. Nee)");
                        loop2: while (true) {
                            String choice2 = in.nextLine();
                            if (choice2.equals("1")) {
                                System.out.println("Voer gewicht in kg in:");
                                int weightInKg = Integer.parseInt(in.nextLine());
                                Exercise exercise = new Exercise(exerciseType, numOfSets, numOfReps, weightInKg, true);
                                powerActivity.exercises.add(exercise);
                                break loop2;
                            } else if (choice2.equals("2")) {
                                Exercise exercise = new Exercise(exerciseType, numOfSets, numOfReps, 0, false);
                                powerActivity.exercises.add(exercise);
                                break loop2;
                            } else if (!choice2.equals("1") || !choice2.equals("2")) {
                                System.out.println("~ Verkeerde invoer.");
                            }
                        }
                        System.out.println("~ Oefening \"" + description + "\" toegevoegd aan activiteit.");
                        System.out.println("Wil je nog een oefening toevoegen? (1. Ja | 2. Nee)");
                        loop3: while (true) {
                            switch (in.nextLine()) {
                                case "1":
                                    break loop3;
                                case "2":
                                    break loop1;
                                default:
                                    System.out.println("~ Verkeerde invoer.");
                            }
                        }
                    }
                    activeUser.activityList.add(powerActivity);
                    break;
                } else if (choice.equals("5")) {
                    App.mainMenu();
                } else {
                    System.out.println("Kies een nummber van het menu!");
                }
            }
            System.out.println("~ Activiteit opgeslagen.");
            App.mainMenu();
            in.close();
        }
    }

    // Shows activityList. Also possible to edit and delete activities.
    public static void showActivities() {
        // English
        if (currentLanguage.equals("en")) {
            int currentActivityIndex = -1;
            Activity currentActivity = null;
            Scanner in = new Scanner(System.in);
            // Prints activitylist if index >= 0
            if (activeUser.activityList.size() == 0) {
                System.out.println("~ Activitylist is empty.");
                App.mainMenu();
            } else {
                while (true) {
                    System.out.println(
                            "******      Activitylist      ******" +
                                    "\n" + "-------------------------------------------");
                    for (int i = 0; i < activeUser.activityList.size(); i++) {
                        System.out.println(i + 1 + ". " + (activeUser.activityList.get(i)).getDetails());
                    }
                    System.out.println("-------------------------------------------\n");
                    System.out.println("~ Enter a number for activity details." +
                            "\n" + "B. Back");
                    try {
                        String choice = in.nextLine();
                        if (choice.equals("B".toLowerCase())) {
                            mainMenu();
                            break;
                            // Else below will show activity details.
                        } else if (Integer.parseInt(choice) > 0) {
                            try {
                                currentActivityIndex = (Integer.parseInt(choice) - 1);
                                System.out.println(activeUser.activityList.size());
                                if (currentActivityIndex > activeUser.activityList.size() - 1) {
                                    System.out.println("~ (! ! !) Activitynumber does not exist (! ! !)");
                                    showActivities();
                                }
                                Activity activity = activeUser.activityList.get(currentActivityIndex);
                                currentActivity = activity;
                            } catch (NumberFormatException ex) {
                                System.out.println("~ Invalid input!");
                                showActivities();
                            }
                            // Options to edit or delete an activity.
                            while (true) {
                                System.out.println(currentActivity.toString());
                                if (currentActivity.getActivityType().equals("Power")) {
                                    ((PowerActivity) currentActivity).getExercises();
                                }
                                System.out.println("What would you like to do?" +
                                        "\n" + "1. Edit activity" +
                                        "\n" + "2. Delete activity" +
                                        "\n" + "B. Back");
                                choice = in.nextLine();
                                if (choice.equals("1")) {
                                    while (true) {
                                        System.out.println("What would you like to edit?" +
                                                "\n" + "1. Date" +
                                                "\n" + "2. Duration" +
                                                "\n" + "3. Device");
                                        if (currentActivity.getActivityType().equals("Running")) {
                                            System.out.println("4. Description" +
                                                    "\n" + "5. Distance");
                                        } else if (currentActivity.getActivityType().equals("Cycling")) {
                                            System.out.println("4. Description" +
                                                    "\n" + "5. Distance" +
                                                    "\n" + "6. Speed");
                                        } else if (currentActivity.getActivityType().equals("Swimming")) {
                                            System.out.println("4. Description" +
                                                    "\n" + "5. Distance" +
                                                    "\n" + "6. Laps" +
                                                    "\n" + "7. Lap length");
                                        } else if (currentActivity.getActivityType().equals("Power")) {
                                            System.out.println("4. Edit exercise");
                                        }
                                        System.out.println("B. Back");
                                        choice = in.nextLine();
                                        if (choice.equals("1")) {
                                            System.out.println("Enter new date (e.g. 01-01-2000):");
                                            choice = in.nextLine();
                                            currentActivity.setDateOfCreation(choice);
                                        } else if (choice.equals("2")) {
                                            System.out.println("Enter new duration of activity in minutes (e.g. 30):");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            currentActivity.setDurationInMins(choiceInt);
                                            System.out.println("~ Edit successfull.");
                                        } else if (choice.equals("3")) {
                                            System.out.println("Enter new device:");
                                            choice = in.nextLine();
                                            currentActivity.setDevice(choice);
                                            System.out.println("~ Edit successfull.");
                                        } else if (choice.equals("4")
                                                && !currentActivity.activityType.equals("Power")) {
                                            System.out.println("Enter new description:");
                                            choice = in.nextLine();
                                            currentActivity.setDescription(choice);
                                            System.out.println("~ Edit successfull.");
                                        } else if (choice.equals("4") && currentActivity.activityType.equals("Power")) {
                                            while (true) {
                                                System.out.println("*** Exercises of this activity: ***");
                                                for (int i = 0; i < ((PowerActivity) currentActivity).exercises
                                                        .size(); i++) {
                                                    System.out
                                                            .println(i + 1 + ". "
                                                                    + ((PowerActivity) currentActivity).exercises
                                                                            .get(i));
                                                }
                                                System.out.println("-------------------------------------------");
                                                System.out.println("Choose an exercise number to edit.");
                                                System.out.println("B. Back");

                                                choice = in.nextLine();
                                                if (choice.equals("B".toLowerCase())) {
                                                    break;
                                                } else if (Integer.parseInt(choice) > 0) {
                                                    int currentExerciseIndex = (Integer.parseInt(choice) - 1);
                                                    Exercise currentExercise = ((PowerActivity) currentActivity).exercises
                                                            .get(currentExerciseIndex);
                                                    while (true) {
                                                        System.out.println(
                                                                "What would you like to edit on this exercise?" +
                                                                        "\n" + "1. Name" +
                                                                        "\n" + "2. Sets" +
                                                                        "\n" + "3. Reps" +
                                                                        "\n" + "4. Weight" +
                                                                        "\n" + "B. Nothing. Go Back");
                                                        choice = in.nextLine();
                                                        if (choice.equals("1")) {
                                                            System.out.println("Enter new name of exercise:");
                                                            choice = in.nextLine();
                                                            currentExercise.setExerciseType(choice);
                                                            System.out.println("~ Edit successfull.");
                                                        } else if (choice.equals("2")) {
                                                            System.out.println("Enter new number of sets:");
                                                            int choiceInt = Integer.parseInt(in.nextLine());
                                                            currentExercise.setNumOfSets(choiceInt);
                                                            System.out.println("~ Edit successfull.");
                                                        } else if (choice.equals("3")) {
                                                            System.out.println("Enter new number of reps:");
                                                            int choiceInt = Integer.parseInt(in.nextLine());
                                                            currentExercise.setNumOfReps(choiceInt);
                                                            System.out.println("~ Edit successfull.");
                                                        } else if (choice.equals("4")) {
                                                            System.out.println("Enter new weight of exercise:");
                                                            int choiceInt = Integer.parseInt(in.nextLine());
                                                            currentExercise.setWeightInKg(choiceInt);
                                                            System.out.println("~ Edit successfull.");
                                                        } else if (choice.equals("B".toLowerCase())) {
                                                            break;
                                                        } else {
                                                            System.out.println("~ Invalid input!");
                                                        }
                                                        if (currentExerciseIndex > ((PowerActivity) currentActivity).exercises
                                                                .size()
                                                                - 1) {
                                                            System.out
                                                                    .println(
                                                                            "~ (! ! !) Exercisenumber does not exist (! ! !)");
                                                        } else if (choice.equals("B".toLowerCase())) {
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("~ Invalid input!");
                                                }
                                            }
                                        } else if (choice.equals("5")
                                                && !currentActivity.activityType.equals("Power")) {
                                            System.out.println("Enter new distance in KM (e.g. 0.5):");
                                            Float choiceFloat = Float.parseFloat(in.nextLine());
                                            if (currentActivity.getActivityType().equals("Running")) {
                                                ((RunningActivity) currentActivity).setDistanceInKm(choiceFloat);
                                            } else if (currentActivity.getActivityType().equals("Cycling")) {
                                                ((CyclingActivity) currentActivity).setDistanceInKm(choiceFloat);
                                            } else if (currentActivity.getActivityType().equals("Swimming")) {
                                                ((SwimmingActivity) currentActivity).setDistanceInKm(choiceFloat);
                                            }
                                        } else if (choice.equals("6")
                                                && currentActivity.activityType.equals("Cycling")) {
                                            System.out.println("Enter new speed in km/h (e.g. 20)");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            ((CyclingActivity) currentActivity).setKmPerHour(choiceInt);
                                        } else if (choice.equals("6")
                                                && currentActivity.activityType.equals("Swimming")) {
                                            System.out.println("Enter new number of laps:");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            ((SwimmingActivity) currentActivity).setNumberOfLaps(choiceInt);
                                        } else if (choice.equals("7")
                                                && currentActivity.activityType.equals("Swimming")) {
                                            System.out.println("Enter new lap distance in meters:");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            ((SwimmingActivity) currentActivity).setLapLengthInMeters(choiceInt);
                                        } else if (choice.equals("B".toLowerCase())) {
                                            break;
                                        }
                                    }
                                } else if (choice.equals("2")) {
                                    while (true) {
                                        System.out.println(
                                                "~ Are you sure you want to delete this activity? (1. Yes | 2. No)");
                                        choice = in.nextLine();
                                        if (choice.equals("1")) {
                                            activeUser.activityList.remove(currentActivityIndex);
                                            System.out.println("Activity deleted.");
                                            showActivities();
                                        } else if (choice.equals("2")) {
                                            showActivities();
                                        } else {
                                            System.out.println("~ Invalid input!");
                                        }
                                    }

                                } else if (choice.equals("B".toLowerCase())) {
                                    break;
                                } else {
                                    System.out.println("~ Invalid input!");
                                }
                            }
                        } else {
                            System.out.println("~ Invalid input!");
                        }
                    } catch (Exception e) {
                        System.out.println("~ Invalid input!");
                        showActivities();
                    }
                }
            }
            in.close();
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            int currentActivityIndex = -1;
            Activity currentActivity = null;
            Scanner in = new Scanner(System.in);
            // Prints activitylist if index >= 0
            if (activeUser.activityList.size() == 0) {
                System.out.println("~ Activiteitenlijst is leeg.");
                App.mainMenu();
            } else {
                while (true) {
                    System.out.println(
                            "******      Activiteitenlijst      ******" +
                                    "\n" + "-------------------------------------------");
                    for (int i = 0; i < activeUser.activityList.size(); i++) {
                        System.out.println(i + 1 + ". " + (activeUser.activityList.get(i)).getDetails());
                    }
                    System.out.println("-------------------------------------------\n");
                    System.out.println("~ Voer een nummer in voor activiteiten details." +
                            "\n" + "B. Terug");
                    try {

                        String choice = in.nextLine();
                        if (choice.equals("B".toLowerCase())) {
                            mainMenu();
                            break;
                            // Else below will show activity details.
                        } else if (Integer.parseInt(choice) > 0) {
                            try {
                                currentActivityIndex = (Integer.parseInt(choice) - 1);
                                System.out.println(activeUser.activityList.size());
                                if (currentActivityIndex > activeUser.activityList.size() - 1) {
                                    System.out.println("~ (! ! !) Activiteitennummer bestaat niet (! ! !)");
                                    showActivities();
                                }
                                Activity activity = activeUser.activityList.get(currentActivityIndex);
                                currentActivity = activity;
                            } catch (NumberFormatException ex) {
                                System.out.println("~ Verkeerde invoer!");
                                showActivities();
                            }
                            // Options to edit or delete an activity.
                            while (true) {
                                System.out.println(currentActivity.toString());
                                if (currentActivity.getActivityType().equals("Power")) {
                                    ((PowerActivity) currentActivity).getExercises();
                                }
                                System.out.println("Wat wil je doen?" +
                                        "\n" + "1. Activiteit aanpassen" +
                                        "\n" + "2. Activiteit verwijderen" +
                                        "\n" + "B. Terug");
                                choice = in.nextLine();
                                if (choice.equals("1")) {
                                    while (true) {
                                        System.out.println("Wat wil je aanpassen?" +
                                                "\n" + "1. Datum" +
                                                "\n" + "2. Duratie" +
                                                "\n" + "3. Apparaat");
                                        if (currentActivity.getActivityType().equals("Running")) {
                                            System.out.println("4. Omschrijving" +
                                                    "\n" + "5. Afstand");
                                        } else if (currentActivity.getActivityType().equals("Cycling")) {
                                            System.out.println("4. Omschrijving" +
                                                    "\n" + "5. Afstand" +
                                                    "\n" + "6. Snelheid");
                                        } else if (currentActivity.getActivityType().equals("Swimming")) {
                                            System.out.println("4. Omschrijving" +
                                                    "\n" + "5. Afstand" +
                                                    "\n" + "6. Rondes" +
                                                    "\n" + "7. Ronde lengte");
                                        } else if (currentActivity.getActivityType().equals("Power")) {
                                            System.out.println("4. Oefening aanpassen");
                                        }
                                        System.out.println("B. Terug");
                                        choice = in.nextLine();
                                        if (choice.equals("1")) {
                                            System.out.println("Voer nieuwe datum in (b.v. 01-01-2000):");
                                            choice = in.nextLine();
                                            currentActivity.setDateOfCreation(choice);
                                        } else if (choice.equals("2")) {
                                            System.out.println(
                                                    "Voer nieuwe duratie van activiteit in minuten in (b.v. 30):");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            currentActivity.setDurationInMins(choiceInt);
                                            System.out.println("~ Aanpassing opgeslagen.");
                                        } else if (choice.equals("3")) {
                                            System.out.println("Voer nieuw apparaat in:");
                                            choice = in.nextLine();
                                            currentActivity.setDevice(choice);
                                            System.out.println("~ Aanpassing opgeslagen.");
                                        } else if (choice.equals("4")
                                                && !currentActivity.activityType.equals("Power")) {
                                            System.out.println("Voer nieuwe omschrijving in:");
                                            choice = in.nextLine();
                                            currentActivity.setDescription(choice);
                                            System.out.println("~ Aanpassing opgeslagen.");
                                        } else if (choice.equals("4") && currentActivity.activityType.equals("Power")) {
                                            while (true) {
                                                System.out.println("*** Oefeningen van deze activiteit: ***");
                                                for (int i = 0; i < ((PowerActivity) currentActivity).exercises
                                                        .size(); i++) {
                                                    System.out
                                                            .println(i + 1 + ". "
                                                                    + ((PowerActivity) currentActivity).exercises
                                                                            .get(i));
                                                }
                                                System.out.println("-------------------------------------------");
                                                System.out.println("Kies een oefening nummer om aan te passen.");
                                                System.out.println("B. Terug");

                                                choice = in.nextLine();
                                                if (choice.equals("B".toLowerCase())) {
                                                    break;
                                                } else if (Integer.parseInt(choice) > 0) {
                                                    int currentExerciseIndex = (Integer.parseInt(choice) - 1);
                                                    Exercise currentExercise = ((PowerActivity) currentActivity).exercises
                                                            .get(currentExerciseIndex);
                                                    while (true) {
                                                        System.out.println("Wat wil je aanpassen in deze oefening?" +
                                                                "\n" + "1. Naam" +
                                                                "\n" + "2. Sets" +
                                                                "\n" + "3. Reps" +
                                                                "\n" + "4. Gewicht" +
                                                                "\n" + "B. Niks. Ga terug");
                                                        choice = in.nextLine();
                                                        if (choice.equals("1")) {
                                                            System.out.println("Voer nieuwe naam in van oefening:");
                                                            choice = in.nextLine();
                                                            currentExercise.setExerciseType(choice);
                                                            System.out.println("~ Aanpassing opgeslagen.");
                                                        } else if (choice.equals("2")) {
                                                            System.out.println("Voer nieuw aantal sets in:");
                                                            int choiceInt = Integer.parseInt(in.nextLine());
                                                            currentExercise.setNumOfSets(choiceInt);
                                                            System.out.println("~ Aanpassing opgeslagen.");
                                                        } else if (choice.equals("3")) {
                                                            System.out.println("Voer nieuw aantal reps in:");
                                                            int choiceInt = Integer.parseInt(in.nextLine());
                                                            currentExercise.setNumOfReps(choiceInt);
                                                            System.out.println("~ Aanpassing opgeslagen.");
                                                        } else if (choice.equals("4")) {
                                                            System.out.println("Voer nieuw gewicht van oefening in:");
                                                            int choiceInt = Integer.parseInt(in.nextLine());
                                                            currentExercise.setWeightInKg(choiceInt);
                                                            System.out.println("~ Aanpassing opgeslagen.");
                                                        } else if (choice.equals("B".toLowerCase())) {
                                                            break;
                                                        } else {
                                                            System.out.println("~ Verkeerde invoer!");
                                                        }
                                                        if (currentExerciseIndex > ((PowerActivity) currentActivity).exercises
                                                                .size()
                                                                - 1) {
                                                            System.out
                                                                    .println(
                                                                            "~ (! ! !) Oefening nummer bestaat niet! (! ! !)");
                                                        } else if (choice.equals("B".toLowerCase())) {
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("~ Verkeerde invoer!");
                                                }
                                            }
                                        } else if (choice.equals("5")
                                                && !currentActivity.activityType.equals("Power")) {
                                            System.out.println("Voer nieuwe afstand in KM in (b.v. 0.5):");
                                            Float choiceFloat = Float.parseFloat(in.nextLine());
                                            if (currentActivity.getActivityType().equals("Running")) {
                                                ((RunningActivity) currentActivity).setDistanceInKm(choiceFloat);
                                            } else if (currentActivity.getActivityType().equals("Cycling")) {
                                                ((CyclingActivity) currentActivity).setDistanceInKm(choiceFloat);
                                            } else if (currentActivity.getActivityType().equals("Swimming")) {
                                                ((SwimmingActivity) currentActivity).setDistanceInKm(choiceFloat);
                                            }
                                        } else if (choice.equals("6")
                                                && currentActivity.activityType.equals("Cycling")) {
                                            System.out.println("Voer nieuwe snelheid in km/pu in (b.v. 20):");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            ((CyclingActivity) currentActivity).setKmPerHour(choiceInt);
                                        } else if (choice.equals("6")
                                                && currentActivity.activityType.equals("Swimming")) {
                                            System.out.println("Voer nieuw aantal rondes inEnter new number of laps:");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            ((SwimmingActivity) currentActivity).setNumberOfLaps(choiceInt);
                                        } else if (choice.equals("7")
                                                && currentActivity.activityType.equals("Swimming")) {
                                            System.out.println("Voer nieuwe afstand van een ronde in meters in:");
                                            int choiceInt = Integer.parseInt(in.nextLine());
                                            ((SwimmingActivity) currentActivity).setLapLengthInMeters(choiceInt);
                                        } else if (choice.equals("B".toLowerCase())) {
                                            break;
                                        }
                                    }
                                } else if (choice.equals("2")) {
                                    while (true) {
                                        System.out.println(
                                                "~ Weet je zeker dat je deze activiteit wilt verwijderen? (1. Ja | 2. Nee)");
                                        choice = in.nextLine();
                                        if (choice.equals("1")) {
                                            activeUser.activityList.remove(currentActivityIndex);
                                            System.out.println("Activiteit verwijderd.");
                                            showActivities();
                                        } else if (choice.equals("2")) {
                                            showActivities();
                                        } else {
                                            System.out.println("~ Verkeerde invoer!");
                                        }
                                    }

                                } else if (choice.equals("B".toLowerCase())) {
                                    break;
                                } else {
                                    System.out.println("~ Verkeerde invoer!");
                                }
                            }
                        } else {
                            System.out.println("~ Verkeerde invoer!");
                        }
                    } catch (Exception e) {
                        System.out.println("~ Verkeerde invoer!");
                        showActivities();
                    }
                }
            }
            in.close();
        }
    }

    // Coach menu - Add, edit or delete a coach. Coaches can be added to activities.
    public static void coachMenu() {
        // English
        if (currentLanguage.equals("en")) {
            while (true) {
                System.out.println(
                        "******      Coachlist      ******" +
                                "\n" + "-------------------------------------------");
                if (activeUser.coachList.size() > 0) {
                    for (int i = 0; i < activeUser.coachList.size(); i++) {
                        System.out.println(i + 1 + ". " + (activeUser.coachList.get(i)).toString());
                    }
                } else {
                    System.out.println("No coaches added yet.");
                }

                System.out.println("-------------------------------------------" +
                        "\n" + "1. Add new coach" +
                        "\n" + "2. Delete coach" +
                        "\n" + "B. Back");

                Scanner in = new Scanner(System.in);
                String choice = in.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Enter type of coach (e.g. Personal trainer):");
                    String typeOfCoach = in.nextLine();
                    System.out.println("Enter firstname of coach:");
                    String firstName = in.nextLine();
                    System.out.println("Enter surname of coach:");
                    String surName = in.nextLine();
                    Coach coach = new Coach(firstName, surName, typeOfCoach);
                    activeUser.coachList.add(coach);
                    System.out.println("New coach added succesfully.");
                    coachMenu();
                } else if (choice.equals("2") && !activeUser.coachList.isEmpty()) {
                    System.out.println(
                            "******      Coachlist      ******" +
                                    "\n" + "-------------------------------------------");
                    for (int i = 0; i < activeUser.coachList.size(); i++) {
                        System.out.println(i + 1 + ". " + (activeUser.coachList.get(i)).toString());
                    }
                    System.out.println("-------------------------------------------");
                    while (true) {
                        System.out.println("Choose a number to delete:");
                        int choiceInt = Integer.parseInt(in.nextLine());
                        try {
                            if ((choiceInt > 0) && (choiceInt <= activeUser.coachList.size())) {
                                activeUser.coachList.remove(choiceInt - 1);
                                System.out.println("Coach removed.");
                                coachMenu();
                            }
                        } catch (Exception e) {
                            System.out.println("~ Invalid input or coachnumber does not exists.");
                            coachMenu();
                        }
                    }
                } else if (choice.equals("2")) {
                    System.out.println("~ There are no coaches to delete!");
                    coachMenu();
                } else if (choice.equals("B".toLowerCase())) {
                    mainMenu();
                } else {
                    System.out.println("Invalid input.");
                }
                in.close();
            }
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            while (true) {
                System.out.println(
                        "******      Coachlijst      ******" +
                                "\n" + "-------------------------------------------");
                if (activeUser.coachList.size() > 0) {
                    for (int i = 0; i < activeUser.coachList.size(); i++) {
                        System.out.println(i + 1 + ". " + (activeUser.coachList.get(i)).toString());
                    }
                } else {
                    System.out.println("Nog geen coaches toegevoegd.");
                }

                System.out.println("-------------------------------------------" +
                        "\n" + "1. Voeg coach toe" +
                        "\n" + "2. Verwijder coach" +
                        "\n" + "B. Terug");

                Scanner in = new Scanner(System.in);
                String choice = in.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Voeg soort coach toe (b.v. Personal trainer):");
                    String typeOfCoach = in.nextLine();
                    System.out.println("Voer voornaam van de coach in:");
                    String firstName = in.nextLine();
                    System.out.println("Voer achternaam van de coach in:");
                    String surName = in.nextLine();
                    Coach coach = new Coach(firstName, surName, typeOfCoach);
                    activeUser.coachList.add(coach);
                    System.out.println("Nieuwe coach succesvol toegevoegd.");
                    coachMenu();
                } else if (choice.equals("2") && !activeUser.coachList.isEmpty()) {
                    System.out.println(
                            "******      Coachlijst      ******" +
                                    "\n" + "-------------------------------------------");
                    for (int i = 0; i < activeUser.coachList.size(); i++) {
                        System.out.println(i + 1 + ". " + (activeUser.coachList.get(i)).toString());
                    }
                    System.out.println("-------------------------------------------");
                    while (true) {
                        System.out.println("Kies een nummer om te verwijderen:");
                        int choiceInt = Integer.parseInt(in.nextLine());
                        try {
                            if ((choiceInt > 0) && (choiceInt <= activeUser.coachList.size())) {
                                activeUser.coachList.remove(choiceInt - 1);
                                System.out.println("Coach verwijderd.");
                                coachMenu();
                            }
                        } catch (Exception e) {
                            System.out.println("~ Verkeerde invoer of coach bestaat niet.");
                            coachMenu();
                        }
                    }
                } else if (choice.equals("2")) {
                    System.out.println("~ Er zijn geen coaches om te verwijderen!");
                    coachMenu();
                } else if (choice.equals("B".toLowerCase())) {
                    mainMenu();
                } else {
                    System.out.println("~ Verkeerde invoer!");
                }
                in.close();
            }
        }
    }

    // Mainmenu - Showed when logged in
    public static void mainMenu() {
        // English
        if (currentLanguage.equals("en")) {
            Scanner in = new Scanner(System.in);
            System.out.println("*** Mainmenu ***");
            System.out.println("1. Show your profile data");
            System.out.println("2. Edit profile data");
            System.out.println("3. Add new activity");
            System.out.println("4. Show activities");
            System.out.println("5. Manage coaches");
            System.out.println("Q. Sign out");

            loop: while (true) {
                String choice = in.next().toUpperCase();
                switch (choice) {
                    case "1":
                        showUserData();
                        mainMenu();
                        break loop;
                    case "2":
                        editUserData();
                        break loop;
                    case "3":
                        addActivity();
                        break loop;
                    case "4":
                        showActivities();
                        break loop;
                    case "5":
                        coachMenu();
                        break loop;
                    case "Q":
                        App.activeUser = null;
                        loginMenu();
                        break loop;
                    default:
                        System.out.println("~ Please choose a commandnumber from the menu!");
                        break;
                }
            }
            in.close();
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            Scanner in = new Scanner(System.in);
            System.out.println("*** Hoofdmenu ***");
            System.out.println("1. Laat profiel zien");
            System.out.println("2. Profiel aanpassen");
            System.out.println("3. Activiteit toevoegen");
            System.out.println("4. Activiteiten overzicht");
            System.out.println("5. Beheer coaches");
            System.out.println("Q. Uitloggen");

            loop: while (true) {
                String choice = in.next().toUpperCase();
                switch (choice) {
                    case "1":
                        showUserData();
                        mainMenu();
                        break loop;
                    case "2":
                        editUserData();
                        break loop;
                    case "3":
                        addActivity();
                        break loop;
                    case "4":
                        showActivities();
                        break loop;
                    case "5":
                        coachMenu();
                        break loop;
                    case "Q":
                        App.activeUser = null;
                        loginMenu();
                        break loop;
                    default:
                        System.out.println("~ Fout: Gebruik een nummer uit het menu!");
                        break;
                }
            }
            in.close();
        }
    }

    public static void loginMenu() {
        // English
        if (currentLanguage.equals("en")) {
            System.out.println("Welcome to the FitnessApp.\n" + "******************************");
            System.out.println(
                    "1. Login\n" + "2. Sign up\n" + "3. Language/Taal\n" + "4. Exit App");
            Scanner in = new Scanner(System.in);
            loop: while (true) {
                switch (in.nextLine().toUpperCase()) {
                    case "1":
                        login();
                        break loop;
                    case "2":
                        createNewAccount();
                        break loop;
                    case "3":
                        while (true) {
                            System.out.println("Choose a language / Kies een taal:" +
                                    "\n" + "1. English" +
                                    "\n" + "2. Nederlands");
                            String choice = in.nextLine();
                            if (choice.equals("1")) {
                                currentLanguage = "en";
                                loginMenu();
                                break;
                            } else if (choice.equals("2")) {
                                currentLanguage = "nl";
                                loginMenu();
                                break;
                            } else {
                                System.out.println("~ Invalid input.");
                            }
                        }

                    case "4":
                        System.exit(0);

                    default:
                        System.out.println("~ Error: Please use a command number!");
                        break;
                }
            }
            in.close();
            // Dutch
        } else if (currentLanguage.equals("nl")) {
            System.out.println("Welkom in de FitnessApp.\n" + "******************************");
            System.out.println(
                    "1. Inloggen\n" + "2. Account maken\n" + "3. Taal/Language\n" + "4. Afsluiten");
            Scanner in = new Scanner(System.in);
            loop: while (true) {
                switch (in.nextLine().toUpperCase()) {
                    case "1":
                        login();
                        break loop;
                    case "2":
                        createNewAccount();
                        break loop;
                    case "3":
                        while (true) {
                            System.out.println("Choose a language / Kies een taal:" +
                                    "\n" + "1. English" +
                                    "\n" + "2. Nederlands");
                            String choice = in.nextLine();
                            if (choice.equals("1")) {
                                currentLanguage = "en";
                                loginMenu();
                                break;
                            } else if (choice.equals("2")) {
                                currentLanguage = "nl";
                                loginMenu();
                                break;
                            } else {
                                System.out.println("~ Verkeerde invoer.");
                            }
                        }

                    case "4":
                        System.exit(0);

                    default:
                        System.out.println("~ Fout: Gebruik een van de command nummers!");
                        break;
                }
            }
            in.close();
        }
    }

    public static void clearScreen() {

        for (int i = 0; i < 13; i++)

            System.out.println("\n");

    }

    public static void main(String[] args) throws Exception {
        App.userList.add(new User("1", "1"));
        userList.get(0).setFirstTimeLogin(false);
        clearScreen();
        loginMenu();
    }
}
