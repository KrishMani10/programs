package mani.supermarket;

import mani.Collection.DataList;
import mani.databaseaction.UserDataBase;
import mani.model.User;

public class ValidityCheck {
    public static boolean validUserName(String newUser) {
        boolean valid = false;

        DataList<User> userDetails = UserDataBase.readUserDetails();
        for(int i= 0;i<userDetails.size();i++) {
            if(newUser.equals(userDetails.get(i).getUserName())){
                valid = true;
                break;
            }
        }
        return  valid;
    }
}
