package Hoja_5;

import java.util.Scanner;
public class H05E07 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número");
        num = in.nextInt();
        if(num>=1 && num<=10){
            if(num == 1 || num == 2 || num == 3 || num == 5 || num ==7){
                System.out.println(num + " es primo");
            } else {
                System.out.println(num + " no es primo");
            }
        } else {
            System.out.println("Error");
        }
        in.close();
    }
}
