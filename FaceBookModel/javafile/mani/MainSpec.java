package mani;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class MainSpec {
      static Scanner s = new Scanner(System.in);
      static FacebookUser fbUser;
      public static void main(String[] args)
      {
        try {
            readUsersFromJson();
            printFbUserData();
            countMutualFriend();
            peopleMayKnow();
            getProjectingPath();
        }
        catch(Exception e)
        {
            System.out.println("Mismatch of user inputs");
           e.printStackTrace();
        }
    }

    // METHOD TO READ JSON DATA FILE

    public static void readUsersFromJson() throws FileNotFoundException
    {
        Gson gson = new Gson();
        Reader reader = new FileReader(System.getProperty("user.dir") + "/fbdata.json");
        fbUser = gson.fromJson(reader, FacebookUser.class);
    }

    public static void printFbUserData() {
          int noOfUsers = fbUser.facebookUsers.size();
          for(int i=0;i<noOfUsers;i++){
              System.out.println("FbUser details of " +(i+1)+ " user is : ");
             FbProfileUser users = fbUser.facebookUsers.get(i);
              {
                  String userName = users.userName;
                  System.out.println("Username : " +userName);
                  Gender gender = users.gender;
                  System.out.println("Gender : " +gender);
                  int age = users.age;
                  System.out.println("Age :" +age);
                  String currentLocation = users.currentLocation;
                  System.out.println("Current living place : "  +currentLocation);
                  String workingPlace = users.workingPlace;
                  System.out.println("Current working place : " +workingPlace);
                  String schooling = users.schooling;
                  System.out.println("School : " +schooling);
                  String college = users.college;
                  System.out.println("College studied : " +college);
                  List<String> friends = users.friends;
                  System.out.println("friend list : " +friends);
                  System.out.println("===========================================================");

              }
          }

    }

    // METHOD TO PROJECT PATH BETWEEN TWO USERS

    public static void getProjectingPath() {

          //Initializing vertices for graph

          Graph graph = new Graph(fbUser.facebookUsers.size());
        for(int i=0;i<fbUser.facebookUsers.size();i++)
        {
            String temp1 = fbUser.facebookUsers.get(i).userName;
            for(int j=0;j<fbUser.facebookUsers.get(i).friends.size();j++)
            {
                String temp2 = fbUser.facebookUsers.get(i).friends.get(j);
                graph.addEdge(temp1,temp2);
            }
        }

            System.out.println("Enter the source point : ");
            String source = s.next();
            System.out.println("Enter the destination point : ");
            String destination = s.next();
            System.out.println("Path connecting between " + source + " and " + destination + " is : ");
            List<String> results = graph.projectPath(source, destination);

            for (int i = 0; i < (results.size() - 1); i++) {
                System.out.print(results.get(i) + "--->");
            }

            System.out.print(results.get(results.size() - 1));
            System.out.println();
    }

    // METHOD TO FIND MUTUAL FRIENDS
    public static void countMutualFriend()
    {
        int nodeCount;
        int[][] adjMatrix;
        Scanner s = new Scanner(System.in);
        nodeCount = fbUser.facebookUsers.size();
        adjMatrix = new int[nodeCount][nodeCount];

        // to generate id for each user

        for (int i = 0; i < nodeCount; i++)
        {
            fbUser.facebookUsers.get(i).setId(i);
        }

        // to generate adjacency matrix
        for (int i = 0; i < nodeCount; i++)
        {
            int row ;
            int column =0;

            FbProfileUser facebookUser = fbUser.facebookUsers.get(i);
            row = facebookUser.getId();
            System.out.println(" id : " + row + " -----> username :" + facebookUser.userName);

            Iterator<String> it = facebookUser.friends.iterator();
            while (it.hasNext()) {
                String name = it.next();
                for (int j = 0; j < nodeCount; j++)
                {
                    if (fbUser.facebookUsers.get(j).userName.equals(name)) {
                        column = fbUser.facebookUsers.get(j).getId();
                        break;
                    }
                }

                    adjMatrix[row][column] = 1;

            }
        }

        // printing matrix values
        System.out.println("Adjacency matrix for the given list of friends is :");
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }

            System.out.println();
        }

        // to find mutual friends between two users based on matrix values

        System.out.println("Enter the first userId: ");
        int id1 = s.nextInt();
        System.out.println("Enter the second userId: ");
        int id2 = s.nextInt();
        System.out.println("Mutual friends between " + id1 + " & " + id2 + " is: ");
        List<String> mutualFriends = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            if ((adjMatrix[id1][i]) == 1 && (adjMatrix[id2][i]) == 1) {
                mutualFriends.add(fbUser.facebookUsers.get(i).userName);

            }
        }
        System.out.println(mutualFriends);

    }

    // METHOD TO FIND PEOPLE SUGGESTION LIST
    public static void peopleMayKnow()
    {

        // initializing adjacency matrix
        int nodeCount;
        int[][] adjMatrix;

        nodeCount = fbUser.facebookUsers.size();
        adjMatrix = new int[nodeCount][nodeCount];

        // setting id for a user
        for (int i = 0; i < nodeCount; i++) {
            fbUser.facebookUsers.get(i).setId(i);
        }


        // setting values in adjacency matrix
        for (int i = 0; i < nodeCount; i++) {
            int row;
            int column = 0;

            FbProfileUser fbUser2 = fbUser.facebookUsers.get(i);
            row = fbUser2.getId();

            Iterator<String> it = fbUser2.friends.iterator();
            while (it.hasNext()) {
                String name = it.next();
                for (int j = 0; j < nodeCount; j++) {
                    if (fbUser.facebookUsers.get(j).userName.equals(name)) {
                        column = fbUser.facebookUsers.get(j).getId();
                        break;
                    }
                }
                adjMatrix[row][column] = 1;
            }
        }

        // finding people you may know
        System.out.println("Enter a user name : ");
        String toFindUsername = s.next();



        // get his id
        int toFindId = 0 ;
        Iterator<FbProfileUser> personIterator = fbUser.facebookUsers.iterator();
        while(personIterator.hasNext())
        {
            FbProfileUser fbUser2 = personIterator.next();
            if(fbUser2.userName.equals(toFindUsername))
            {
                toFindId = fbUser2.getId();
            }
        }


        List<Integer> peopleMayKnowList = new ArrayList<>();

        // getting friend list
        List<Integer> toFindIdFriendsList = new ArrayList<>();
        for(int k=0;k<nodeCount;k++)
        {
            if(adjMatrix[toFindId][k]==1)
            {
                toFindIdFriendsList.add(k);
            }
        }

        // constructing people you may find friend list
        for(int i=0;i<toFindIdFriendsList.size();i++)
        {
            for(int j=i+1;j<toFindIdFriendsList.size();j++)
            {
                for(int k=0;k<nodeCount;k++)
                {
                    if(adjMatrix[toFindIdFriendsList.get(i)][k] == 1 && adjMatrix[toFindIdFriendsList.get(j)][k] == 1) //mutual to two friends
                    {
                        if(adjMatrix[toFindId][k] == 0 && k!=toFindId) // not a friend for toBeFind id .
                        {
                            peopleMayKnowList.add(k);
                        }
                    }
                }
            }
        }
        // to find people we know

        System.out.println("People who may know for " +toFindUsername+ " : ");
        Iterator<Integer> it = peopleMayKnowList.iterator();

        while(it.hasNext())
        {
            personIterator = fbUser.facebookUsers.iterator();

            int id = it.next();

            while(personIterator.hasNext())
            {
                FbProfileUser fbUser2 = personIterator.next();
                if(fbUser2.getId()==id)
                {
                    System.out.print(fbUser2.userName);
                }
            }
        }

    }
}
