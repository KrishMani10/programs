package mani.databaseaction;

import mani.collection.DataList;

import mani.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;


public class UserDataBase {

    public  Map<String,User>readUserDetails(){

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,User> userDetails = new HashMap<>();
        try(Reader input = new FileReader(System.getProperty("user.dir")+("/userDatabase.json"))) {
            userDetails = objectMapper.readValue(input,new TypeReference<Map<String,User>>(){});
        }

        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception occurs");
        }
        return userDetails;
    }
    public boolean checkUser(String userName,String password){
        Map<String,User> users = readUserDetails();
        boolean check = false;

        if(users.containsKey(userName) ){
            if(Objects.equals(users.get(userName).getUserName(),userName) &&
                    (Objects.equals(users.get(userName).getPassword(),password))){
                check = true;
            }
        }
        return check;
    }

    public DataList<String> printUsers(){
        Map<String,User> users = readUserDetails();
        DataList<String> userList = new DataList<>();
        for(Map.Entry<String,User> entry : users.entrySet()){
            userList.add(entry.getKey());
        }
        return userList;
    }
}
