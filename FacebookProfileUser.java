import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FaceBookUsers {
    List<FacebookProfileUser> facebookUsers;
}
 class FacebookProfileUser {

    String userName;
    String profileName;
    String gender;
    String  dob;
    String age;
    String schoolPlace;
    String collegePlace;
    String currPlace;
    String workPlace;
    List<String> friends = new ArrayList<>();


    FacebookProfileUser(String userName, String profileName, String gender, String age, String dob, String schooling, String college, String currPlace, String workPlace){
        this.userName = userName;
        this.profileName = profileName;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.schoolPlace = schooling;
        this.collegePlace = college;
        this.currPlace = currPlace;
        this.workPlace = workPlace;

    }

    void addFriend( String userName ){
        friends.add(userName);
    }

    void printData(){
        String line = System.lineSeparator();
        System.out.println("User_Id : " +userName+ "" +line+ "Profile_Name : " +profileName+  "\t" + "||" + "\t" + "Gender : " +gender+
                "\t" + "||" + "\t" +"Date of birth : " +dob+ "\t" + "||" + "\t" + "Age :" +age+ "" +line+ "Current location : " +currPlace+ "\t" + "||" +
                "\t" + "Current Working place :" +workPlace+ "" +line+ "Schooling place : " +schoolPlace+ "\t" + "||" + "\t" + "College : " +collegePlace);
        System.out.println();
        System.out.println("friends : ");
        for (String friend : friends) {
            System.out.println(friend);
        }
        System.out.println();
    }

    @Override
    public int hashCode(){
        return this.userName.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof FacebookProfileUser) {
            return ((FacebookProfileUser)other).userName.equals(this.userName);
        }
        return false;
    }
}

