import java.util.Scanner;

public class Smallest {
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

        for(int i=0;i<a;i++){
         for(int j=i+1;j<a;j++){
             if(arr[i]>arr[j]) {
                 t =arr[j];
                 arr[i] = arr[j];
                 arr [i]= t;
             }
             t =arr[0];

              }

        }
        System.out.println("smallest number in a array:" +t);
    }
}
