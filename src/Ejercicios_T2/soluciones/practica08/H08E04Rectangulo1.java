package Ejercicios_T2.soluciones.practica08;

import java.util.Scanner;

public class H08E04Rectangulo1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int ancho,alto;

        System.out.println("Escribe la anchura del rectángulo");
        ancho = in.nextInt();
        System.out.println("Escribe la altura del rectángulo");
        alto = in.nextInt();

        for(int i = 1; i <= alto; i++){
            for (int j = 1; j <= ancho; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }
}
