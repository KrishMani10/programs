package mani.authentication;

import mani.model.User;
import mani.services.CrudServices;
import mani.dbmanagement.UserDBManage;

import java.util.List;

public class UserAuthenticationCheck {

    public static boolean checkUserDetails(String userName,String password) {

        boolean login = false;

        String encryptedPass = CrudServices.encryptingPassword(password);

        List<User> input = UserDBManage.readUserDetails();

        for(User user : input) {
            if (userName.equals(user.getUserName()) && encryptedPass.equals(user.getPassword())){
                login = true;
                break;
            }
        }
        return login;
    }
}
