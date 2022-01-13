package mani;

import java.util.Scanner;

public class RevString {

    public static String reverse_String(String input){
        StringBuilder revString = new StringBuilder();
        for(int i= input.length();i>0;i--){
          revString.append(input.charAt(i - 1));
        }

        return revString.toString();

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the input string: ");
        String str = s.nextLine();
        System.out.println("given string is : " + str);
        System.out.println(str.length());
        System.out.println("Reverse of the input string : " +reverse_String(str));
    }
}