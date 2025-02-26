package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;
public class H06E05Mayus {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char letra,  mayus;

        System.out.println("Escribe una letra minúscula");
        letra = in.nextLine().charAt(0);
        if(letra >= 'a' && letra <= 'z') {
            mayus = (char) (letra - ('a' - 'A'));
            System.out.println("La letra en mayúscula es " + mayus);
        }
        else{
            System.out.println("No es una letra minúscula");
        }
        in.close();
    }
}
