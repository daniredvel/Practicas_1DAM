package Hoja_5;

import java.util.Scanner;

public class H05E11_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        byte n2, n3, n5;
        String txt;
        n2 = 0;
        n3 = 0;
        n5 = 0;
        txt = "";
        System.out.println("Escriba un número:");
        num = in.nextInt();
        /*
         * Si el resto de dividir un número entre otro significa que el número dividido
         * es múltiplo del número divisor
         */
        /*
         * Si el número es divisible entre 2 con resto 0 (multiplo de 2) a la variable
         * n2 se le añade uno, al igual que con el 3 y el 5
         */

        /*
         * Finalmente se comprueba que variables valen 1 y cuales no, de esta manera se
         * puede comprobar que números al ser divididos
         * por cada valor comprobado han dado 0 y por tanto son multiplos de esos
         * números
         */

        if (num * 1 != 0) {
            if (num % 2 == 0) {
                n2++;
            }
            if (num % 3 == 0) {
                n3++;
            }
            if (num % 5 == 0) {
                n5++;
            }

            if (n2 == 1 && n3 != 1 && n5 != 1) {
                txt = "es multiplo de 2";
            }
            if (n2 != 1 && n3 == 1 && n5 != 1) {
                txt = "es multiplo de 3";
            }
            if (n2 != 1 && n3 != 1 && n5 == 1) {
                txt = "es multiplo de 5";
            }
            if (n2 == 1 && n3 == 1 && n5 != 1) {
                txt = "es multiplo de 2 y de 3";
            }
            if (n2 == 1 && n3 != 1 && n5 == 1) {
                txt = " es multiplo de 2 y de 5";
            }
            if (n2 != 1 && n3 == 1 && n5 == 1) {
                txt = " es multiplo de 3 y de 5";
            }
            if (n2 == 1 && n3 == 1 && n5 == 1) {
                txt = "es multiplo de 2, de 3 y  de 5";
            }
            if (n2 != 1 && n3 != 1 && n5 != 1) {
                txt = " no es multiplo de 2, ni de 3, ni de 5";
            }
            System.out.println(num + txt);
        } else {
            System.out.println(num + " no es multiplo de 2, ni de 3, ni de 5");
        }

        in.close();
    }
}
