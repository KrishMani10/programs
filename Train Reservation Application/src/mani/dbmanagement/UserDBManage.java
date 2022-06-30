package mani.dbmanagement;

import mani.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class UserDBManage {

    static List<User> userDetails;

    public static List<User> readUserDetails() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (Reader reader = new FileReader(System.getProperty("user.dir") + ("/userInfo.json"))) {

//            userDetails = objectMapper.readValue(reader,
//                    TypeFactory.defaultInstance().constructCollectionType(List.class,
//                            User.class));

            userDetails = objectMapper.readValue(reader, new TypeReference<List<User>>(){});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }
}
