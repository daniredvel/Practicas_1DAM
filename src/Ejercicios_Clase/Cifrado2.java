package Ejercicios_Clase;

import java.util.Scanner;

public class Cifrado2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto, clave_texto;
        int ltr1, ltr2, ltr3, ltr4, ltr5, ltr1cifrada, ltr2cifrada, ltr3cifrada, ltr4cifrada, ltr5cifrada, num1, num2,
                num3, num4, num5;
        char letra1, letra2, letra3, letra4, letra5;
        System.out.println("Escribe un texto de 5 letras");
        texto = in.nextLine();
        System.out.println("Escribe una clave");
        clave_texto = "" + in.nextInt();

        ltr1 = texto.charAt(0);
        ltr2 = texto.charAt(1);
        ltr3 = texto.charAt(2);
        ltr4 = texto.charAt(3);
        ltr5 = texto.charAt(4);

        num1 = clave_texto.charAt(0);
        num2 = clave_texto.charAt(1);
        num3 = clave_texto.charAt(2);
        num4 = clave_texto.charAt(3);
        num5 = clave_texto.charAt(4);
        
        num1 = num1 - 48;
        num2 = num2 - 48;
        num3 = num3 - 48;
        num4 = num4 - 48;
        num5 = num5 - 48;

        ltr1cifrada = num1 + ltr1;
        ltr2cifrada = num2 + ltr2;
        ltr3cifrada = num3 + ltr3;
        ltr4cifrada = num4 + ltr4;
        ltr5cifrada = num5 + ltr5;

        letra1 = (char) ltr1cifrada;
        letra2 = (char) ltr2cifrada;
        letra3 = (char) ltr3cifrada;
        letra4 = (char) ltr4cifrada;
        letra5 = (char) ltr5cifrada;

        System.out.println("" + letra1 + letra2 + letra3 + letra3 + letra4 + letra5);

        in.close();
    }
}
