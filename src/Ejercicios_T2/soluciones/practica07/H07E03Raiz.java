package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;
public class H07E03Raiz {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double numero;

        System.out.println("Escribe un número positivo");
        numero = in.nextDouble();
        while(numero<0){
            System.out.println("Ese no es un número positivo, prueba con otro");
            numero = in.nextDouble();
        }
        System.out.println("La raíz cuadrada de "+numero+" es "+Math.sqrt(numero));
    }
}
