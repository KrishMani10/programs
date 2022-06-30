package mani.authentication;


import mani.databaseaction.AdminDataBase;
import mani.utils.Encryption;


public class AdminAuthenticationCheck {

    AdminDataBase adminDataBase = new AdminDataBase();

    public  boolean checkAdminDetails(String userName,String password) {

        boolean check = false;
        String encryptPass = Encryption.encryptingPassword(password);
        if(adminDataBase.checkAdmin(userName,encryptPass)){
            check = true;
        }
        return check;

    }
}
