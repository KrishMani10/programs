import java.util.Scanner;

public class Indexpos {

    static  int position(int arr[],int l,int f) {

        for (int i = 0; i < l; i++) {
            if (f == arr[i]) {
               return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array :");
        int a = s.nextInt();
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("Enter the number to be found: ");
        int b = s.nextInt();
        if(position(arr, a, b)==-1) {
            System.out.println("Number is not found in the list ");
        }
        else {
            System.out.println("Element " + b + " to be found at index :" +position(arr,a,b));
        }
    }
}