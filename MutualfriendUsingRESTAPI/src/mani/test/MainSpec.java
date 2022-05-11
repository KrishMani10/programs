package mani.test;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import java.util.Scanner;

import mani.test.FacebookUsers.FbProfileUser;

public class MainSpec {

    static FacebookUsers fbUser;
    static int[][] adjMatrix;

    public static void main(String[] args) {
        try{
            readDataFromJson();
            Scanner s = new Scanner(System.in);
            String username1 = s.next();
            String username2 = s.next();

            System.out.println(fbUser.toFindMutualFriends(username1,username2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void readDataFromJson() throws  FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader(System.getProperty("user.dir") + "/fbdata.json");
        fbUser = gson.fromJson(reader, FacebookUsers.class);
    }

    public static void TestSpec()  {
        try {
            readDataFromJson();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int nodeCount;
        nodeCount = fbUser.facebookUser.size();
        adjMatrix = new int[nodeCount][nodeCount];

        //to generate id for each user
        int index = 0;
        for (Map.Entry<String, FbProfileUser> pair : fbUser.facebookUser.entrySet()) {
            pair.getValue().setId(index);
            index = index + 1;
        }

        // to generate adjacent matrix value
        for (Map.Entry<String, FbProfileUser> pair : fbUser.facebookUser.entrySet()) {
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