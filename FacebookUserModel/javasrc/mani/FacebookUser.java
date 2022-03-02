package mani;


import java.util.*;

import static mani.MainTestSpec.*;

class FacebookUser {

    Map<String,FbProfileUser> facebookUser = new HashMap<>();


    public List<String> toFindMutualFriends(String userName1, String userName2)
    {
        System.out.println("Mutual friends between " + userName1 + " & " + userName2 + " : ");
        projectingMatrix();
        int id1 = fbUser.facebookUser.get(userName1).getId();
        int id2 = fbUser.facebookUser.get(userName2).getId();
        List<String> mutualFriends = new ArrayList<>();
        List<Integer> idKnow = new ArrayList<>();
        for (int i = 0; i < facebookUser.size(); i++) {
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

    public List<String> peopleYouMayKnow (String username1)
    {
        System.out.println("List of people " + username1 + " may know : ");
        projectingMatrix();
        int userId = fbUser.facebookUser.get(username1).getId();
        List<String> peopleYouKnow = new ArrayList<>();
        List<Integer> peopleId = new ArrayList<>();
        List<Integer> toFindIdFriendsList = new ArrayList<>();
        for (int k = 0; k < facebookUser.size(); k++) {
            if (adjMatrix[userId][k] == 1) {
                toFindIdFriendsList.add(k);
            }

        }

        // constructing people you may find friend list
        for (int i = 0; i < toFindIdFriendsList.size(); i++) {
            for (int j = i + 1; j < toFindIdFriendsList.size(); j++) {
                for (int k = 0; k < facebookUser.size(); k++) {

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
        for (Map.Entry<String, FbProfileUser> pair : fbUser.facebookUser.entrySet()) {
            int checkID = pair.getValue().getId();
            Iterator<Integer> itr = peopleId.iterator();
            while (itr.hasNext()) {
                int id = itr.next();
                if (checkID == id) {
                    peopleYouKnow.add(pair.getValue().userName);
                }
            }
        }
        return peopleYouKnow;
    }

    public void projectingPath(String source,String destination)
    {
        Graph graph = new Graph(facebookUser.size());
        for(Map.Entry<String,FbProfileUser>pairs : fbUser.facebookUser.entrySet())
        {
            String temp1 = pairs.getValue().userName;
            for(int j=0;j<pairs.getValue().friends.size();j++)
            {
                String temp2 = pairs.getValue().friends.get(j);
                graph.addEdge(temp1,temp2);
            }
        }
        System.out.println("Path connecting between " + source + " and " + destination + " is : ");
        List<String> results = graph.projectPath(source, destination);

        for (int i = 0; i < (results.size() - 1); i++)
        {
            System.out.print(results.get(i) + "--->");
        }
        System.out.print(results.get(results.size() - 1));
        System.out.println();
    }
}

class FbProfileUser 
{
    int id;
    String userName;
    String gender;
    int age;
    String currentLocation;
    String workingPlace;
    String schooling;
    String college;
    List<String> friends = new ArrayList<>();


    FbProfileUser(String userName,int id, String gender,int age, String currentLocation, String workingPlace, String schooling, String college){
        this.userName = userName;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.currentLocation = currentLocation;
        this.workingPlace = workingPlace;
        this.schooling = schooling;
        this.college = college;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;

    }
}