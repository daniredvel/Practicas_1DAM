package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;
public class H06E01Raices {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double numero;

        System.out.println("Escribe un número decimal");
        numero=in.nextDouble();

        System.out.println("La raíz cuadrada es " + Math.sqrt(numero));
        System.out.println("La raíz cúbica es " + Math.cbrt(numero));
        System.out.println("La raíz cuarta es " + Math.pow(numero, 1.0/4));
        System.out.println("La raíz quinta es " + Math.pow(numero, 1.0/5));
        System.out.println("La raíz sexta es " + Math.pow(numero, 1.0/6));
    }
}
