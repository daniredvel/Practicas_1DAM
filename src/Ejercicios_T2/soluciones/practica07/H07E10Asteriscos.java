package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;

public class H07E10Asteriscos {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;

        System.out.println("Escribe un  número positivo");
        numero = in.nextInt();

        for(int i=1; i<=numero; i++){
            System.out.print("*");
        }
        System.out.println();


        in.close();
    }
}
