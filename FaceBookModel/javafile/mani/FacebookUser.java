package mani;


import java.util.ArrayList;
import java.util.List;

class FacebookUser{
    List<FbProfileUser> facebookUsers;
}
class FbProfileUser {
    int id;
    String userName;
    Gender gender;
    int age;
    String currentLocation;
    String workingPlace;
    String schooling;
    String college;
    List<String> friends = new ArrayList<>();


    FbProfileUser(String userName,int id, Gender gender,int age, String currentLocation, String workingPlace, String schooling, String college){
        this.userName = userName;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.currentLocation = currentLocation;
        this.workingPlace = workingPlace;
        this.schooling = schooling;
        this.college = college;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

enum Gender {
    male,
    female,
    unspecified
}