import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class User {
    // Class variables
    ArrayList<Activity> activityList = new ArrayList<Activity>();
    ArrayList<Coach> coachList = new ArrayList<Coach>();
    ArrayList<WeightBMIRecord> weightBMIRecordList = new ArrayList<WeightBMIRecord>();
    private String userEmail;
    private String userPassword;
    private Long userAccountKey;
    private boolean firstTimeLogin;
    private String userFirstName;
    private String userSurName;
    private LocalDate userDateOfBirth = LocalDate.of(1900, 01, 01);
    private String userGender;
    private Float userHeightInMeter;
    private Float userWeightInKg;
    private int userBPMRest;
    private int userBPMMax;
    private Float userVO2Max;
    private Float userCurrentBMI;
    private String userBMIScore;
    private String userDevice;

    // Contstructor
    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAccountKey = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        this.firstTimeLogin = true;
    }
        
    
    // Methods
    public static Integer userDateToAge(LocalDate userDateOfBirth) {
        LocalDate today = LocalDate.now();
        Integer userAgeInYears = Period.between(userDateOfBirth, today).getYears();
        return userAgeInYears;
    }

    // Zet Stringdatum om in Localdate
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

    //Sets and gets
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserSurName(String userSurName) {
        this.userSurName = userSurName;
    }

    public String getUserSurName() {
        return userSurName;
    }

    public void setUserDateOfBirth(String rawDate) {
        this.userDateOfBirth = stringToDate(rawDate);
    }

    public LocalDate getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender.toUpperCase();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserHeightInMeter(Float userHeightInMeter) {
        this.userHeightInMeter = userHeightInMeter;
    }

    public Float getUserHeightInMeter() {
        return userHeightInMeter;
    }

    public void setUserWeightInKg(Float userWeightInKg) {
        this.userWeightInKg = userWeightInKg;
    }

    public Float getUserWeightInKg() {
        return userWeightInKg;
    }

    public void setUserBPMRest(int userBPMRest) {
        this.userBPMRest = userBPMRest;
    }

    public int getUserBPMRest() {
        return userBPMRest;
    }

    public void setUserBPMMax() {
        this.userBPMMax = 220 - userDateToAge(userDateOfBirth);
    }

    public int getUserBPMMax() {
        userBPMMax = 220 - userDateToAge(userDateOfBirth);
        return userBPMMax;
    }

    public void setUserVO2MaxAuto() {
        this.userVO2Max = (float) (15 * userBPMMax / userBPMRest);
    }

    public void setUserVO2MaxManual(Float userVO2Max) {
        this.userVO2Max = userVO2Max;
    }

    public Float getUserVO2Max() {
        return userVO2Max;
    }

    public Float getUserVO2MaxAuto() {
        userVO2Max = (float) (15 * userBPMMax / userBPMRest);
        return userVO2Max;
    }

    public Float getUserCurrentBMI() {
        userCurrentBMI = (userWeightInKg / (userHeightInMeter * userHeightInMeter));
        return userCurrentBMI;
    }

    public String getUserBMIScore() {
        if (App.currentLanguage.equals("nl")) {
            if (userCurrentBMI < 18.5) {
                userBMIScore = "Ondergewicht. Je moet aankomen.";
            } else if (userCurrentBMI >= 18.5 && userCurrentBMI < 25) {
                userBMIScore = "Gezond. Behoud dit gewicht.";
            } else if (userCurrentBMI >= 25 && userCurrentBMI < 30) {
                userBMIScore = "Overgewicht. Je moet afvallen om gezond te blijven. Je kansen op het krijgen van cardiovasculaire ziekten zijn verhoogd.";
            } else if (userCurrentBMI >= 30) {
                userBMIScore = "Obesitas. Je gezondheid is in gevaar. Je moet onmiddellijk afvallen.";
            }
            return userBMIScore;
        } else {
            if (userCurrentBMI < 18.5) {
                userBMIScore = "Underweight, you need to gain weight.";
            } else if (userCurrentBMI >= 18.5 && userCurrentBMI < 25) {
                userBMIScore = "Healthy. Maintain this weight.";
            } else if (userCurrentBMI >= 25 && userCurrentBMI < 30) {
                userBMIScore = "Overweight. You must lose some weight in order to stay healthy. Your chances of risking cardiovascular diseases are increased.";
            } else if (userCurrentBMI >= 30) {
                userBMIScore = "Obese. Your health is at serious risk. You must lose weight immediately.";
            }
            return userBMIScore;
        }
    }

    public void setUserDevice(int userMobileDevice) {
        if (userMobileDevice == 1) {
            this.userDevice = "Mobile device";
        } else if (userMobileDevice == 2) {
            this.userDevice = "PC";
        }
    }

    public String getUserDevice() {
        return userDevice;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Long getUserAccountKey() {
        return userAccountKey;
    }

    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    @Override
    public String toString() {
        System.out.println("Useraccounts:");
        if (isFirstTimeLogin() == true) {
            return ("\nEmail: " + this.getUserEmail() + "\nPassword: " + this.getUserPassword() + "\nAccountkey: "
                    + this.getUserAccountKey()) + "\n";
        } else {
            return ("\nEmail: " + this.getUserEmail() + "\nPassword: " + this.getUserPassword() + "\nAccountkey: "
                    + this.getUserAccountKey() + "\nFirstname: " + this.getUserFirstName()
                    + "\nSurname: " + this.getUserSurName() + "\nDate of birth: " + this.getUserDateOfBirth()
                    + "\nGender: " +
                    this.getUserGender() + "\nHeight: " + this.getUserHeightInMeter() + "\nWeight: "
                    + this.getUserWeightInKg() + "\nBPM Rest: " + this.getUserBPMRest()
                    + "\nBPM Max: " + this.getUserBPMMax() + "\nVO2 Max: " + this.getUserVO2Max() + "\nBMI: " +
                    this.getUserCurrentBMI() + "\nBMI advice: " + this.getUserBMIScore() + "\nUserdevice: "
                    + this.getUserDevice()) + "\n";
        }
    }
}

    

