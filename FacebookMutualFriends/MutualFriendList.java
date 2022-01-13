package mani;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class MutualFriendList {
    public static void main(String[] args) throws FileNotFoundException {
//        readUsersFromInput();
        readUsersFromJson();
    }

    private static void readUsersFromJson() throws FileNotFoundException {
       String jsonString = "{\n" +
                           "\t\"facebookUsers\": [{\n" +
                           "\t\t\"userName\": \"a\",\n" +
                           "\t\t\"friends\": [\"b\", \"c\",\"d\"]\n" +
                           "\t}, {\n" +
                           "\t\t\"userName\": \"b\",\n" +
                           "\t\t\"friends\": [\"c\",\"d\"]\n" +
                           "\t}, {\n" +
                           "\t\t\"userName\": \"c\",\n" +
                           "\t\t\"friends\": [\"a\",\"d\"]\n" +
                           "\t}, {\n" +
                           "\t\t\"userName\": \"d\",\n" +
                           "\t\t\"friends\": [\"a\",\"b\"]\n" +
                           "\t}]\n" +
                           "}";
        Gson gson = new Gson();
      //  FaceBookUsers faceBookUsers = gson.fromJson(jsonString, FaceBookUsers.class);
       Reader reader = new FileReader("c:\\users\\mani\\documents\\userdata.json");
       FaceBookUsers faceBookUsers = gson.fromJson(reader,FaceBookUsers.class);
        Map<String,FacebookProfileUser> fbUsers = new HashMap<>();
        System.out.println("Facebook usernames are : ");
        for (FacebookProfileUser facebookUser : faceBookUsers.facebookUsers) {
            fbUsers.put(facebookUser.profileName, facebookUser);
            System.out.println(facebookUser.profileName);
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Enter two users to find Mutual Friends: ");
        System.out.println("User id 1: ");
        String fbUsername1 = s.nextLine();
        System.out.println("User id 2: ");
        String fbUsername2 = s.nextLine();
        FacebookProfileUser fbUser1 = fbUsers.get(fbUsername1);
        FacebookProfileUser fbUser2 = fbUsers.get(fbUsername2);
         System.out.println(fbUser1.friends);
        System.out.println(fbUser2.friends);
        if (fbUser1 == null || fbUser2 == null) {
            System.out.println("Given input is mismatched ");
        }else {
            List<String> friendList1 = fbUser1.friends;
            List<String> friendList2 = fbUser2.friends;
            List<String> mutualFriends = new ArrayList<>();
            for (String friend : friendList1) {
                if (friendList2.contains(friend)) {
                    mutualFriends.add(friend);
                }
            }
            System.out.print("Mutual friends between users " +fbUser1.profileName+ " and " +  fbUser2.profileName + " are : " +mutualFriends);
        }
    }

 /*   private static void readUsersFromInput() {
        int noOfFbUsers;
        Scanner s = new Scanner(System.in);
        System.out.println("No of facebook users are : ");
        try {
            noOfFbUsers = s.nextInt();
            s.nextLine();
            Map<String, FacebookUser> fbUsers = new HashMap<>();
            for (int i = 0; i < noOfFbUsers; i++) {
                System.out.println("User id : ");
                String fbUsername = s.nextLine();
                System.out.println("Profile name : ");
                String Fb_ProfileName = s.nextLine();
                System.out.println("Gender : ");
                String Fb_Gender = s.nextLine();
                // Get user input as yyyy-mm-dd format
                System.out.println("Date of birth is (yyyy-mm-dd) : ");
                String Dob = s.nextLine();
                System.out.println(Dob);
                System.out.println("User age is : ");
                String age = s.nextLine();
                System.out.println(age);
                s.nextLine();
                System.out.println("Finished schooling in : ");
                String SchoolPlace = s.nextLine();
                System.out.println("Finished College in ");
                String CollegePlace = s.nextLine();
                System.out.println("Current living place is : ");
                String CurrPlace = s.nextLine();
                System.out.println("Current Working place is : ");
                String WorkPlace = s.nextLine();
                fbUsers.put(fbUsername, new FacebookUser(fbUsername, Fb_ProfileName, Fb_Gender, Dob, age, SchoolPlace, CollegePlace, CurrPlace, WorkPlace));
            }
            for (FacebookUser fbUser : fbUsers.values()) {
                System.out.println("Enter number for friends for User id " + fbUser.userName);
                int noOfFriends = s.nextInt();
                s.nextLine();
                for (int j = 0; j < noOfFriends; j++) {
                    System.out.println("Enter friend " + (j + 1));
                    String friend = s.nextLine();
                    fbUser.addFriend(friend);
                }
            }
            for (FacebookUser fbUser : fbUsers.values()) {
                System.out.println("Enter number for friends for User id " + fbUser.userName);
            }
            for (FacebookUser user : fbUsers.values()) {
                user.printData();
            }
        } catch (Exception e) {
            System.out.println("Given input is mismatched ");
        }
    } */
}