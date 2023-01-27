public class Coach {
    private String firstName;
    private String surName;
    private String typeOfCoach;
    
    public Coach(String firstName, String surName, String typeOfCoach) {
        this.firstName = firstName;
        this.surName = surName;
        this.typeOfCoach = typeOfCoach;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTypeOfCoach() {
        return typeOfCoach;
    }

    public void setTypeOfCoach(String typeOfCoach) {
        this.typeOfCoach = typeOfCoach;
    }

    @Override
    public String toString() {
        if (App.currentLanguage.equals("nl")) {
            return "Naam: " + firstName + " " + surName + " | " + "Type: " + typeOfCoach;    
        } else {
            return "Name: " + firstName + " " + surName + " | " + "Type: " + typeOfCoach;    
        }
    }
    
    
}
