package Ejercicios_T2.soluciones.practica08;

import java.util.Scanner;
public class H08E01Factorial {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;
        long acumulador = 1;
        System.out.println("Escribe un número entero positivo");
        numero = in.nextInt();
        for(int i=1;i<=numero;i++){
            acumulador *= i;
        }
        System.out.println("El factorial de "+numero+" es "+acumulador);

        in.close();
    }
}
