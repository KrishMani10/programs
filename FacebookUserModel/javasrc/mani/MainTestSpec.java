package mani;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class MainTestSpec {

    static FacebookUser fbUser;
    static int [][] adjMatrix;
    public static void main(String[] args)
    {
        try
        {
            readDataFromJson();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter facebook username 1 : " );
            String sourceName1 = s.next();
            System.out.println("Enter facebook username 2: ");
            String sourceName2 = s.next();
            System.out.println(fbUser.toFindMutualFriends(sourceName1,sourceName2));
            System.out.println(fbUser.peopleYouMayKnow(sourceName1));
            fbUser.projectingPath(sourceName1,sourceName2);
        }

        catch(Exception e)
        {
            System.out.println("Mismatched inputs ");
            e.printStackTrace();
        }
    }


    public static void readDataFromJson() throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader(System.getProperty("user.dir") + "/fbdata.json");
        fbUser = gson.fromJson(reader, FacebookUser.class);

    }

    public static void projectingMatrix()
    {
        int nodeCount;
        nodeCount = fbUser.facebookUser.size();
        adjMatrix = new int[nodeCount][nodeCount];

        // to generate id for each user
        int index=0;
        for (Map.Entry<String,FbProfileUser> pair : fbUser.facebookUser.entrySet()) {
            pair.getValue().setId(index);
            index = index +1;
        }

        //to check id and username
//        for(Map.Entry<String,FbProfileUser> pair : fbUser.facebookUser.entrySet()) {
//            System.out.println(pair.getKey()+ " " +pair.getValue().id);
//        }

        // to generate adjacency matrix
        for(Map.Entry<String,FbProfileUser> pair :fbUser.facebookUser.entrySet()){
            FbProfileUser fbUserPair = pair.getValue();
            int row;
            int column;
            row = fbUserPair.id;
            for (String name : fbUserPair.friends) {
                column = fbUser.facebookUser.get(name).getId();
                adjMatrix[row][column] = 1;
            }
        }
    }

}