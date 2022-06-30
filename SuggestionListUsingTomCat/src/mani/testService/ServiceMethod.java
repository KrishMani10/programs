package mani.testService;

import com.google.gson.Gson;
import mani.testService.FacebookUsers.ProfileUser;

import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class ServiceMethod {
    static int[][] adjMatrix;
    static FacebookUsers fbUser;

    public static void readFromJson() {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(System.getProperty("user.dir") + "/fbdata.json");
            fbUser = gson.fromJson(reader, FacebookUsers.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void mainSpec(){
        readFromJson();
        int nodeCount;
        nodeCount = fbUser.facebookUser.size();
        adjMatrix = new int[nodeCount][nodeCount];

        //to generate id for each user
        int index =0;
        for(Map.Entry<String,ProfileUser>pair : fbUser.facebookUser.entrySet()) {
            pair.getValue().setId(index);
            index = index+1;
        }

        //to generate matrix for user
        for(Map.Entry<String,ProfileUser>pair : fbUser.facebookUser.entrySet()){
            ProfileUser profileUserPair = pair.getValue();
            int row;
            int column;
            row = profileUserPair.id;
            for(String name:profileUserPair.friends){
                column = fbUser.facebookUser.get(name).getId();
                adjMatrix[row][column] =1;
            }
        }
    }
}
