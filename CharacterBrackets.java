import java.util.Scanner;

public class CharacterBrackets {
    static int balanced(char[]a) {
        int count =0;
        int m = a.length;
        if(m%2==0){
            int i =0;
            int n = m/2;
            while(i<n){
                if( a[i] == '{' || a[i] == '(' ||  a[i] == '[') {
                    for(int j=m-1;j>=n;j--) {

                        if(a[i]== '{' &&  a[j]=='}') {
                            count++;
                        }

                        else if (a[i]=='[' && a[j]==']'){
                            count++;
                        }

                        else if(a[i]=='(' && a[j]==')'){
                            count++;
                        }
                        i++;
                    }
                }
                return count;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter some characters: ");
        char[] a = s.next().toCharArray();
        System.out.println("Array Elements are : ");
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+ "\t");
        }
        System.out.println(" ");
        if( balanced(a) == a.length/2){
            System.out.println("Given character is balanced ");
        }
        else {
            System.out.println("Given array is not balanced");
        }
    }
}
