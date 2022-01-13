package mani;

import java.util.Scanner;

public class Fibonacci_Series {

    public static void fibonacci(int input){
        int  temp1= 0,temp2 =1,i=0;
        System.out.println("First 10 inputs of fibonacci series are : ");
        while(i<input){
            System.out.print(temp1+ "\t");
            int temp3 = temp1+temp2;
            temp1 = temp2;
            temp2 = temp3;
         i++;
        }
    }
    public static int fibonaaci_2(int input2){

        if(input2<=1){
           return input2;
        }

        return fibonaaci_2(input2-1)+fibonaaci_2(input2-2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of inputs u needed : " );
        int fib_input = s.nextInt();
        fibonacci(fib_input);
        System.out.println();
        System.out.println("First 10 Inputs of fibonacci series are : ");
        for(int i=0;i<fib_input;i++) {
            System.out.print(fibonaaci_2(i)+ "\t");
        }

    }
}