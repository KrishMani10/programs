package mani.services;

import mani.model.Compartment;
import mani.model.Passenger;
import mani.model.User;
import mani.dbmanagement.TrainDBManage;
import mani.dbmanagement.UserDBManage;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CrudServices {

    static Scanner input = new Scanner(System.in);
    static List<User> userDetails = UserDBManage.readUserDetails();
    static List<Compartment> compartmentDetails = TrainDBManage.getTrainDetails();

    public static String encryptingPassword(String password){

        StringBuilder encryptedVal = new StringBuilder();

        for(char ch : password.toCharArray()){
            if(ch == 'Z'){
                encryptedVal.append('A');
            }
            else if(ch == 'z'){
                encryptedVal.append('a');
            }
            else
            {
            encryptedVal.append((char) (ch + 1));
            }
        }
        return encryptedVal.toString();
    }

    public static boolean validUserName(String newName) {
        boolean valid = false;
        for(User user :userDetails){
            if(newName.equals(user.getUserName())){
                valid = true;
                break;
            }
        }
        return  valid;

    }

    public static void addUser(String userName,String password){
        User users = new User();
        users.setUserName(userName);
        String encryptedPassword = encryptingPassword(password);
        users.setPassword(encryptedPassword);
        userDetails.add(users);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(System.getProperty("user.dir") + ("/userInfo.json")), userDetails);
            System.out.println("Your credentials are added to userDB");
        }
        catch (Exception e) {
            System.out.println("Exception occurred ");
        }
    }

    public static void displayTicketsAvailability(){
        System.out.println("Train tickets available in each compartment ");

        System.out.println("*********************************");
        System.out.println();
        for(Compartment c : compartmentDetails) {
            System.out.println("Compartment Name : " +c.getCompartmentCoachName());
            System.out.println("Compartment type : " +c.getCoachType());
            System.out.println("Tickets availability : " +c.getNoOfSeats());
            System.out.println();
        }
        System.out.println();
        System.out.println("*********************************");

    }

    public static void ticketBooking(){

        System.out.println("Enter no of seats you want to book : ");
        int seatBooking = input.nextInt();
        int totalFare =0;

        for(int i=0;i<seatBooking;i++) {
            int getFare =0;
            System.out.println("Enter passenger Name : ");
            String pName = input.next();
            System.out.println("Enter gender (male/female/unspecified) : ");
            String gen = input.next().toUpperCase();
            Passenger.Gender genderType = Passenger.Gender.valueOf(gen);

                System.out.println("Enter Coach type (AC/NonAC) : ");
                String cType = input.next().toUpperCase();
                Compartment.CoachType coachType = Compartment.CoachType.valueOf(cType);
                System.out.println();

                for (int j = 0; j < compartmentDetails.size(); j++) {
                    int k = compartmentDetails.get(j).getNoOfPassengers();
                    if (coachType == compartmentDetails.get(j).getCoachType()) {

                        if (compartmentDetails.get(j).getNoOfSeats() > 0) {

                              getFare = compartmentDetails.get(j).getTrainFare();
                            compartmentDetails.get(j).setNoOfSeats(compartmentDetails.get(j).getNoOfSeats() - 1);
                            compartmentDetails.get(j).setNoOfPassengers(++k);
                            break;
                        }
                        else {
                            if (j == 1) {
                                System.out.println("No seats available in AC compartment. " +
                                        "Select seats from non AC compartment.");
                                i--;
                            }
                        }
                    }
                }
                totalFare = totalFare+getFare;
        }

        System.out.println("Total fare : Rs " +totalFare);

    }
}
