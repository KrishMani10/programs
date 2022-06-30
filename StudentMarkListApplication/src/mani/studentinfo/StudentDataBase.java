package mani.studentinfo;

import mani.authentication.AuthenticationCheck;
import mani.services.CrudService;

import java.util.Scanner;

public class StudentDataBase {
    static Scanner s = new Scanner(System.in);

    public static void dataOperation(int input) {
        switch (input) {
            case 1 :
                System.out.println(" Displaying all student details ");
                CrudService.displayStudentDetails();

            case 2 :
                CrudService.sortingOnRollNumber();
                break;

            case 3 :
                CrudService.sortingOnStudTotalMarks();
                break;

            case 4 :
                System.out.println("Enter student rollNumber to find his name : ");
                int idToFind = s.nextInt();
                CrudService.searchRollNumber(idToFind);
                break;

            case 5 :
                System.out.println("Enter student name to find his name : ");
                String nameToFind = s.next();
                CrudService.searchStudentName(nameToFind);
                break;

            case 6:
                System.out.println("Enter new student details to the student");
                System.out.println("Enter new Student name : ");
                String newStudentName = s.next();
                String[] subjectName= new String[6];
                int[]  subjectScore = new int[6];
                for(int i=0;i<6;i++){
                    System.out.println("Enter subject" +(i+1)+ " name : ");
                    subjectName[i] = s.next();

                    System.out.println("Enter subject" +(i+1)+ " score  :");
                    subjectScore[i] =s.nextInt();
                }

                CrudService.addNewStudentInfo(newStudentName,subjectName,subjectScore);
                break;

            case 7:
                System.out.println("Enter old student rollNo you want to remove : ");
                int oldStudRollNumber = s.nextInt();
                CrudService.removeOldStudentInfo(oldStudRollNumber);
                break;

            case 8 :
                System.exit(8);
        }
    }


    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("Welcome to  Student Information section ");
        System.out.println("===============================================");

        System.out.println("Staff Login Section");
        int operationToBeDone =0;
        System.out.println("*********************************");

        System.out.println("Enter staff userName : ");
        String userName = s.next();
        System.out.println("Enter staff password : ");
        String password = s.next();

        boolean authenticationCheck = AuthenticationCheck.checkDetails(userName, password);

        if (authenticationCheck) {
            System.out.println("Student information based on operation :   "
                    + "\n" + "1. Displaying all students details "
                    + "\n" + "2. Sorting Students based on Roll number "
                    + "\n" + "3. Sorting Students based on Total Marks "
                    + "\n" + "4. Search Roll Number to find his name "
                    + "\n" + "5. Search name to print his name if present "
                    + "\n" + "6. Add new Student details to Student database "
                    + "\n" + "7. Delete old Student details if needed "
            );

            System.out.println(" ");
            do {
                try {
                    System.out.println("Action to be performed : ");
                    operationToBeDone = s.nextInt();
                    dataOperation(operationToBeDone);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Action cannot be done , check it again");
                }
            }
            while (operationToBeDone <= 7);
        }
        else {
            System.out.println("Given userName & password is incorrect!!!. Please try again !!!");
        }
    }
}
