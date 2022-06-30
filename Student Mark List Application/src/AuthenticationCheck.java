import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;


public class AuthenticationCheck {

   static List<Staff> staffDetails;

    static{
        try {
           Gson gson = new Gson();
           Reader read = new FileReader(System.getProperty("user.dir") + "/staff.json");
             staffDetails = gson.fromJson(read,new TypeToken<List<Staff>>(){}.getType());
        }
        catch (FileNotFoundException e) {
           e.printStackTrace();
        }
     }
     public static boolean checkDetails(String userName,String passWord){
        if(userName.equals(staffDetails.get(0).getUserName()) && passWord.equals(staffDetails.get(0).getPassword())){
            return true;
         }
         else {
             return false;
         }
     }

}

