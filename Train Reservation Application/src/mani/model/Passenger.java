package mani.model;

public class Passenger {
    private String name;
    private Gender gender;

   public enum Gender {
       MALE,
       FEMALE,
       UNSPECIFIED
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender){
       this.gender = gender;
    }

    public String getName() {
       return name;
    }

    public Gender getGender() {
        return gender;
    }
}
