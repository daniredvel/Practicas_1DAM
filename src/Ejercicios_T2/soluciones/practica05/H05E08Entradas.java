package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E08Entradas {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int edad;
        char estudiante;
        int precio=5;


        System.out.println("Escribe tu edad");
        edad=in.nextInt();
        in.nextLine();
        System.out.println("Escribe si eres estudiante");
        estudiante=in.nextLine().charAt(0);

        if(edad<12){
            precio=0;
        }
        else if (edad<=16){
            precio=2;
        }
        else if(edad<25){
            precio=3;
        }
        else if(edad>65){
            precio=2;
        }

        if(estudiante=='S' || estudiante=='s'){
            precio = precio / 2;
        }

        System.out.println("Pagas " + precio + " euros");
        in.close();
    }
}