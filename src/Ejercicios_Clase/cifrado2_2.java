package Ejercicios_Clase;

import java.util.Scanner;

public class cifrado2_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        int clave, num, ltr1, ltr2, ltr3, ltr4, ltr5, ltr1cifrada, ltr2cifrada, ltr3cifrada, ltr4cifrada, ltr5cifrada,
                num1, num2, num3, num4, num5;
        char letra1, letra2, letra3, letra4, letra5;
        System.out.println("Escribe un texto de 5 letras");
        texto = in.nextLine();
        System.out.println("Escribe una clave");
        clave = in.nextInt();

        // A traves del charAt obtener cada caracter de un texto indicando su posición
        // comenzando en el 0
        ltr1 = texto.charAt(0);
        ltr2 = texto.charAt(1);
        ltr3 = texto.charAt(2);
        ltr4 = texto.charAt(3);
        ltr5 = texto.charAt(4);

        num1 = clave / 10000;
        num = num1 * 10;
        num2 = (clave / 1000) - (num);
        num = num * 10 + num2 * 10;
        num3 = (clave / 100) - (num);
        num = num * 10 + num3 * 10;
        num4 = (clave / 10) - (num);
        num = num * 10 + num4 * 10;
        num5 = (clave) - (num);

        /*
         * Operaciones realizadas a traves de la variable num
         * num1 = clave/10000;
         * num2 = (clave/1000)-(num1*10);
         * num3 = (clave/100)-(num1*100+num2*10);
         * num4 = (clave/10)-(num1*1000+num2*100+num3*10);
         * num5 = (clave/1)-(num1*10000+num2*1000+num3*100+num4*10);
         */

        // sumar el valor unicode de la letra introducida más la clave
        ltr1cifrada = num1 + ltr1;
        ltr2cifrada = num2 + ltr2;
        ltr3cifrada = num3 + ltr3;
        ltr4cifrada = num4 + ltr4;
        ltr5cifrada = num5 + ltr5;

        // A traves de un casting convertir el nuevo valor unicode a letra
        letra1 = (char) ltr1cifrada;
        letra2 = (char) ltr2cifrada;
        letra3 = (char) ltr3cifrada;
        letra4 = (char) ltr4cifrada;
        letra5 = (char) ltr5cifrada;

        // Escribir el nuevo texto colocando un caracter vacio al comienzo para forzar
        // la conversion del char a letra
        System.out.println("" + letra1 + letra2 + letra3 + letra3 + letra4 + letra5);
        in.close();
    }
}
