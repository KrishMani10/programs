package mani.controllers;

import mani.collection.DataList;
import mani.databaseaction.ItemDatabase;
import mani.databaseaction.UserDataBase;
import mani.model.Item;
import mani.model.User;
import mani.utils.Encryption;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class UserControls {

    ItemDatabase itemDatabase = new ItemDatabase();
    UserDataBase userDataBase = new UserDataBase();

    private static final String LINE_SEPARATOR = "--------------------------------------------------------------------------";

    DataList<Item> addCartList = new DataList<>();

    //adding new user to database

    public void addUser(String newUser, String password) {

    Map<String,User> newUserInfo = userDataBase.readUserDetails();

    User user = new User();
    user.setUserName(newUser);
    String encryptedPassword = Encryption.encryptingPassword(password);
    user.setPassword(encryptedPassword);
    newUserInfo.put(newUser,user);


    ObjectMapper objectMapper = new ObjectMapper();
    try {
        objectMapper.writeValue(new File(System.getProperty("user.dir")+("/userDatabase.json")),newUserInfo);
    }
    catch (Exception e){
       e.printStackTrace();
        System.out.println("Exception Occurred");
    }
}

    public void displayItems() {
        DataList<Item> addCartList = itemDatabase.readItemDetails();
        generateData(addCartList);
    }

    public void addCartList(String userName) {

        DataList<Item> items = itemDatabase.readItemDetails();
        boolean reCheck;
        Scanner s = new Scanner(System.in);
        char choice;
        int j =0;
        System.out.println("Enter the Product details to add to Cart : ");
        do {
            System.out.println("Enter Item Name : ");
            String itemName = s.next();
            for (int i = 0; i < items.size(); i++) {
                if (Objects.equals(items.get(i).getItemName(), itemName))
                {
                    addCartList.add(items.get(i));

                    do
                    {
                        System.out.println("Enter quantity of item u want : ");
                        int itemQuantity = s.nextInt();
                        if ((itemQuantity < items.get(i).getItemQuantity()) ||
                                (itemQuantity == items.get(i).getItemQuantity()))
                        {
                                addCartList.get(j).setItemQuantity(itemQuantity);
                                reCheck = false;
                            }
                        else {
                            System.out.println("Given quantity can't be processed!!! give new input quantity");
                            reCheck = true;
                        }
                    }
                    while(reCheck);
                    j++;
                    break;
                }
            }

            System.out.println("Want to add More items? (y or n) : ");
            choice = s.next().charAt(0);
            s.nextLine();
        }
        while (choice == 'y' || choice == 'Y');
        generateData(addCartList);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File(System.getProperty("user.dir")+("/"+userName+".json")),addCartList);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception occurred");
        }

    }

  // to generate billing

    public void generateBilling(String userName) {

        Scanner ip = new Scanner(System.in);
        DataList<String> bill = new DataList<>();
        DataList<Item> itemDBList = itemDatabase.readItemDetails();
        DataList<Item> items ;

        double newQuantity;
        char choice;
        double totalAmount = 0;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Reader reader = new FileReader(System.getProperty("user.dir") + ("/" + userName + ".json"));
            items = objectMapper.readValue(reader, new TypeReference<DataList<Item>>() {});

            if (items != null) {
                System.out.println("Do u want to generate bill for addCart item list (y or n) : ");
                choice = ip.next().charAt(0);

                if (choice == 'y' || choice == 'Y') {

                    for (int i = 0; i < itemDBList.size(); i++) {
                        for (int j = 0; j < items.size(); j++) {
                            if (Objects.equals(itemDBList.get(i).getItemName(), items.get(j).getItemName())) {
                                newQuantity = itemDBList.get(i).getItemQuantity() - items.get(j).getItemQuantity();
                                itemDBList.get(i).setItemQuantity(newQuantity);
                                break;
                            }
                        }
                    }

                    objectMapper.writeValue(new File(System.getProperty("user.dir") + ("/itemDatabase.json")), itemDBList);


                    bill.add(LINE_SEPARATOR);
                    bill.add(format("Customer Name", "", "-", userName, "", ""));
                    bill.add(LINE_SEPARATOR);
                    bill.add(format("ItemNo", "ItemName", "ItemQuantity",
                            "ItemPrice", "Discount", "Price"));
                    bill.add(LINE_SEPARATOR);

                    for (int i = 0; i < items.size(); i++) {

                        double discountPrice = items.get(i).getItemPrice() -
                                ((items.get(i).getItemDiscount() / 100) * items.get(i).getItemPrice());
                        double price = discountPrice * items.get(i).getItemQuantity();
                        bill.add(format(items.get(i).getItemNo(), items.get(i).getItemName(),
                                items.get(i).getItemQuantity(), items.get(i).getItemPrice(),
                                items.get(i).getItemDiscount(), price));
                        totalAmount = totalAmount + price;
                    }

                    bill.add(LINE_SEPARATOR);
                    bill.add(format(" ", " ", "Total price", " -", "", totalAmount));
                    System.out.println(" Bill has been generated ");

                    //objectMapper.writeValue(new File(System.getProperty("user.dir")+("/")+userName+"bill"),bill);

                     FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+("/")+userName+"bill.txt");
                         for(String str : bill){
                         fileWriter.write(str +System.lineSeparator());

                     }
                     fileWriter.close();



                    bill.add(LINE_SEPARATOR);
                    for (int i = 0; i < bill.size(); i++) {
                        System.out.println(bill.get(i));
                    }


                    File myObj = new File(System.getProperty("user.dir") + ("/") + userName + ".json");
                    myObj.delete();
                    System.exit(0);

                }
            else{
                    System.out.println("Do u want to edit addCart item list (y or n) : ");
                    choice = ip.next().charAt(0);
                    if (choice == 'y' || choice == 'Y') {
                        System.out.println("Enter which item you want to remove : ");
                        String itemName = ip.next();
                        for (int i = 0; i < items.size(); i++) {
                            if (Objects.equals(items.get(i).getItemName(), itemName)) {
                                items.remove(i);
                            }
                        }
                    }
                    generateData(items);
                }
            }

        else{
                System.out.println("Bill cannot be processed cause cart is empty");
            }
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        static String format(Object itemNo,String itemName, Object itemQuantity,
                             Object itemPrice,Object itemDiscount, Object price){
            return String.format("%1$-8s%2$-15s%3$-15s%4$-15s%5$-8s%6$-8s", itemNo, itemName,
                    itemQuantity,itemPrice,itemDiscount, price);
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

}
