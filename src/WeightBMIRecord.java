import java.time.LocalDate;

public class WeightBMIRecord {
    private Float weight;
    private LocalDate dateOfCreation;
    private Float bmi;

    public WeightBMIRecord(Float weight) {
        this.weight = weight;
        this.dateOfCreation = LocalDate.now();
        this.bmi = (float) (Math.round((weight / (App.activeUser.getUserHeightInMeter() * App.activeUser.getUserHeightInMeter())) * 100) / 100);
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public Float getBmi() {
        return bmi;
    }

    @Override
    public String toString() {
        if (App.currentLanguage.equals("nl")) {
            return dateOfCreation + " |  Gewicht: " + weight + " |  BMI: " + bmi + "\n";
        } else {
            return dateOfCreation + " |  Weight: " + weight + " |  BMI: " + bmi + "\n";
        }
    }

}
