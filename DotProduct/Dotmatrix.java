package mani;

import java.util.Scanner;

public class Dotmatrix {
    public static void dotproduct(int dot1[][],int dot2[][],int w,int x,int y,int z){
        int dot3[][]=new int[w][z];
        if(x==y){
            System.out.println("Dot product of two matrices are : ");
            for (int i = 0; i < w; i++) {
                for (int j = 0; j <z; j++) {
                    dot3[i][j]=0;
                    for(int k=0;k<y;k++) {
                     dot3[i][j] += dot1[i][k]*dot2[k][j];
                    }
                    System.out.print(dot3[i][j] +" ");
                }
                System.out.println();
            }
    }
        else{
            System.out.println("We cant do dot product matrix for this two matrices");
        }
}

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        int dot1[][] = new int[a][b];
        int dot2[][] = new int[c][d];

        System.out.println("Enter thez elements for matrix1: ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <b ; j++) {
                dot1[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter the elements for matrix2: ");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j <d ; j++) {
                dot2[i][j] = s.nextInt();
            }
        }

        System.out.println("Matrix 1 are : ");
        for (int i = 0; i< a; i++) {
                for (int j = 0; j < b; j++) {
                    System.out.print(dot1[i][j] +"\t");
                }
            System.out.println();
        }
        System.out.println("Matrix 2 are : ");
        for (int i = 0; i< c; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print(dot2[i][j] +"\t");
            }
            System.out.println();
        }

         dotproduct(dot1,dot2,a,b,c,d);
    }
}