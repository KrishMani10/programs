package mani.controllers;

import mani.collection.DataList;
import mani.databaseaction.ItemDatabase;
import mani.databaseaction.UserDataBase;
import mani.model.Item;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.Comparator;
import java.util.Objects;

public class AdminControls {

    ItemDatabase itemDatabase = new ItemDatabase();
    UserDataBase userDataBase = new UserDataBase();

    public void displayItemDetails(){
        DataList<Item> itemDataList = itemDatabase.readItemDetails();
        generateData(itemDataList);
    }

    public void displayUserNames() {
        DataList<String> userList = userDataBase.printUsers();
        System.out.println("List of Users in SuperMarket");
        for(int i=0;i<userList.size();i++){
            System.out.println(userList.get(i));
        }

    }

    public void removeItemBasedOnQuantity() {
        DataList<Item> itemDataList = itemDatabase.readItemDetails();
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

    public void changeItemPrice(String itemName,double itemPriceChange)
    {

        DataList<Item> itemDataList = itemDatabase.readItemDetails();
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

    public  void changeDiscountOnItems(String itemName ,double discount) {
        DataList<Item> itemDataList = itemDatabase.readItemDetails();
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

    public void generateData(DataList<Item> items){

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


    public void addNewItemToDb(String iName, double itemQuantity, double itemPrice, double itemDiscount) {
         DataList<Item> items = itemDatabase.readItemDetails();
         items.sort(Comparator.comparing(Item :: getItemNo));
         int length = items.size()-1;
         int itemNo = items.get(length).getItemNo()+1;
         Item item = new Item();
         item.setItemNo(itemNo);
         item.setItemName(iName);
         item.setItemQuantity(itemQuantity);
         item.setItemPrice(itemPrice);
         item.setItemDiscount(itemDiscount);
         items.add(item);


         ObjectMapper objectMapper = new ObjectMapper();
         try{
             objectMapper.writeValue(new File(System.getProperty("user.dir")+("/itemDatabase.json")),items);
         }
         catch (Exception e){
             e.printStackTrace();
         }

         generateData(items);
    }
}
