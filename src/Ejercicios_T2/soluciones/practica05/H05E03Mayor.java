package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;

public class H05E03Mayor {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero1,numero2;

        System.out.println("Escribe dos números");
        numero1=in.nextInt();
        numero2=in.nextInt();
        if(numero1>numero2)
            System.out.println("El mayor es "+numero1);
        else
            System.out.println("El mayor es "+numero2);

    }
}
