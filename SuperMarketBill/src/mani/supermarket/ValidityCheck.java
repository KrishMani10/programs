package mani.supermarket;

import mani.collection.DataList;
import mani.databaseaction.ItemDatabase;
import mani.databaseaction.UserDataBase;
import mani.model.Item;
import mani.model.User;

import java.util.Map;
import java.util.Objects;

public class ValidityCheck {

    UserDataBase userDataBase = new UserDataBase();
    ItemDatabase itemDatabase = new ItemDatabase();

    public boolean validUserName(String newUser) {
        boolean valid = false;

        Map<String,User> userDetails = userDataBase.readUserDetails();
        if(userDetails.containsKey(newUser)){
            valid =true;
        }
        return  valid;
    }

    public boolean validItemName(String ipName) {
        boolean valid = false;
        DataList<Item> items = itemDatabase.readItemDetails();
        for(int i=0;i<items.size();i++){
            if(Objects.equals(ipName,items.get(i).getItemName())){
                valid = true;
                break;
            }
        }
        return valid;
    }
}
