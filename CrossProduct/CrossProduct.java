package mani;

import java.util.Scanner;

public class CrossProduct {
    public static void crossproduct(int mat1[][],int mat2[][],int u,int v){
        int temp[][] = new int[u][v];
        temp[0][0] = mat1[0][1]*mat2[0][2] - mat1[0][2]*mat2[0][1];
        temp[0][1] = mat1[0][2]*mat2[0][0] - mat1[0][1]*mat2[0][2];
        temp[0][2] = mat1[0][0]*mat2[0][1] - mat1[0][2]*mat2[0][1];
        System.out.println("Cross product of two matrices are : ");
        for (int i = 0; i < u; i++) {
            for (int j = 0; j <v ; j++) {
                System.out.print(temp[i][j] +"\t");

            }
            System.out.println();
        }

    }
    public static void printMatrix(int mat1[][],int mat2[][],int x,int y){
        System.out.println("Matrix1 elements are : ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(mat1[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Matrix elements are : ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(mat1[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("enter the no of rows:");
        int a = s.nextInt();
        System.out.println("enter the no of columns:");
        int b = s.nextInt();
        int matrix1[][]=new int[a][b];
        int matrix2[][]=new int[a][b];
        System.out.println("Matrix 1 elements are : ");
        for (int i = 0; i <a ; i++) {
            for (int j = 0; j < b; j++) {
                matrix1[i][j] = s.nextInt();
            }
        }
        System.out.println("Matrix 2 elements are : ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix2[i][j]=s.nextInt();
            }
        }
        printMatrix(matrix1,matrix2,a,b);
        crossproduct(matrix1,matrix2,a,b);

    }
}