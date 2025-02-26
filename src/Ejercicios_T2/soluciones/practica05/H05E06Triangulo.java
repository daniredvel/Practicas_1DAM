package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E06Triangulo {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int lado1,lado2,lado3;

        System.out.println("Escribe los tres lados de un triángulo");
        lado1=in.nextInt();
        lado2=in.nextInt();
        lado3=in.nextInt();
        if(lado1+lado2>lado3 && lado2+lado3>lado1 && lado1+lado3>lado2){
            System.out.println("Es un triánguloº");
            if(lado1==lado2 && lado2==lado3){
                System.out.println("Es equilátero");
            }
            else if(lado1==lado2 || lado2==lado3 || lado1==lado3){
                System.out.println("Es isósceles");
            }
            else{
                System.out.println("Es escaleno");
            }
        }
        else{
            System.out.println("No es triángulo");
        }
        in.close();
    }
}