package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E05Igualitos {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero1,numero2;
        double numero3, numero4;

        System.out.println("Escribe dos números enteros");
        numero1=in.nextInt();
        numero2=in.nextInt();

        System.out.println("Escribe dos números decimales"  );
        numero3=in.nextDouble();
        numero4=in.nextDouble();

        if(numero1+numero2 == numero3+numero4){
            System.out.println("Igualitos");
        }
        else{
            System.out.println("Diferentes");
        }
        in.close();
    }
}
