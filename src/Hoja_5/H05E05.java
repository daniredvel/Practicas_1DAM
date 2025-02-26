package Hoja_5;

import java.util.Scanner;

public class H05E05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1, num2;
        double num3, num4;
        System.out.println("Escriba dos números enteros");
        num1 = in.nextInt();
        num2 = in.nextInt();
        System.out.println("Escriba dos números decimales");
        num3 = in.nextInt();
        num4 = in.nextInt();
        if (num1 + num2 == num3 + num4) {
            System.out.println("Igualitos");
        } else {
            System.out.println("Diferentes");
        }
        in.close();
    }
}
