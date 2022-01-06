import java.time.LocalDate;
import java.time.Period;
import java.util.Set;
import java.util.*;

class FacebookUserData {
    public static void main(String[] args) {
        int noOfFbUsers;
        Scanner s = new Scanner(System.in);
        System.out.println("No of facebook users are : ");
        try {
            noOfFbUsers = s.nextInt();
            s.nextLine();

            Map<String, FacebookUser> fbUsers = new HashMap<>();
            Map<String, List<String>> fbFriends = new HashMap<>();
            for (int i = 0; i < noOfFbUsers; i++) {
                System.out.println("User id : ");
                String fbUsername = s.nextLine();

                System.out.println("Profile name : ");
                String fbProfileName = s.nextLine();

                System.out.println("Gender : ");
                String fbGender = s.nextLine();

                // Get user input as yyyy-mm-dd format
                System.out.println("Date of birth is (yyyy-mm-dd) : ");
                String dob = s.next();
                LocalDate fbDob = LocalDate.parse(dob);

                System.out.println(fbDob);


                System.out.println("User age is : ");
                LocalDate CurrDate = LocalDate.now();
                Period AgePeriod = Period.between(CurrDate, fbDob);
                int age = Math.abs(AgePeriod.getYears());
                System.out.println(age);
                s.nextLine();


                System.out.println("Finished schooling in : ");
                String schoolPlace = s.nextLine();

                System.out.println("Finished College in ");
                String collegePlace = s.nextLine();

                System.out.println("Current living place is : ");
                String currPlace = s.nextLine();

                System.out.println("Current Working place is : ");
                String workPlace = s.nextLine();

                fbUsers.put(fbProfileName, new FacebookUser(fbUsername, fbProfileName, fbGender, fbDob, age, schoolPlace, collegePlace, currPlace, workPlace));
            }

            for (FacebookUser user : fbUsers.values()) {
                user.printData();
            }

            for (String userName : fbUsers.keySet()) {
                System.out.println("Enter number for friends for User id " + userName);
                int noOfFriends = s.nextInt();
                s.nextLine();
                for (int j = 0; j < noOfFriends; j++) {
                    System.out.println("Enter friend " + (j + 1));
                    String friend = s.nextLine();
                    List<String> friends = fbFriends.get(userName);
                    if (friends == null) {
                        friends = new ArrayList<>();
                    }
                    friends.add(friend);
                    fbFriends.put(userName, friends);
                }
            }

            Set<Map.Entry<String, List<String>>> entries = fbFriends.entrySet();
            for (Map.Entry<String, List<String>> entry : entries) {
                String user = entry.getKey();
                List<String> friends = entry.getValue();
                System.out.println("User id : (" + user + ")+  having friends " + friends);
            }
        }
        catch (Exception e) {
            System.out.println("Given input is mismatched ");
        }
    }
}
