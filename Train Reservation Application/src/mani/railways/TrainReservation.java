package mani.railways;

import mani.authentication.UserAuthenticationCheck;
import mani.services.CrudServices;

import java.util.Scanner;

public class TrainReservation {

    static  Scanner input = new Scanner(System.in);

    public static void operationToBeProcessed(int processToBeDone){

        switch(processToBeDone) {
            case 1 :
                 String newUser ;
                 boolean validName = false;
                 System.out.println("Enter your userName : ");
                 do {
                     if(validName){
                        System.out.println("Given userName is already exist, please enter valid username ");
                    }
                    newUser = input.next();
                    validName = CrudServices.validUserName(newUser);
                }
                while (validName);

                System.out.println("Enter your password : ");
                String password = input.next();
                CrudServices.addUser(newUser,password);
                break;

            case 2 :
                CrudServices.displayTicketsAvailability();
                break;

            case 3 :
                CrudServices.ticketBooking();
                break;

            case 4 :
                System.exit(4);

        }
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("Welcome to Railway Ticket Booking Service ");
        System.out.println("===============================================");

        System.out.println("Login Section");
        int operationToBeDone =0;
        System.out.println("*********************************");
        System.out.println("Enter your userName : ");
        String userName = input.next();
        System.out.println("Enter your password : ");
        String password = input.next();
        boolean check = UserAuthenticationCheck.checkUserDetails(userName, password);
        if (check) {
            System.out.println(" User logged in successfully ");
            System.out.println("*********************************");

            System.out.println();

            System.out.println("Railway action you want to process :   "
                    + "\n" + "1. Add new user "
                    + "\n" + "2. Displaying no of seats available in AC & NON_AC compartment "
                    + "\n" + "3. Booking tickets for travel "
            );

            System.out.println(" ");
            do {
                try {
                    System.out.println("Action to be performed : ");
                    operationToBeDone = input.nextInt();
                    operationToBeProcessed(operationToBeDone);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Action cannot be done , please check your inputs again");
                }
            }
            while (operationToBeDone <= 3);
        }
        else {
            System.out.println("Given userName & password is incorrect!!!. Please try again !!!");
        }
    }
}
