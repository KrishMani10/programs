
import java.util.Scanner;


public class MyString {
        private final char[] input;

        public void print(){
            for(int i=0; i<this.input.length; i++){
                System.out.print(this.input[i]);
            }
            System.out.println();
        }

        MyString(char[] input1) {
            this.input =  input1;
            System.out.println(this.input);
        }

        @Override
        public String toString() {

            return new String(input);
        }

        public boolean equals(MyString arr2) {
            int length1 = this.input.length;
            int length2 = arr2.input.length;
            boolean check = false;

            if (length1 == length2) {
                for (int i = 0; i < length1; i++) {
                    if (this.input[i] == arr2.input[i]) {
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            return check;
        }


        public MyString concat(MyString arr2) {
            int length1 = this.input.length;
            int length2 = arr2.input.length;

            int final_length = length1 + length2;
            char[] concat_resultant = new char[final_length];
            int position = 0;


            for (char temp : this.input) {
                concat_resultant[position] = temp;
                position++;
            }

            for (char temp : arr2.input) {
                concat_resultant[position] = temp;

                position++;
            }
            return new MyString(concat_resultant);
        }

        public int compareTo(MyString arr2){
            int compare_val = 0;
            int i = 0;
            int limit = Math.min(this.input.length, arr2.input.length);
            if (this.input.length != arr2.input.length) {
                while (i < limit) {
                    if (this.input[i] != arr2.input[i]) {
                        compare_val = this.input[i] - arr2.input[i];
                        break;
                    } else {
                        compare_val = this.input.length - arr2.input.length;
                    }
                    i++;
                }
            } else {
                while (i < limit) {
                    if (this.input[i] != arr2.input[i]) {
                        compare_val = this.input[i] - arr2.input[i];
                        break;
                    }
                    i++;
                }
            }
            return compare_val;
        }

        public MyString replace(char inChar, char tobeReplaced) {

            char []replace_op = new char[this.input.length];
            if(inChar != tobeReplaced) {
                for (int i = 0; i < this.input.length; i++) {
                    if (inChar == this.input[i]) {
                        this.input[i] = tobeReplaced;
                    }
                    replace_op = this.input;
                }
            }
            return new MyString(replace_op);

        }

        public MyString substring(int startIndex) {
            int arr1_length1 = this.input.length;
            int position = 0;
            char[] sub_String = new char[arr1_length1];

            if (startIndex >= 0) {

                if (startIndex < arr1_length1) {

                    for (int i = startIndex; i < arr1_length1; i++) {
                        sub_String[position] = this.input[i];
                        position++;
                    }
                    return new MyString(sub_String);
                }
                else {
                    return null;

                }
            }
                return null;
        }

        public MyString substring(int startIndex, int endIndex) {
            int arr1_length1 = this.input.length;
            int position1 = 0;
            System.out.println();
            if (startIndex >= 0 && endIndex >= 0) {

                if (startIndex < arr1_length1 && endIndex < arr1_length1) {
                    char[] sub_String = new char[endIndex - startIndex];
                    for (int i = startIndex; i < endIndex; i++) {
                        sub_String[position1] = this.input[i];
                        position1++;
                    }
                  return new MyString(sub_String);
                }
                return null;
            }
            return null;
        }

        public int length() {
            return this.input.length;
        }
    }


class my_String{

        public static void operationSwitch(int operation) {
            Scanner s = new Scanner(System.in);
            MyString switch_input1;
            MyString switch_input2;
            switch (operation) {
                case 1:
                    System.out.println("Enter 1st  input: ");
                    switch_input1 = new MyString(s.next().toCharArray());
                    System.out.println("Enter 2nd input: ");
                    switch_input2 = new MyString(s.next().toCharArray());
                    if (switch_input1.equals(switch_input2)) {
                        System.out.println("Inputs are equal");
                    } else {
                        System.out.println("Inputs are not equal");
                    }
                    break;
                case 2:
                    System.out.println("Enter 1st input: ");
                    switch_input1 = new MyString(s.next().toCharArray());
                    System.out.println("Enter 2nd input: ");
                    switch_input2 = new MyString(s.next().toCharArray());


                    switch_input1 = new MyString("Test".toCharArray());
                    switch_input2 = new MyString("Help".toCharArray());

                    switch_input1.concat(switch_input2);

                    System.out.println("Question???"+ switch_input1);
                    //System.out.println(switch_input1);

                    MyString output = (switch_input1.concat(switch_input2));

                     System.out.println("Concatenation of two inputs are : " );

                    System.out.print(output);
                    break;
                case 3:
                    System.out.println("Enter 1st input: ");
                    switch_input1 = new MyString(s.next().toCharArray());
                    System.out.println("Enter 2nd input: ");
                    switch_input2 = new MyString(s.next().toCharArray());
                    ;
                    System.out.println("Compare value of two inputs are : " +switch_input1.compareTo(switch_input2));
                    break;
                case 4:
                    System.out.println("Enter the input for which character to be replaced : ");
                    switch_input1 = new MyString(s.next().toCharArray());

                    System.out.println("Input character want to replace : ");
                    char input_char = s.next().charAt(0);
                    System.out.println("Input character want to replaced with : ");
                    char to_replace = s.next().charAt(0);

                    MyString replace_Output =  switch_input1.replace(input_char, to_replace);
                    System.out.println("Replacement after the inputs are: " +replace_Output);

                    break;
                case 5:
                    System.out.println("Enter the input for which substring to be find : ");
                    switch_input1 = new MyString(s.next().toCharArray());
                    System.out.println("Enter start index position : ");
                    int startIndex = s.nextInt();
                    System.out.println("Enter end index position : ");
                    int endIndex = s.nextInt();
                    System.out.println("Substring of a input is : " +switch_input1.substring(startIndex));

                    System.out.println("Substring of a input is : " +switch_input1.substring(startIndex, endIndex));
                    break;
                case 6:
                    System.out.println("Enter the input to find length : ");
                    switch_input1 = new MyString(s.next().toCharArray());
                    System.out.println("The length of the given input : " + switch_input1.length());
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
         while (input <= 6);
     }

}

