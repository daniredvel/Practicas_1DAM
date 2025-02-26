package Ejercicios_T2.soluciones.practica08;

import java.util.Scanner;

public class H08E08Bucle3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;
        System.out.println("Escribe un número entero positivo");
        numero = in.nextInt();

        for(int i = 1; i <= numero; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
