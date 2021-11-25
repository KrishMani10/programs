import java.util.Scanner;

public class Largest {
        public static void main(String[] args) {
            int a;
            int t=0;
            Scanner s = new Scanner(System.in);
            a = s.nextInt();
            int arr[] = new int[a];
            for(int i=0;i<a;i++){
                arr[i] = s.nextInt();
            }
            System.out.println("Array elements are:" );
            for(int i=0;i<a;i++){
                System.out.print(arr[i] +"\t");
            }
            t = arr[0];
            for(int i=0;i<a;i++){

                if(arr[i]>t){
                    t = arr[i];
                }
            }
            System.out.println("smallest number in a array:" +t);
        }

}
