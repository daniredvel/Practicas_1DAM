package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;

public class H06E08Aleatorios {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num1, num2, menor, mayor, aleatorio;

        System.out.println("Escribe dos números");
        num1=in.nextInt();
        num2=in.nextInt();
        //colocamos el menor y el mayor en orden
        menor=Math.min(num1, num2);
        mayor=Math.max(num1, num2);
        aleatorio= (int)(Math.random()*(mayor-menor+1)+menor);
        System.out.println(aleatorio);

    }

}
