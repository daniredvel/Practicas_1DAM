package Hoja_10;

import java.util.Scanner;

public class H10E04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número");
        num = in.nextInt();
        for (int i = num, k=1; i >= 1 && k <= num; i--, k++) {
            int j=0,p=0;
            while(j!=i) {
                System.out.print(" ");
                j++;
            }
            while(p!=k) {
                System.out.print("*");
                p++;
            }
            System.out.println();
        }
        in.close();

    }
}
