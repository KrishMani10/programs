import java.util.Scanner;

public class SwitchString {

      public static void string_equals(){

              Scanner s = new Scanner(System.in);
              System.out.println("Enter 1st string input: ");
              String str1 = s.nextLine();
              System.out.println("String1 input is : " + str1);
              System.out.println("Enter 2nd string input: ");
              String str2 = s.nextLine();
              System.out.println("String2 input is : " + str2);

              if (str1.equals(str2)) {
                  System.out.println("Given two strings are equal");
              } else {
                  System.out.println("given two strings are not equal");
              }
        }

        public static void string_concat(){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter 1st string input: ");
            String str1 = s.nextLine();
            System.out.println("String1 input is : " +str1);
            System.out.println("Enter 2nd string input: ");
            String str2 = s.nextLine();
            System.out.println("String2 input is : " +str2);


            String concat_result = str1.concat(str2);
            System.out.println("Concatenation of two strings are : " +concat_result);

        }

        public static void string_compare() {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter 1st string input: ");
            String str1 = s.nextLine();
            System.out.println("String1 input is : " +str1);
            System.out.println("Enter 2nd string input: ");
            String str2 = s.nextLine();
            System.out.println("String2 input is : " +str2);


            int compare_val = str1.compareTo(str2);
            System.out.println("Compare of two strings are : " +compare_val);

        }

        public static void string_replace() {
            int i = 0;

            Scanner s = new Scanner(System.in);
            System.out.println("Enter string input: ");
            String str = s.nextLine();
            System.out.println("String input is : " + str);

            System.out.println("Input character want to replace : ");
            char c = s.next().charAt(0);

            System.out.println("Input character want to replaced with : ");
            char r = s.next().charAt(0);

            String replace = str.replace(c, r);
            if(replace != str) {
                    System.out.println("String after replacing character : " + replace);
                } else {
                    System.out.println("There is no replacement in string : " + str);
                }
        }

        public static void string_sub(){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter 1st string input: ");
            String str = s.nextLine();
            System.out.println("String1 input is : " +str);
            System.out.println("Enter start index position : ");
            int startIndex = s.nextInt();
            System.out.println("Enter end index position : ");
            int endIndex = s.nextInt();

            if(startIndex>=0 && endIndex>=0) {

                if (startIndex <  str.length()) {

                    String result = str.substring(startIndex);
                    System.out.println("Substring of a string is with start position : " + result);
                } else {
                    System.out.println("Cant print the substring value of a string with start position");
                }

                if (startIndex < str.length() && endIndex < str.length()) {

                    String result1 = str.substring(startIndex, endIndex);
                    System.out.println("Substring of a string is with start and end position  : " + result1);
                } else {
                    System.out.println("Cant print the substring value of a string with start and end position");
                }
            }
            else {
                System.out.println(" Index value is out of range so cant print substring ");
            }
        }

        public static void string_length(){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter 1st string input: ");
            String str1 = s.nextLine();
            System.out.println("String1 input is : " +str1);
            System.out.println("Enter 2nd string input: ");
            String str2 = s.nextLine();
            System.out.println("String2 input is : " +str2);

            int len1 = str1.length();
            int len2 = str2.length();
            System.out.println("The length of first string input is : " +len1);
            System.out.println("The length of second string input is : " +len2);
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
        boolean run =true;
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
