import com.google.gson.Gson;
import java.util.*;

public class MutualFriendList {
    public static void main(String[] args) {
//        readUsersFromInput();
        readUsersFromJson();
    }

    private static void readUsersFromJson() {
        String jsonString = """
                {
                \t"facebookUsers": [{
                \t\t"userName": "a",
                \t\t"friends": ["b", "c","d"]
                \t}, {
                \t\t"userName": "b",
                \t\t"friends": ["c","d"]
                \t}, {
                \t\t"userName": "c",
                \t\t"friends": ["a","d"]
                \t}, {
                \t\t"userName": "d",
                \t\t"friends": ["a","b"]
                \t}]
                }""";
        Gson gson = new Gson();
        FaceBookUsers faceBookUsers = gson.fromJson(jsonString, FaceBookUsers.class);
        Map<String,FacebookProfileUser> fbUsers = new HashMap<>();
        System.out.println("Facebook usernames are : ");
        for (FacebookProfileUser facebookUser : faceBookUsers.facebookUsers) {
            fbUsers.put(facebookUser.userName, facebookUser);
            System.out.println(facebookUser.userName);
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Enter two users to find Mutual Friends: ");
        System.out.println("User id 1: ");
        String fbUsername1 = s.nextLine();
        System.out.println("User id 2: ");
        String fbUsername2 = s.nextLine();
        FacebookProfileUser fbUser1 = fbUsers.get(fbUsername1);
        FacebookProfileUser fbUser2 = fbUsers.get(fbUsername2);
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
            System.out.print("Mutual friends between users"+"\t" +fbUser1.userName+ "\t"+"and" + "\t" +fbUser2.userName + "\t"+ "are : ");
            System.out.println(mutualFriends);
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
