
import java.util.Scanner;

public class Calculation {
    public static void main(String args[]){
        double x,y,z;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        x = s.nextDouble();
        System.out.println("Enter the second number");
        y = s.nextDouble();
        z = x+y;
        System.out.println("Addition :" +z);
        z = x-y;
        System.out.println("Subraction :" +z);
        z = x*y;
        System.out.println("multiplication :" +z);
        z = x/y;
        System.out.println(" divison :" +z);

    }
}
