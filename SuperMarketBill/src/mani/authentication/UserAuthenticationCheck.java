package mani.authentication;

import mani.databaseaction.UserDataBase;
import mani.utils.Encryption;

public class UserAuthenticationCheck {

    UserDataBase userDataBase = new UserDataBase();

    public boolean checkUserDetails(String userName,String password) {

        boolean check = false;
        String encryptPass = Encryption.encryptingPassword(password);
        if(userDataBase.checkUser(userName,encryptPass)){
            check = true;
        }
        return check;


    }
}

