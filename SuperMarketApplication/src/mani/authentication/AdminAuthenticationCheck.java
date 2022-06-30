package mani.authentication;

import mani.Collection.DataList;
import mani.model.Admin;
import mani.databaseaction.AdminDataBase;
import mani.utils.Encryption;


public class AdminAuthenticationCheck {

    public static boolean checkAdminDetails(String userName,String password) {

        boolean check = false;
        String encryptPass = Encryption.encryptingPassword(password);
        DataList<Admin> adminList = AdminDataBase.readAdminDetails();
        for(int i=0;i<adminList.size();i++) {
            if (userName.equals(adminList.get(i).getUserName()) && encryptPass.equals(adminList.get(i).getPassword())) {
                check = true;
                break;
            }
        }
        return check;

    }
}
