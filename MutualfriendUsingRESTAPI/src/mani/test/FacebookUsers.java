package mani.test;

import java.io.FileNotFoundException;
import java.util.*;

import static mani.test.MainSpec.*;

public class FacebookUsers {
    Map<String, FbProfileUser> facebookUser = new HashMap<>();

    public List<String> toFindMutualFriends(String userName1, String userName2){
        TestSpec();
        int id1 = fbUser.facebookUser.get(userName1).getId();
        int id2 = fbUser.facebookUser.get(userName2).getId();

        List<String> mutualFriends = new ArrayList<>();
        List<Integer> idKnow = new ArrayList<>();

        for (int i = 0; i < fbUser.facebookUser.size(); i++) {
            if (adjMatrix[id1][i] == 1 && adjMatrix[id2][i] == 1) {
                idKnow.add(i);
            }
        }
        for (Map.Entry<String, FbProfileUser> pairs : fbUser.facebookUser.entrySet()) {
            int checkId = pairs.getValue().getId();
            Iterator<Integer> itr = idKnow.iterator();
            while (itr.hasNext()) {
                int id = itr.next();
                if (checkId == id) {
                    mutualFriends.add(pairs.getValue().userName);

                }
            }
        }
        return mutualFriends;
    }


    class FbProfileUser {
        int id;
        String userName;
        String gender;
        int age;
        String currentLocation;
        String workingPlace;
        String schooling;
        String college;
        List<String> friends = new ArrayList<>();


        FbProfileUser(String userName, int id, String gender, int age, String currentLocation, String workingPlace, String schooling, String college) {
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
}