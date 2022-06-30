package mani.databaseaction;

import mani.Collection.DataList;
import mani.model.Admin;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;


public class AdminDataBase {

    public static DataList <Admin> readAdminDetails(){
        ObjectMapper objectMapper = new ObjectMapper();
        DataList <Admin> adminDetails = new DataList<>();

        try(Reader input = new FileReader(System.getProperty("user.dir")+("/adminDatabase.json"))) {
           adminDetails = objectMapper.readValue(input,new TypeReference<DataList<Admin>>(){});

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception occurs");
        }
        return adminDetails;
    }

}
