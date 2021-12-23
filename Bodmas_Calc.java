import java.util.Stack;

public class Bodmas_Calc {

        public static void calculator(String[] temp_input) {
            Stack<Character> symbols = new Stack<>();
            Stack<Double> numbers = new Stack<>();

            int temp_length = temp_input.length;
            if(temp_length% 2==1) {

                for (int i = 0; i < temp_length; i++) {

                    if (i % 2 == 0 ) {
                        if(temp_input[i]=="+" || temp_input[i] == "-" || temp_input[i] == "*" || temp_input[i] == "/"){
                            System.out.println("Input given is invalid ");
                            System.exit(-1);
                        }
                        else {
                            Double value = Double.parseDouble(temp_input[i]);
                            numbers.push(value);
                            System.out.println(numbers);
                        }

                    }
                    else  {
                        for (int j = 0; j < temp_input[i].length(); j++) {

                            if (temp_input[i].charAt(j) == '+' || temp_input[i].charAt(j) == '-' || (temp_input[i].charAt(j)) == '*' || (temp_input[i].charAt(j)) == '/') {

                                while (!symbols.empty() && precedenceCheck(temp_input[i].charAt(j), symbols.peek())) {

                                    numbers.push(operation(symbols.pop(), numbers.pop(), numbers.pop()));


                                }

                                symbols.push(temp_input[i].charAt(j));
                                System.out.println(symbols);

                            }
                            else {
                                System.out.println( " Given input is not valid so cant process ");
                                System.exit(-1);
                            }


                        }
                    }
                }
                while (!symbols.empty()) {
                    numbers.push(operation(symbols.pop(), numbers.pop(), numbers.pop()));
                }

                System.out.println("Final result of the input given is :  " + numbers.pop());
            }
            else {
                System.out.println("Input is invalid cant do the process");
            }

        }


        public static boolean precedenceCheck(char operand1, char operand2) {
            if ((operand1 == '/' || operand1 == '*') && (operand2 == '+' || operand2 == '-')) {
                return false;
            } else {

                return true;
            }
        }


        public static double operation(char operand, double variable1, double variable2) {
            switch (operand) {
                case '+':
                    return variable2 + variable1;

                case '-':
                    return variable2 - variable1;

                case '*':
                    return variable2 * variable1;

                case '/':
                    return variable2 / variable1;

            }
            return 0;
        }

        public static void main(String[] args) {

//        char [] input = {'3','*','0','+','5','+','8','/','2' };
            String[] input = {"100", "+", "6", "/", "-3", "+", "-32", "/", "2"};


            calculator(input);
        }

    }
