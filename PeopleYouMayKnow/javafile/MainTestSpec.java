import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class MainTestSpec {
    public static void main(String[] args) {
        try {
            peopleMayKnow();
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Mismatch of inputs");
        }
    }

    public static void peopleMayKnow() throws Exception {

        // initializing adjancency matrix
        int nodeCount;
        int[][] adjMatrix;

        Scanner s = new Scanner(System.in);
        Gson gson = new Gson();
        Reader reader = new FileReader(System.getProperty("user.dir") + "/friendslist.json");
        FbUserPerson faceBookUsers = gson.fromJson(reader, FbUserPerson.class);
        nodeCount = faceBookUsers.facebookUsers.size();
        adjMatrix = new int[nodeCount][nodeCount];

        // setting id for a user
        for (int i = 0; i < nodeCount; i++) {
            faceBookUsers.facebookUsers.get(i).setId(i);
        }


        // setting values in adjancency matrix
        for (int i = 0; i < nodeCount; i++) {
            int row;
            int column = 0;


            FbProfileUser fbUser = faceBookUsers.facebookUsers.get(i);
            row = fbUser.getId();

            Iterator<String> it = fbUser.friends.iterator();
            while (it.hasNext()) {
                String name = it.next();
                for (int j = 0; j < nodeCount; j++) {
                    if (faceBookUsers.facebookUsers.get(j).userName.equals(name)) {
                        column = faceBookUsers.facebookUsers.get(j).getId();
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
        Iterator<FbProfileUser> personIterator = faceBookUsers.facebookUsers.iterator();
        while(personIterator.hasNext())
        {
            FbProfileUser fbUser = personIterator.next();
            if(fbUser.userName.equals(toFindUsername))
            {
                toFindId = fbUser.getId();
            }
        }


        List<Integer> peopleMayKnowList = new ArrayList<Integer>();

        // getting friend list
        List<Integer> toFindIdFriendsList = new ArrayList<Integer>();
        for(int k=0;k<nodeCount;k++)
        {
            if(adjMatrix[toFindId][k]==1)
            {
                toFindIdFriendsList.add(k);
            }
        }

        // constructing people you may know list
        for(int i=0;i<toFindIdFriendsList.size();i++)
        {
            for(int j=i+1;j<toFindIdFriendsList.size();j++)
            {
                for(int k=0;k<nodeCount;k++)
                {
                    if(adjMatrix[toFindIdFriendsList.get(i)][k] == 1 && adjMatrix[toFindIdFriendsList.get(j)][k] == 1) //mutual to two friends
                    {
                        if(adjMatrix[toFindId][k] == 0 && k!=toFindId) // not a friend for toBeFind Id .
                        {
                            peopleMayKnowList.add(k);
                        }
                    }
                }
            }
        }



        System.out.println("People who may know for " +toFindUsername+ " : ");
        Iterator<Integer> it = peopleMayKnowList.iterator();

        while(it.hasNext())
        {
            personIterator = faceBookUsers.facebookUsers.iterator();

            int id = it.next();

            while(personIterator.hasNext())
            {
                FbProfileUser fbUser = personIterator.next();
                if(fbUser.getId()==id)
                {
                    System.out.print(fbUser.userName);
                }
            }
        }

//        List<String> knownPeople = new ArrayList<>();
//        System.out.println("Enter userid : ");
//        int id1 = s.nextInt();
//        FbProfileUser fbUser = faceBookUsers.facebookUsers.get(id1);
//
//        Iterator<String> it = fbUser.friends.iterator();
//        while (it.hasNext()) {
//            String name1 = it.next();
//            for (int j = 0; j < nodeCount; j++) {
//                if (faceBookUsers.facebookUsers.get(j).userName.equals(name1)) {
//                    row1 = faceBookUsers.facebookUsers.get(j).getId();
//                    break;
//                }
//            }
//
//            System.out.println(row1 + " " );
//
////            for (int k = 0; k < nodeCount; k++)
////            {
////                if ((adjMatrix[row1][k] == 1 && (adjMatrix[row2][k]) == 1))
////                {
////                    tempMatrix[0][k]=1;
////                    if((tempMatrix[0][k]==1) &&(adjMatrix[id1][k]==0)) {
////                        knownPeople.add(faceBookUsers.facebookUsers.get(k).userName);
////                    }
////                }
////            }
////
//
//            System.out.println(knownPeople);
//        }

    }
}


