package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;
public class H06E06Edad {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int dia1,mes1,anyo1,dia2,mes2,anyo2;
        System.out.println("Escribe el día, mes y año de tu nacimiento (separados por espacios)");
        dia1=in.nextInt();
        mes1=in.nextInt();
        anyo1=in.nextInt();
        System.out.println("Escribe el día, mes y año de hoy (separados por espacios)");
        dia2=in.nextInt();
        mes2=in.nextInt();
        anyo2=in.nextInt();

        if(mes1>mes2 || (mes1==mes2 && dia1>dia2)){
            //si el mes de nacimiento es mayor que el mes actual, o si el mes de nacimiento es igual al mes actual y el día de nacimiento es mayor que el día actual
            System.out.println("Tienes " + (anyo2-anyo1-1) + " años");
        }
        else{
            System.out.println("Tienes " + (anyo2-anyo1) + " años");
        }
    }

}
