package mani.supermarket;

import mani.Collection.DataList;
import mani.Controllers.adminController.AdminControls;
import mani.Controllers.userController.UserControls;
import mani.authentication.UserAuthenticationCheck;
import mani.authentication.AdminAuthenticationCheck;
import mani.model.Item;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class SuperMarketInfo {

    static  Scanner input = new Scanner(System.in);


    public static void main(String[] args)
    {
        System.out.println("*******************************************");
        System.out.println("Welcome to SuperMarket grocery shop");
        System.out.println("*******************************************");

        System.out.println();

        System.out.println("===================================");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Add new User details");
        System.out.println("===================================");

        int actionToBeDone = 0;
        do {
                try {
                    System.out.println("Enter which action need to be processed ");
                    actionToBeDone = input.nextInt();
                    dataOperation(actionToBeDone);
                    System.out.println();
                }
                catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Action cannot be processed!! Check it again....!!!");
                }
        }
        while(actionToBeDone <=3);
    }

    private static void dataOperation(int actionToBeDone) {

        switch (actionToBeDone){

            case 1 :

                System.out.println(" Welcome to Admin login page ");
                System.out.println("Enter admin username : ");
                String adName = input.next();
                System.out.println("Enter admin password : ");
                String adPassword = input.next();
                boolean adminCheck = AdminAuthenticationCheck.checkAdminDetails(adName,adPassword);
                if(adminCheck) {
                    adminPerformAction();
                }
                else {
                    System.out.println("Entered admin username & password is incorrect!!!! Try again !!!!!");
                }
                break;

            case 2 :

                System.out.println("Welcome to User Login page ");
                System.out.println("Enter customer username : ");
                String userName = input.next();
                System.out.println("Enter customer password ");
                String userPassword = input.next();
                boolean userCheck = UserAuthenticationCheck.checkUserDetails(userName,userPassword);
                if(userCheck) {
                    userPerformAction();
                }
                else {
                    System.out.println("Entered customer username & password is incorrect !!!! Try again !!!!! ");
                }
                break;

            case 3 :
                String newUser;
                boolean validName = false;
                System.out.println("Enter your username : ");
                do {
                    if(validName) {
                        System.out.println("Given username is already there , give valid username !!! ");
                    }
                    newUser = input.next();
                    validName = ValidityCheck.validUserName(newUser);
                }
                while(validName);
                System.out.println("Enter your password ");
                String password = input.next();

                    UserControls.addUser(newUser, password);
                    break;

            case 4 :
                System.exit(41);

        }

  }

  private static void adminPerformAction() {

      System.out.println("=================================");
      System.out.println("Welcome to Admin page ");
      System.out.println("=================================");

      System.out.println("Admin can perform below list of action");
      System.out.println(" 1. Displaying item price,Quantity and other details");
      System.out.println(" 2. Displaying list of customer usernames in their supermarket");
      System.out.println(" 3. Removing item from list of items ");
      System.out.println(" 4. Changing price of any item");
      System.out.println(" 5. Adding discount to any item");

      int adminAction = 0;
      do {
          try {
              System.out.println("Enter which action need to be processed ");
              adminAction = input.nextInt();
              adminActionToBeProcessed(adminAction);
              System.out.println();
          }
          catch (Exception e){
              e.printStackTrace();
              System.out.println("Action cannot be processed!! Check it again....!!!");
          }
      }
      while(adminAction <=5);

}

    private static void adminActionToBeProcessed(int adminAction) {
        switch (adminAction) {
            case 1 :
                AdminControls.displayItemDetails();
                break;

            case 2 :
                AdminControls.displayUserNames();
                break;

            case 3 :
                AdminControls.removeItemBasedOnQuantity();
                break;

            case 4 :
                System.out.println("Enter item name for which price has to be changed : ");
                String itemName = input.next();
                System.out.println("Enter price amount for " +itemName+ "is : ") ;
                double priceUnit = input.nextDouble();
                AdminControls.changeItemPrice(itemName,priceUnit);
                break;

            case 5 :
                System.out.println("Enter item name for which discount has to be added : ");
                String iName = input.next();
                System.out.println("Enter discount amount for " +iName+ "is : ");
                double discount = input.nextDouble();
                AdminControls.changeDiscountOnItems(iName,discount);
                break;
        }


    }

    private static void userPerformAction() {
      System.out.println("=================================");
      System.out.println("Welcome to Customer page ");
      System.out.println("=================================");

      System.out.println("User can perform below list of action");
      System.out.println(" 1. Displaying items in supermarket");
      System.out.println(" 2. Adding Items to Cart");
      System.out.println(" 3. Generate billing for addcart items");



      int userAction = 0;
      do {
          try {
              System.out.println("Enter which action need to be processed ");
              userAction = input.nextInt();
              userActionToBeProcessed(userAction);
              System.out.println();
          }
          catch (Exception e){
              e.printStackTrace();
              System.out.println("Action cannot be processed!! Check it again....!!!");
          }
      }
      while(userAction <=4);
  }

  static private DataList<Item> addItemList = null;
  private static void userActionToBeProcessed(int userAction) {

      switch (userAction) {
          case 1:
              UserControls.displayItems();
              break;

          case 2:
             addItemList = UserControls.addCartList();
              break;

          case 3:
              if(addItemList!=null) {
                  UserControls.generateBilling(addItemList);
              }
              else {
                  System.out.println("AddCart is empty");
              }
      }
  }

}
