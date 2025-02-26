package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;

public class H07E06Salir2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char resp;
        int cont=1;
        do{
            System.out.println("¿Quieres salir?");
            resp=in.next().charAt(0);
            cont++;
        }while(resp!='s' && resp!='S' && cont<=5);
        System.out.println("Al fin saliste");
    }

}
