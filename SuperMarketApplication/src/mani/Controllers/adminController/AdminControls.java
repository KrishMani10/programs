package mani.Controllers.adminController;

import mani.Collection.DataList;
import mani.databaseaction.ItemDatabase;
import mani.databaseaction.UserDataBase;
import mani.model.Item;
import mani.model.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.Objects;

public class AdminControls {

    public static void displayItemDetails(){

        DataList<Item> itemDataList = ItemDatabase.readItemDetails();
        generateData(itemDataList);
    }

    public static void displayUserNames() {
        DataList<User> userDataList = UserDataBase.readUserDetails();
        System.out.println("List of Users in SuperMarket");
        for (int i=0;i<userDataList.size();i++) {
            System.out.println(userDataList.get(i).getUserName());
        }
    }

    public static void removeItemBasedOnQuantity() {
        DataList<Item> itemDataList = ItemDatabase.readItemDetails();
        for(int i=0;i<itemDataList.size();i++){
            if(itemDataList.get(i).getItemQuantity()==0){
                itemDataList.remove(i);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(System.getProperty("user.dir") + ("/itemDatabase.json")), itemDataList);
            generateData(itemDataList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeItemPrice(String itemName,double itemPriceChange)
    {

        DataList<Item> itemDataList = ItemDatabase.readItemDetails();
        for(int i=0;i<itemDataList.size();i++){
            if(Objects.equals(itemDataList.get(i).getItemName(), itemName)){
                itemDataList.get(i).setItemPrice(itemPriceChange);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(System.getProperty("user.dir") + ("/itemDatabase.json")), itemDataList);
            generateData(itemDataList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeDiscountOnItems(String itemName ,double discount) {
        DataList<Item> itemDataList = ItemDatabase.readItemDetails();
        for(int i=0;i<itemDataList.size();i++){
            if(Objects.equals(itemDataList.get(i).getItemName(),itemName)){
                itemDataList.get(i).setItemDiscount(discount);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(System.getProperty("user.dir") + ("/itemDatabase.json")), itemDataList);
            generateData(itemDataList);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void generateData(DataList<Item> items){

        System.out.println("========================================================================");
        System.out.printf("%1$-8s%2$-15s%3$-15s%4$-15s%5$-15s\n","ItemNo","ItemName","ItemQuantity","ItemPrice",
                "ItemDiscount");
        System.out.println("========================================================================");
        System.out.println();
        for(int i=0;i< items.size();i++){
            System.out.printf("%1$-8s%2$-15s%3$-15s%4$-15s%5$-15s\n",items.get(i).getItemNo(),items.get(i).getItemName(),
                    items.get(i).getItemQuantity(),items.get(i).getItemPrice(),items.get(i).getItemDiscount());
        }
    }



}
