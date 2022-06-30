package mani.databaseaction;

import mani.Collection.DataList;
import mani.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;


public class UserDataBase {

    public static DataList <User> readUserDetails(){

        ObjectMapper objectMapper = new ObjectMapper();
        DataList <User> userDetails = new DataList<>();
        try(Reader input = new FileReader(System.getProperty("user.dir")+("/userDatabase.json"))) {
            userDetails = objectMapper.readValue(input,new TypeReference<DataList<User>>(){});
        }

        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception occurs");
        }
        return userDetails;
    }

}
