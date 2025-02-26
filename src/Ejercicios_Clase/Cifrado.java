package Ejercicios_Clase;

import java.util.Scanner;

public class Cifrado {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        int clave, ltr1, ltr2, ltr3, ltr4, ltr5, ltr1cifrada, ltr2cifrada, ltr3cifrada, ltr4cifrada, ltr5cifrada;
        char letra1, letra2, letra3, letra4, letra5;
        System.out.println("Escribe un texto de 5 letras");
        texto = in.nextLine();
        System.out.println("Escribe una clave");
        clave = in.nextInt();
        /*
         * El charAt devuelve el valor unicode del caracter que ocupa
         * la posición indicada empezando en el 0
         */
        ltr1 = texto.charAt(0);
        ltr2 = texto.charAt(1);
        ltr3 = texto.charAt(2);
        ltr4 = texto.charAt(3);
        ltr5 = texto.charAt(4);

        ltr1cifrada = ltr1 + clave;
        ltr2cifrada = ltr2 + clave;
        ltr3cifrada = ltr3 + clave;
        ltr4cifrada = ltr4 + clave;
        ltr5cifrada = ltr5 + clave;

        letra1 = (char) ltr1cifrada;
        letra2 = (char) ltr2cifrada;
        letra3 = (char) ltr3cifrada;
        letra4 = (char) ltr4cifrada;
        letra5 = (char) ltr5cifrada;

        System.out.println("" + letra1 + letra2 + letra3 + letra3 + letra4 + letra5);

        in.close();
    }
}