package mani;

public class Calculation {
    
    static double add(double x, double y){
        return x+y;
    }
    static double sub(double x, double y){
        return x-y;
    }
    static double multi(double x, double y){
        return x*y;
    }
    static double div(double x, double y){
        return x/y;
    }

    public static void main(String args[]) {
        double z = add(5,3);
        System.out.println("Addition of two numbers:" +z);
         z = sub(4,7);
        System.out.println("Subtraction of two numbers:" +z);
         z = multi(6,2);
        System.out.println("Multiple of two numbers:" +z);
         z = div(7,2);
        System.out.println("Division of two numbers:" +z);
    }

}