package Hoja_10;

import java.util.Scanner;

public class H10E07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número:");
        num=in.nextInt();
        for(int i = 1, n=1; i<=num; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(n+" ");
                n++;
            }
            System.out.println();
        }
        in.close();
    }
}
