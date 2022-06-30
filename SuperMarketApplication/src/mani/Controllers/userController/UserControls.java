package mani.Controllers.userController;

import mani.Collection.DataList;
import mani.databaseaction.ItemDatabase;
import mani.databaseaction.UserDataBase;
import mani.model.Item;
import mani.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import mani.utils.Encryption;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserControls {

    private static final String LINE_SEPARATOR = "--------------------------------------------------------------------------";

    static DataList<Item> addCartList = new DataList<>();

    //adding new user to database

    public static void addUser(String newUser, String password) {

    DataList<User> newUserInfo = UserDataBase.readUserDetails();

    User user = new User();
    user.setUserName(newUser);
    String encryptedPassword = Encryption.encryptingPassword(password);
    user.setPassword(encryptedPassword);
    newUserInfo.add(user);


    ObjectMapper objectMapper = new ObjectMapper();
    try {
        objectMapper.writeValue(new File(System.getProperty("user.dir")+("/userDatabase.json")),newUserInfo);
    }
    catch (Exception e){
       e.printStackTrace();
        System.out.println("Exception Occurred");
    }
}

    public static void displayItems() {
        DataList<Item> addCartList = ItemDatabase.readItemDetails();
        generateData(addCartList);
    }

    public static DataList<Item> addCartList() {

        DataList<Item> items = ItemDatabase.readItemDetails();

        Scanner s = new Scanner(System.in);
        char choice;
        double totalAmount = 0;
        do {
            System.out.println("Enter the Product details  ");
            System.out.println("Enter Item Name : ");
            String itemName = s.next();

            for (int i = 0; i < items.size(); i++) {
                if (Objects.equals(items.get(i).getItemName(), itemName)) {
                    addCartList.add(items.get(i));
                    break;
                }
            }

            System.out.println("Enter quantity of item u want : ");
            int itemQuantity = s.nextInt();
            for (int i = 0; i < addCartList.size(); i++) {
                addCartList.get(i).setItemQuantity(itemQuantity);
            }
            System.out.println("Want to add More items? (y or n) : ");
            choice = s.next().charAt(0);
            s.nextLine();
        }
        while (choice == 'y' || choice == 'Y');
        generateData(addCartList);
        return addCartList;

    }

        public static void generateBilling(DataList<Item> items){

        Scanner ip = new Scanner(System.in);
            DataList<String> bill = new DataList<>();
            char choice;
            double totalAmount =0;
        System.out.println("Do u want to generate bill for addCart item list (y or n) : ");
        choice = ip.next().charAt(0);
        bill.add(LINE_SEPARATOR);
        bill.add(format("ItemNo","ItemName","ItemQuantity",
                "ItemPrice","ItemDiscount","Price"));
        bill.add(LINE_SEPARATOR);
        if (choice == 'y' || choice == 'Y') {
            for (int i = 0; i < items.size(); i++) {

                double discountPrice = items.get(i).getItemPrice() -
                        ((items.get(i).getItemDiscount() / 100) * items.get(i).getItemPrice());
                double price = discountPrice * items.get(i).getItemQuantity();
                bill.add(format(items.get(i).getItemNo(),items.get(i).getItemName(),
                        items.get(i).getItemQuantity(),items.get(i).getItemPrice(),
                        items.get(i).getItemDiscount(), price));
                totalAmount = totalAmount+price;

            }
            bill.add(LINE_SEPARATOR);
            bill.add(format(" "," " ,"Total price"," -","",totalAmount));
            bill.add(LINE_SEPARATOR);
            for(int i=0 ;i<bill.size();i++){
                System.out.println(bill.get(i));
            }
        }
        else {
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

        static String format(Object itemNo,String itemName, Object itemQuantity,
                             Object itemPrice,Object itemDiscount, Object price){
            return String.format("%1$-8s%2$-15s%3$-15s%4$-15s%5$-8s%6$-8s", itemNo, itemName,
                    itemQuantity,itemPrice,itemDiscount, price);
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
