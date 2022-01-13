package mani;

import java.util.Stack;

public class UnaryOp_Bodmas {

        public static void calculator_op(String[] temp_input) {
            Stack<Double> unary_num = new Stack<>();
            Stack<Character> symbols = new Stack<>();
            if (temp_input.length % 2 == 1) {
                for (int i = 0; i < temp_input.length; i++) {
                    if (i % 2 == 0) {

                        unary_num.push(calc_method(temp_input[i]));
                        System.out.println(unary_num);
                    } else {
                        for (int j = 0; j < temp_input[i].length(); j++) {

                            if (temp_input[i].charAt(j) == '+' || temp_input[i].charAt(j) == '-' || (temp_input[i].charAt(j)) == '*' || (temp_input[i].charAt(j)) == '/') {
                                while (!symbols.empty() && precedenceCheck(temp_input[i].charAt(j), symbols.peek())) {

                                    unary_num.push(operation(symbols.pop(), unary_num.pop(), unary_num.pop()));

                                }
                                symbols.push(temp_input[i].charAt(j));
                                System.out.println(symbols);
                            }
                        }
                    }
                }

                while (!symbols.empty()) {
                    unary_num.push(operation(symbols.pop(), unary_num.pop(), unary_num.pop()));
                }

                System.out.println("Final result of the input given is :  " + unary_num.pop());
            }
            else {
                System.out.println("Given set of input given is invalid");
            }
        }


        public static String replace_value(String input){
            int rep_count = count_value(input);
            String result = "";
            if(input.charAt(0)=='+'){
                result = input.replace("+","");

            }
            else if(input.charAt(0)=='-'){
                result = input.replace("-","");
            }
            else if(input.charAt(0)>='0' && input.charAt(0)<='9') {
                for (int i = 0; i < input.length(); i++) {
                    if (rep_count == 2 && input.charAt(i) == '+') {
                        result = input.replace("+", "");
                        break;
                    } else if (rep_count == 2 && input.charAt(i) == '-') {
                        result = input.replace("-", "");
                        break;
                    }
                }
            }

            return result;
        }


        public static int count_value(String input) {

            int count = 0;
            if (input.charAt(0) == '+') {
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == '+') {
                        count++;
                    }
                }
            } else if (input.charAt(0) == '-') {
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == '-') {
                        count++;
                    }

                }
            }
            else if(input.charAt(0)>= '0'&& input.charAt(0)<='9') {
                for (int i = 0; i < input.length(); i++) {
                    if(input.charAt(i) == '+') {
                        count++;
                    }
                    if(input.charAt(i)== '-'){
                        count++;
                    }
                }
            }
            return count;
        }


        public static double calc_method(String input1) {
            String temp_value = "";
            double fin_value = 0;
            int count_val = count_value(input1);

            if(input1.charAt(0) == '+') {
                if (count_val == 2) {
                    temp_value = replace_value(input1);
                    fin_value = Double.parseDouble(temp_value);
                    ++fin_value;
                } else if (count_val == 1) {
                    temp_value = replace_value(input1);
                    fin_value = Double.parseDouble(temp_value);
                    return fin_value;
                }
            }
            else if(input1.charAt(0) == '-'){
                if(count_val ==2) {
                    temp_value = replace_value(input1);
                    fin_value = Double.parseDouble(temp_value);
                    --fin_value;
                }
                else if(count_val ==1){
                    temp_value = replace_value(input1);
                    fin_value = Double.parseDouble(temp_value) *-1;
                    return fin_value;
                }
            }
            else if(input1.charAt(0) >= '0' && input1.charAt(0)<= '9') {
                for(int i=0;i<input1.length();i++) {

                    if (count_val == 2 && input1.charAt(i) == '+') {
                        temp_value = replace_value(input1);
                        fin_value = Double.parseDouble(temp_value);
                        return fin_value++;
                    } else if (count_val == 2 && input1.charAt(i)== '-') {
                        temp_value = replace_value(input1);
                        fin_value = Double.parseDouble(temp_value);
                        return fin_value--;
                    }
                    else if(count_val==1){
                        System.out.println("given input is invalid");
                        System.exit(-1);
                    }
                    else if (count_val == 0) {

                        fin_value = Double.parseDouble(input1);

                    }



                }
            }
            else {
                System.out.println("Given input is invalid cant process further ");
                System.exit(-1);
            }
            return fin_value;
        }


        public static boolean precedenceCheck(char operand1,char operand2){
            if ((operand1 == '/' || operand1 == '*')&& (operand2 == '+'||operand2 == '-' )){
                return false;
            }
            else{

                return true;
            }
        }


        public static double operation(char operand ,double variable1,double variable2){
            switch(operand){
                case '+' :
                    return variable2 + variable1;

                case '-' :
                    return variable2 - variable1;

                case '*' :
                    return variable2 * variable1;

                case '/' :

                    return variable2 / variable1;

            }
            return 0;
        }

        public static void main(String[] args) {
            String []input= {"++2","+","--2","/","10++","-","9--","*","-4","+","11"};
            calculator_op(input);
            //  int a=10,b=5,c=3,d=2;
            // System.out.println(++a + --b  * c++ - d--);

        }
}