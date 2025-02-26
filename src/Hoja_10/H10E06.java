package Hoja_10;

import java.util.Scanner;

public class H10E06 {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int num;
                System.out.println("Escriba un número");
                num = in.nextInt();
                for (int k = num, i=1; k >= 1 && i <= num; k--, i++) {
                    int j=0,p=0;
                    while(p!=i) {
                        System.out.print(" ");
                        p++;
                    }
                    while(j!=k) {
                        System.out.print("*");
                        j++;
                    }
                    System.out.println();
                }
                in.close();
    }
}