package mani.dbmanagement;

import mani.model.Compartment;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class TrainDBManage {

    static List<Compartment> compartmentListDetails;

    public static List<Compartment> getTrainDetails(){
        ObjectMapper objectMapper = new ObjectMapper();
        try(Reader reader = new FileReader(System.getProperty("user.dir")+("/trainDetails.json"))) {

//            compartmentListDetails=objectMapper.readValue(reader,
//                    TypeFactory.defaultInstance().constructCollectionType(List.class,Compartment.class));

            compartmentListDetails = objectMapper.readValue(reader, new TypeReference<List<Compartment>>(){});
        }
        catch(Exception e){
           e.printStackTrace();
        }
        return compartmentListDetails;
    }

}
