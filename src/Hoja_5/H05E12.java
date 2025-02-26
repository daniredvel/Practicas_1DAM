package Hoja_5;

import java.util.Scanner;

public class H05E12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int año;
        System.out.println("Escriba el año");
        año = in.nextInt();

        if (año % 400 == 0) {
            System.out.println(año + " es bisiesto");
        } else if (año % 4 == 0) {
            if (año % 100 != 0) {
                System.out.println(año + " es bisiesto");

            } else {
                System.out.println(año + " no es bisiesto");
            }
        } else {
            System.out.println(año + " no es bisiesto");
        } 

        in.close();
    }
}
