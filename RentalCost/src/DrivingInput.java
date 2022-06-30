import java.util.Scanner;

public class DrivingInput {

    public static void calculate(double initialAmount, int years, int months, double increaseInPay){

        double totalAmount= 0;

             totalAmount = initialAmount * Math.pow(1 + (increaseInPay / months), months * years);

        System.out.println(totalAmount);
    }
    public static void main(String[] args) {
        char[] ch = {'a','b','c','d','e'};
        String sw = new String(ch);
        String r = "javapoint";
        System.out.println(sw+" "+r);
        double initialAmount;
        double annualRent = 0;
        int noOfYears;
        int months;
        double totalAnnualRent = 0;
        double increaseInRent;
        Scanner s = new Scanner(System.in);
            System.out.println("Monthly rental of the house : ");
        initialAmount = s.nextDouble();
        System.out.println("No of months : ");
        months = s.nextInt();
        System.out.println("No of years to stay : ");
        noOfYears = s.nextInt();
        System.out.println("Discount to be provided for every year : ");
        increaseInRent = s.nextDouble();
        calculate(initialAmount,noOfYears,months,increaseInRent);
    }

}
