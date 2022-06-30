package mani.authentication;

import mani.core.StaffDBService;
import mani.model.Staff;

import java.util.List;

public class AuthenticationCheck {

    public static boolean checkDetails(String userName, String password){

        boolean check = false;
        List<Staff> input = StaffDBService.readStaffDetails();
        for (Staff staff : input) {
            if(userName.equals(staff.getUserName()) && password.equals(staff.getPassword())){
               check = true;
                break;
            }
        }
        return check;
    }
}
