package mani.databaseaction;

import mani.Collection.DataList;
import mani.model.Item;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;

public class ItemDatabase {
    public static DataList<Item> readItemDetails(){

        ObjectMapper objectMapper = new ObjectMapper();
        DataList <Item> itemDetails = new DataList<>();
        try(Reader input = new FileReader(System.getProperty("user.dir")+("/itemDatabase.json"))) {
            itemDetails = objectMapper.readValue(input,new TypeReference<DataList<Item>>(){});
        }

        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception occurs");
        }
        return itemDetails;
    }
}
