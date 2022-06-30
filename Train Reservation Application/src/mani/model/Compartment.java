package mani.model;

public class Compartment {

    private String compartmentCoachName;
    private CoachType coachType;
    private int noOfPassengers;
    private int noOfSeats;
    private int trainFare;

    public Compartment(){
    }

    public void setTrainFare(int trainFare) {
        this.trainFare = trainFare;
    }

    public int getTrainFare() {
        return trainFare;
    }

    public void setCompartmentCoachName(String compartmentCoachName) {
        this.compartmentCoachName = compartmentCoachName;
    }

    public String getCompartmentCoachName() {
        return compartmentCoachName;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public void setCoachType(CoachType coachType) {
        this.coachType = coachType;
    }

    public enum CoachType {
        AC,
        NONAC;
    }

}
