import java.util.Scanner;

public class Character{
    static int balanced(char[]a) {
        int count =0;
        int m = a.length;
        if(m%2==0){
            int i =m/2;
            int n = m/2;
            while(i>=0){
                for(int j=n;j<m;j++) {
                    i--;
                   if(a[i]==a[j]){
                       count++;
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
        System.out.println("Elements: ");
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
      if( balanced(a) == a.length/2){
          System.out.println("Given character is balanced ");
      }
      else {
          System.out.println("Given array is not balanced");
      }
    }
}
