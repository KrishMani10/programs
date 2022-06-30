package mani.testService;

import java.util.*;

import static mani.testService.ServiceMethod.*;

public class FacebookUsers {
    Map<String,ProfileUser> facebookUser = new HashMap<>();

    public List<String> peopleYouMayKnow(String userName1){
        System.out.println("List of people " + userName1 + " may know : ");
        mainSpec();
        int userId = fbUser.facebookUser.get(userName1).getId();
        List<String> peopleYouKnow = new ArrayList<>();
        List<Integer> peopleId = new ArrayList<>();
        List<Integer> toFindIdFriendsList = new ArrayList<>();
        for (int k = 0; k < facebookUser.size(); k++) {
            if (adjMatrix[userId][k] == 1) {
                toFindIdFriendsList.add(k);
            }
        }

        // constructing people you may find friend list
        for (int i = 0; i < toFindIdFriendsList.size(); i++)
        {
            for (int j = i + 1; j < toFindIdFriendsList.size(); j++)
            {
                for (int k = 0; k < facebookUser.size(); k++)
                {
                    if (adjMatrix[toFindIdFriendsList.get(i)][k] == 1 && adjMatrix[toFindIdFriendsList.get(j)][k] == 1) //mutual to two friends
                    {
                        if (adjMatrix[userId][k] == 0 && k != userId) // not a friend for toBeFind id .
                        {
                            peopleId.add(k);
                        }
                    }
                }
            }
        }
        for (Map.Entry<String,ProfileUser> pair : fbUser.facebookUser.entrySet())
        {
            int checkID = pair.getValue().getId();
            Iterator<Integer> itr = peopleId.iterator();
            while (itr.hasNext())
            {
                int id = itr.next();
                if (checkID == id)
                {
                    peopleYouKnow.add(pair.getValue().userName);
                }
            }
        }
        return peopleYouKnow;
    }


    class ProfileUser{
        int id;
        String userName;
        String gender;
        int age;
        String schoolName;
        String collegeName;
        String workPlace;
        String currentLocation;
        List<String> friends = new ArrayList<>();

        ProfileUser(int id,String userName,String gender,int age,String schoolName,String collegeName,String workPlace,String currentLocation){
            this.id = id;
            this.userName = userName;
            this.gender = gender;
            this.age = age;
            this.schoolName = schoolName;
            this.collegeName = collegeName;
            this.workPlace = workPlace;
            this.currentLocation =currentLocation;
        }

        public void setId(int id){
            this.id=id;
        }
        public int getId(){
            return this.id;
        }
    }
}