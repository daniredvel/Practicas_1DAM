package Hoja_2;

import java.util.Scanner; //Importación de la clase scanner
public class H02E01 {
    public static void main (String[] args) {
Scanner in = new Scanner(System.in);//Declaración del scanner
double salario, interes, interesFinal;//Declaración de variables
System.out.println("introduce el salario"); //El dispositivo solicita el salario
salario = in.nextDouble(); // El usuario introduce su salario
System.out.println("introduce el interes");//El dispositivo solicita el interes
interes = in.nextDouble(); //El usuario introduce el interes
interesFinal = salario*interes; //Calculo del interes final
System.out.println("El interes final es de " + interesFinal);//El dispositivo devuelve al usuario el interes final
in.close();//Cierre del escaner
    }
}