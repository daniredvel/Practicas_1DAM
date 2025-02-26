package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;

public class H07E07Bucle1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero, cont = 1;
        System.out.println("Introduce un número");
        numero = in.nextInt();
        while(cont <= numero) {
            System.out.print(cont+" ");
            cont++;
        }
        cont = numero - 1;
        while(cont >= 1) {
            System.out.print(cont+" ");
            cont--;
        }
        System.out.println();
        in.close();

    }

}
