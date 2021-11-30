import java.util.Stack;
import java.util.Scanner;

public class CharacterStack {

    public static boolean Check(String str) {
        Stack<Character>stk = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stk.push(c);
            }
            else if ((c == '}' || c == ']' || c == ')') && (!stk.empty())) {
                Character peekedChar = stk.peek();
                if ((stk.peek() == '{' && c == '}') || (stk.peek() == '[' && c == ']') || (stk.peek() == '(' && c == ')')) {
                    stk.pop();
                } else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        if (stk.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
        System.out.println("Enter the String :");
        String str = s.nextLine();
        System.out.println("Strings are : " +str);

        if(Check(str)==true) {
            System.out.println("Given bracket inputs are balanced: ");

        }
        else{
            System.out.println("Given inputs are not balanced");
        }

    }
}
