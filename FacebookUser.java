package facebookuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FacebookUser {

    String userName;
    String profileName;
    Gender gender;
    LocalDate age;
    int dob;
    String currentLocation;
    String workingPlace;
    String schooling;
    String college;
    List<FacebookUser> friends = new ArrayList<>();


    FacebookUser(String userName, String profileName, Gender gender,LocalDate age,int dob, String currentLocation, String workingPlace, String schooling, String college){
        this.userName = userName;
        this.profileName = profileName;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.currentLocation = currentLocation;
        this.workingPlace = workingPlace;
        this.schooling = schooling;
        this.college = college;
    }


    void addFriend( FacebookUser facebookUser ){
        friends.add(facebookUser);
    }

    void printData(){
        String line = System.lineSeparator();
        System.out.println("User_Id : " +userName+ "" +line+ "Profile_Name : " +profileName+  "\t" + "||" + "\t" + "Gender : " +gender+
                "\t" + "||" + "\t" +"Date of birth : " +age+ "\t" + "||" + "\t" + "Age :" +dob+ "" +line+ "Current location : " +currentLocation+ "\t" + "||" +
                "\t" + "Current Working place :" +workingPlace+ "" +line+ "Schooling place : " +schooling+ "\t" + "||" + "\t" + "College : " +college);
        System.out.println();
        System.out.println("List of friends : ");
        for (FacebookUser friend : friends) {
            System.out.println(friend.profileName);
        }
        System.out.println();
    }

    @Override
    public int hashCode(){
        return this.userName.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof FacebookUser) {
            return ((FacebookUser)other).userName.equals(this.userName);
        }
        return false;
    }

}

enum Gender {
    MALE,
    FEMALE,
    UNSPECIFIED
}
