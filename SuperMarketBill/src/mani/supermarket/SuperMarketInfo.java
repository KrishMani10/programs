package mani.supermarket;

import mani.controllers.AdminControls;
import mani.controllers.UserControls;
import mani.authentication.AdminAuthenticationCheck;
import mani.authentication.UserAuthenticationCheck;

import java.util.Scanner;

public class SuperMarketInfo {

    Scanner input = new Scanner(System.in);
    AdminControls adminControls = new AdminControls();
    AdminAuthenticationCheck adminAuthenticationCheck = new AdminAuthenticationCheck();
    UserAuthenticationCheck userAuthenticationCheck = new UserAuthenticationCheck();
    UserControls userControls = new UserControls();
    ValidityCheck validityCheck  = new ValidityCheck();

    public static void main(String[] args)
    {
       SuperMarketInfo superMarketInfo =  new SuperMarketInfo();
       superMarketInfo.init();
    }

    public void init()
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

    private void dataOperation(int actionToBeDone) {

        switch (actionToBeDone){

            case 1 :

                System.out.println(" Welcome to Admin login page ");
                System.out.println("Enter admin username : ");
                String adName = input.next();
                System.out.println("Enter admin password : ");
                String adPassword = input.next();
                boolean adminCheck = adminAuthenticationCheck.checkAdminDetails(adName,adPassword);
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
                boolean userCheck = userAuthenticationCheck.checkUserDetails(userName,userPassword);
                if(userCheck) {
                    userPerformAction(userName);
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
                    validName = validityCheck.validUserName(newUser);
                }
                while(validName);
                System.out.println("Enter your password ");
                String password = input.next();

                    userControls.addUser(newUser, password);
                    break;

            case 4 :
                System.exit(4);

        }

  }

  private void adminPerformAction() {

      System.out.println("=================================");
      System.out.println("Welcome to Admin page ");
      System.out.println("=================================");

      System.out.println("Admin can perform below list of action ");
      System.out.println(" 1. Displaying item price,Quantity and other details ");
      System.out.println(" 2. Displaying list of customer usernames in their supermarket ");
      System.out.println(" 3. Adding new item to the list ");
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

    private  void adminActionToBeProcessed(int adminAction) {
        switch (adminAction) {
            case 1:
                adminControls.displayItemDetails();
                break;

            case 2:
                adminControls.displayUserNames();
                break;

            case 3:
                System.out.println("Enter new item name : ");
                boolean itemCheck = false;
                String ipName;
                do {
                    if (itemCheck) {
                        System.out.println("Given username is already there , give valid username !!! ");
                    }
                    ipName = input.next();
                    itemCheck = validityCheck.validItemName(ipName);
                }

                while (itemCheck);

                System.out.println("Enter item price : ");
                double itemPrice = input.nextDouble();
                System.out.println("Enter item quantity : ");
                double itemQuantity = input.nextDouble();
                System.out.println("Enter item discount : ");
                double itemDiscount = input.nextDouble();
                adminControls.addNewItemToDb(ipName, itemQuantity, itemPrice, itemDiscount);

            case 4:
                adminControls.removeItemBasedOnQuantity();
                break;

            case 5:
                System.out.println("Enter item name for which price has to be changed : ");
                String itemName = input.next();
                System.out.println("Enter price amount for " + itemName + "is : ");
                double priceUnit = input.nextDouble();
                adminControls.changeItemPrice(itemName, priceUnit);
                break;

            case 6:
                System.out.println("Enter item name for which discount has to be added : ");
                String iName = input.next();
                System.out.println("Enter discount amount for " + iName + "is : ");
                double discount = input.nextDouble();
                adminControls.changeDiscountOnItems(iName, discount);
                break;

            case 7:
                System.exit(7);
        }
    }



    private void userPerformAction(String userName) {
      System.out.println("=================================");
      System.out.println("Welcome to Customer page ");
      System.out.println("=================================");

      System.out.println("User can perform below list of action");
      System.out.println(" 1. Displaying items in supermarket");
      System.out.println(" 2. Adding Items to Cart");
      System.out.println(" 3. Generate billing for addCart items");



      int userAction = 0;
      do {
          try {
              System.out.println("Enter which action need to be processed ");
              userAction = input.nextInt();
              userActionToBeProcessed(userAction,userName);
              System.out.println();
          }
          catch (Exception e){
              e.printStackTrace();
              System.out.println("Action cannot be processed!! Check it again....!!!");
          }
      }
      while(userAction <=4);
  }

  private void userActionToBeProcessed(int userAction,String userName) {

      switch (userAction) {
          case 1:
              userControls.displayItems();
              break;

          case 2:
             userControls.addCartList(userName);
              break;

          case 3:

              userControls.generateBilling(userName);
              break;

          case 4:
              System.exit(4);
      }
    }
}
