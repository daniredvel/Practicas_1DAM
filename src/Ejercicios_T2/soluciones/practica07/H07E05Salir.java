package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;
public class H07E05Salir {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char resp;
        do{
            System.out.println("¿Quieres salir?");
            resp=in.next().charAt(0);
        }while(resp!='s' && resp!='S');
        System.out.println("Al fin saliste");
    }

}
