package mani.core;

import mani.model.Staff;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;


import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class StaffDBService {

    static List<Staff> staffDetails;

    public static List<Staff> readStaffDetails() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Reader input = new FileReader(System.getProperty("user.dir") + ("/staff.json"));
//            staffDetails = objectMapper.readValue(input,
//                    TypeFactory.defaultInstance().constructCollectionType(List.class,
//                            Staff.class));
            staffDetails = objectMapper.readValue(input,new TypeReference<List<Staff>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffDetails;
    }
}



