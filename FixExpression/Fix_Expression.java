package mani;

import java.util.Stack;


public class Fix_Expression {

    public static int precedenceCheck(char input){
        if(input == '+' ||input == '-'){
            return (1);
        }
        if(input == '*' || input == '/'){
            return (2);
        }
        return 0;
    }

    public static String inFixToPostfix(String infix_expression1){
        StringBuilder post_result= new StringBuilder();

        Stack<Character> symbols = new Stack<>();
        for(int i=0;i<infix_expression1.length();i++){
            char value = infix_expression1.charAt(i);
            if(precedenceCheck(value)>0){
                while(!symbols.empty()&& (precedenceCheck(symbols.peek())>=precedenceCheck(value))){
                    post_result.append(symbols.pop());
                }
                symbols.push(value);
            }
            else {
                post_result.append(value);
            }
        }
        while(!symbols.empty()){
            post_result.append(symbols.pop());
        }
        return post_result.toString();
    }


    public static String inFixToPrefix(String infix_expression2){
        StringBuilder pre_result = new StringBuilder();
        StringBuilder input = new StringBuilder(infix_expression2);
        input.reverse();
        Stack<Character> symbol = new Stack<>();
        for(int i=0;i<input.length();i++){
            char value = input.charAt(i);
            if(precedenceCheck(value)>0) {
                while (!symbol.empty() && (precedenceCheck(symbol.peek()) > precedenceCheck(value))) {
                    pre_result.append(symbol.pop());
                }
                symbol.push(value);
            }
            else{
                pre_result.append(value);
            }
        }
        while(!symbol.empty()){
            pre_result.append(symbol.pop());
        }
        return pre_result.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "K+L-M*N+O/P*W/U/V*T+Q";
        System.out.println("Given input is : " +input);
        System.out.println("Expression after converting to postfix is : " +inFixToPostfix(input));
        System.out.println("Expression after converting to prefix is : " +inFixToPrefix(input));
        String input1 = "a*b+c*d";
        System.out.println("Expression after converting to postfix is: " +inFixToPostfix(input1));
        System.out.println("Expression after converting to prefix is : "+inFixToPrefix(input1));
        // KL+MN*-OP/W*U/V/T*+Q+   // ++-+KL*MN*//*/OPWUVTQ
    }
}