package Hoja_5;

import java.util.Scanner;

public class H05E04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char caracter;
        int A, Z, a, z, num0, num9;
        System.out.println("Escriba un caracter");
        caracter = in.nextLine().charAt(0);
        int simbolo = (int) caracter;
        A = 'A';
        Z = 'Z';
        a = 'a';
        z = 'z';
        num0 = 0;
        num9 = 9;

        if (simbolo > A && simbolo < Z) {
            System.out.println(simbolo + " es una letra mayuscula");
        } else if (simbolo > a && simbolo < z) {
            System.out.println(simbolo + " es una minuscula");
        } else if (simbolo > num0 && simbolo < num9) {
            System.out.println(simbolo + " es un número");
        } else {
            System.out.println(simbolo + " no es un numero, ni una mayuscula, ni una minuscula");
        }

        in.close();
    }
}
