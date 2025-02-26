package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E12Bisiesto {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int anio;

        System.out.println("Escribe un año");
        anio=in.nextInt();
        if(anio%4==0 && anio%100!=0 || anio%400==0){
            System.out.println("Es bisiesto");
        }
        else{
            System.out.println("No es bisiesto");
        }
        in.close();
    }
}
