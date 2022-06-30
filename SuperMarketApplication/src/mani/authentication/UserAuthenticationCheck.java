package mani.authentication;

import mani.databaseaction.UserDataBase;
import mani.Collection.DataList;
import mani.model.User;

public class UserAuthenticationCheck {

    public static boolean checkUserDetails(String userName,String password) {

        boolean check = false;
        DataList<User> userList = UserDataBase.readUserDetails();
        for(int i =0;i<userList.size();i++)
        {
            if(userName.equals(userList.get(i).getUserName())){
                check = true;
                break;
            }
        }
        return true;

    }
}

