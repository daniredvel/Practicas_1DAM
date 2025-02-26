package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E13Menu {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double numero1,numero2, resultado;
        byte eleccion;

        System.out.println("               MENU");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Invertir signo");
        System.out.println("Escribe su elección:");
        eleccion = in.nextByte();
        if(eleccion<1 || eleccion>5){
            System.out.println("Opción no válida");
        }
        else if(eleccion==5){
            System.out.println("Escribe un número");
            numero1 = in.nextDouble();
            resultado = -numero1;
            System.out.println("El resultado es "+resultado);
        }
        else{
            System.out.println("Escribe dos números");
            numero1 = in.nextDouble();
            numero2 = in.nextDouble();
            if(eleccion==1) resultado = numero1 + numero2;
            else if(eleccion==2) resultado = numero1 - numero2;
            else if(eleccion==3) resultado = numero1 * numero2;
            else resultado = numero1 / numero2;
            System.out.println("El resultado es "+resultado);
        }
        in.close();

    }
}
