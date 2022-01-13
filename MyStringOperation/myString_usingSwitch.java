package mani;

import java.util.Scanner;

public class myString_usingSwitch {

        public static char[] myString1() {
            Scanner s = new Scanner(System.in);
            System.out.println("Input elements are :");
            char[] input1 = s.next().toCharArray();

            return input1;
        }

        public static char[] myString2() {

            Scanner s = new Scanner(System.in);
            System.out.println("Input elements are : ");
            char[] input2 = s.next().toCharArray();

            return input2;
        }


        public static void string_equals(){

            char[] temp_input1 =  myString1();
            char[] temp_input2 = myString2();

            int length1 = temp_input1.length;
            int length2 = temp_input2.length;
            boolean check = true;

            if(length1==length2){
                for(int i=0;i<length1;i++){
                    if (temp_input1[i] != temp_input2[i]) {
                        check = false;
                        break;
                    }
                }
            }
            else {
                check =false;
            }
            if(check){
                System.out.println(" Given two inputs are equal ");
            }
            else
            {
                System.out.println(" Given two inputs are not equal ");
            }
        }

        public static void string_concat(){

            char[] temp_input1 =  myString1();
            char[] temp_input2 = myString2();
            int length1 = temp_input1.length;
            int length2 = temp_input2.length;

            int final_length = length1+length2;
            char[] concat_resultant =  new char[final_length];
            int position=0;


            for(char temp :temp_input1) {
                concat_resultant[position] = temp;
                position++;
            }

            for(char temp :temp_input2) {
                concat_resultant[position] = temp;
                position++;
            }
            System.out.print("Concatenation of two strings are : " );

            for(int i=0;i<final_length;i++) {
                System.out.print(concat_resultant[i]);
            }
        }

        public static void string_compare() {

            char[] temp_input1 = myString1();
            char[] temp_input2 = myString2();
            int compare_val = 0;
            int ascii_character1 =0,ascii_character2=0;
            int i=0;
            if (temp_input1.length!= temp_input2.length){

                while(i<temp_input1.length){
                    for(int j=0;j< temp_input2.length;j++){
                        if(temp_input1[i]!=temp_input2[j])
                        {
                            ascii_character1 = temp_input1[i];
                            ascii_character2 = temp_input2[j];
                            compare_val = ascii_character1 - ascii_character2;

                        }
                        else if(i>=temp_input1.length || j>=temp_input2.length) {
                            compare_val = temp_input1.length- temp_input2.length;
                        }
                        else if(temp_input1[i]==temp_input2[j]){
                            compare_val =0;
                        }
                    }
                    i++;
                }

            }
            else {
                for(i=0;i<temp_input1.length;i++){
                    if(temp_input1[i]!=temp_input2[i]){
                        ascii_character1 = temp_input1[i];
                        ascii_character2 = temp_input2[i];

                        compare_val = ascii_character1-ascii_character2;
                        break;
                    }
                    else {
                        compare_val=0;
                    }

                }
            }

            System.out.println("Compare of two inputs are : " +compare_val);

        }

        public static void string_replace() {


            Scanner s = new Scanner(System.in);
            char[] temp_input1 = myString1();

            System.out.println("Input character want to replace : ");
            char old_character = s.next().charAt(0);

            System.out.println("Input character want to replaced with : ");
            char new_character = s.next().charAt(0);

            if(old_character!=new_character) {
                for (int i = 0; i < temp_input1.length; i++) {
                    if (old_character == temp_input1[i]) {
                        temp_input1[i] = new_character;
                    }
                }
                System.out.print ("After replacing the character input : ");
                for (int i = 0; i < temp_input1.length; i++) {
                    System.out.print(temp_input1[i]);
                }
            }
            else{
                System.out.println("There is no change in the input : " +temp_input1);
            }

        }

        public static void string_sub(){
            Scanner s = new Scanner(System.in);
            char [] temp_input1 = myString1();
            int temp_length = temp_input1.length;

            int position =0,position1=0;
            char [] sub_String = new char[temp_length];

            System.out.println("Enter start index position : ");
            int startIndex = s.nextInt();
            System.out.println("Enter end index position : ");
            int endIndex = s.nextInt();

            if(startIndex>=0 && endIndex>=0) {

                if (startIndex < temp_length) {
                    for (int i = startIndex; i < temp_length; i++) {
                        sub_String[position] = temp_input1[i];
                        position++;
                    }
                    System.out.println("Substring of the input is : ");
                    for (int i = 0; i < position; i++) {
                        System.out.print(sub_String[i]);
                    }
                }
                else{
                    System.out.println("Cant print the substring value");

                }
                System.out.println("");
                if (startIndex < temp_length && endIndex < temp_length) {
                    for (int i = startIndex; i < endIndex; i++) {
                        sub_String[position1] = temp_input1[i];
                        position1++;
                    }

                    System.out.println("Substring of the input is : ");
                    for (int i = 0; i < position1; i++) {
                        System.out.print(sub_String[i]);

                    }
                }
                else {
                    System.out.println("Cant print the substring value");
                }


            }
            else {
                System.out.println(" Index value is out of range so cant print substring ");
            }
        }

        public static void string_length(){

            int length1 = myString1().length;
            int length2 = myString2().length;
            System.out.println("The length of first string input is : " +length1);
            System.out.println("The length of second string input is : " +length2);
        }

        public static void operationSwitch(int operation){

            switch (operation) {

                case 1:
                    string_equals();
                    break;
                case 2:
                    string_concat();
                    break;
                case 3:
                    string_compare();
                    break;
                case 4:
                    string_replace();
                    break;
                case 5:
                    string_sub();
                    break;
                case 6:
                    string_length();
                    break;
            }
        }


        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int input;
            System.out.println("String operations are : " + " 1. StringEqual " + " 2. StringConcat" + " 3. StringCompare"
                    + " 4. StringReplace" + " 5. StringSubstring" + " 6. StringLength " + " 7. Exit");

            do {
                System.out.println("Enter the string operation to be done: ");
                input = s.nextInt();
                operationSwitch(input);
                System.out.println();
            }
            while(input<=6);
            
    }

}