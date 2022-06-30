package mani.databaseaction;

import mani.model.Admin;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class AdminDataBase {

    public Map<String,Admin> readAdminDetails(){
        ObjectMapper objectMapper = new ObjectMapper();
        Map <String,Admin> adminDetails = new HashMap<>();

        try(Reader input = new FileReader(System.getProperty("user.dir")+("/adminDatabase.json"))) {
           adminDetails = objectMapper.readValue(input,new TypeReference<Map<String,Admin>>(){});

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception occurs");
        }
        return adminDetails;
    }

    public boolean checkAdmin(String userName,String password){
        Map<String,Admin> admins = readAdminDetails();
        boolean check = false;

        if(admins.containsKey(userName)) {

            if (Objects.equals(userName, admins.get(userName).getUserName()) &&
                    Objects.equals(password, admins.get(userName).getPassword())) {
                check = true;
            }
        }

        return check;
    }

}
