package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;

public class H07E09Cifras {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;

        System.out.println("Escribe un  número positivo");
        numero = in.nextInt();
        while(numero > 0){
            System.out.println(numero % 10); //cogemos la última cifra y la escribimos
            numero /= 10; // quitamos esa cifra al número
        }


        in.close();
    }
}
