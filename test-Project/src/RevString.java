import java.io.FileReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;


public class RevString {
    public static float multiple(float a, float b) {
        float result;
        result = a*b;
        return result;
    }
   public static void conversion(char a){
        int ascii = a;
        int castascii = (int) a;
        System.out.println("a =" +ascii);

   }

   public static void modulus(int a,int b ) {
        int quotient = a/b;
        int remainder = a%b;
        System.out.println(quotient+ " "+remainder);

   }

   public static void swapNumber(int a,int b){
         b = a+b;
         a = b-a;
         b = b-a;
       System.out.println(a+ " " +b);
   }

   public static void swapping(int a,int b){
        int c = a;
        a=b;
        b=c;
        System.out.println(a+ " " +b);
   }

   public static void evenNo(int a){
        if(a%2==0) {
            System.out.println("its even no");
        }
        else {
            System.out.println("its odd no");
        }
   }

   public static void vowelOrConsonants(char ch ) {
        if(ch =='a' || ch == 'e' || ch == 'i' || ch =='o' || ch =='u'){
            System.out.println("Given word is vowel");
        }
        else  {
            System.out.println("Given word is consonants");
        }
   }

   public static int factorialNo(int a ){
        int result=0;
        if(a<1 ){
            return result=1;
        }
        else {
            return result=a*factorialNo(a-1);
        }
    }

   public static void multiple(int a){
        for(int i=1;i<=10;i++){
            System.out.println(a +"*"+ i +"=" +a*i);
        }
    }

   public static void power(int a,int b){
        int result=1;
        for(int i=0;i<b;i++){
            result = a*result;
        }
        System.out.println(result);
   }

   public static void armstrong(int a ) {
        double remainder ,power=0;
        while(a!=0){
            remainder = a%10;
            power = power+ Math.pow(remainder,3);
            a = a/10;
        }
        if(power ==a ){
            System.out.println("given no is armstrong");
        }
        else{
            System.out.println("Given no is not armstrong");
        }
   }

   public static void ascendingOrder(){
        int []a ={10,5,2,4,6,1};
        int len = a.length;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] =temp;
                }
            }
        }
        System.out.println("Arrays no are ");
        for(int i =0;i<a.length;i++){
            System.out.print(a[i] +"\t");
        }
        System.out.println();
   }

   public static void printRightAngleTriangleStars(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
   }

   public static void printLeftAngleTriangleStars(int n){
        int i,j;
        for(i=0;i<n;i++){
            for(j=2*(n-i);j>=0;j--){
                System.out.print(" ");
            }
            for(j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
   }

   public static void printInverseAngleTriangleStars(int n){
        int i,j;
        for( i =0;i<n;i++){
            for( j=(n-i);j>0;j--){
               System.out.print("*");
           }
            System.out.println();
        }
       System.out.println(Math.floor(625));
    }

    public static void palindromeCheck(String iP){
        String result ="";
        for(int i=iP.length()-1;i>=0;i--){
            result = result + iP.charAt(i);
        }
        if(result.equals(iP)){
            System.out.println("Given string is Palindrome");
        }
        else {
            System.out.println("Given string is not palindrome");
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        Scanner s = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        names.add("abi");
        names.add("akash");
        names.add("Andrew");
        names.add("adams");
        names.add(null);
        System.out.println(names);
        Iterator<String> itr = names.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        Stack<String> stk =new Stack<>();
        stk.push("basil");
        stk.push("berlin");
        stk.push("bash");
        stk.push("bill");
        stk.push(null);
        Iterator<String> list = stk.iterator();
        while(list.hasNext()){
            System.out.println(list.next());
        }
        System.out.println(stk.pop());
        System.out.println(stk.peek());

        SortedSet<String> value = new TreeSet<>();

        value.add("luffy");
        value.add("zoro");
        value.add("nami");
        value.add("robin");
        value.add("chopper");
        value.add("franky");
        value.add("jinbe");
        value.add("null");
        System.out.println(value);
        SortedSet<Integer> no = new TreeSet<>();
        no.add(23);
        no.add(22);
        no.add(13);
        no.add(2);
        no.add(34);
        System.out.println(no);

        System.out.println(multiple(10.00f,5.00f));
        conversion('a');
        modulus(25,5);
        swapNumber(10,5);
        swapping(20,10);
        evenNo(20);
        vowelOrConsonants('i');
        vowelOrConsonants('d');
        System.out.println(factorialNo(4));
        multiple(5);
        power(3,4);
        armstrong(121);
        armstrong(153);
        ascendingOrder();
        printRightAngleTriangleStars(5);
        printLeftAngleTriangleStars(5);
        printInverseAngleTriangleStars(5);
        InetAddress myIP = InetAddress.getLocalHost();
        System.out.println(myIP);
        String input = s.next();
        palindromeCheck(input);
        int arr[]={9,5,1,4,3};

    }
}



