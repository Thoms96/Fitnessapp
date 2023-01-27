public class Exercise {
    protected String exerciseType;
    protected int numOfSets;
    protected int numOfReps;
    protected int weightInKg;
    protected boolean weightUsed;

    public Exercise(String exerciseType, int numOfSets, int numOfReps, int weightInKg, boolean weightUsed) {
        this.exerciseType = exerciseType;
        this.numOfSets = numOfSets;
        this.numOfReps = numOfReps;
        this.weightInKg = weightInKg;
        this.weightUsed = weightUsed;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getNumOfSets() {
        return numOfSets;
    }

    public void setNumOfSets(int numOfSets) {
        this.numOfSets = numOfSets;
    }

    public int getNumOfReps() {
        return numOfReps;
    }

    public void setNumOfReps(int numOfReps) {
        this.numOfReps = numOfReps;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    public boolean isWeightUsed() {
        return weightUsed;
    }

    public void setWeightUsed(boolean weightUsed) {
        this.weightUsed = weightUsed;
    }

    @Override
    public String toString() {
        return exerciseType.substring(0, 1).toUpperCase() + exerciseType.substring(1)
        + " | " + "Sets/Reps: " + numOfSets + " x " + numOfReps + " (" + weightInKg
        + " kg)";
    }

}
    

