package Hoja_7;

import java.util.Scanner;
public class H07E10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, n=0;
        System.out.println("Escriba un número:");
        num = in.nextInt();
        while(num != n){
            System.out.print("*");
            n++;
        }
        in.close();
    }
}
