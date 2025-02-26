package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E07Primos {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;

        System.out.println("Escribe un número del 1 al 10");
        numero=in.nextInt();

        if(numero<1 || numero>10){
            System.out.println("El número no está entre 1 y 10");
        }
        else if(numero==1 || numero==2 || numero==3 || numero==5 || numero==7){
            System.out.println("El número es primo");
        }
        else {
            System.out.println("El número no es primo");
        }
        in.close();
    }
}
