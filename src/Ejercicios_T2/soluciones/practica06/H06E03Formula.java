package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;
public class H06E03Formula {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double x,res;

        System.out.println("Escribe un número decimal");
        x=in.nextDouble();

        res = Math.sqrt((x+(2/(3*x*x))))/(2-Math.sin(x));

        System.out.println("El resultado es " + res);


    }
}
