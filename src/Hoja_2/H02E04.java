package Hoja_2;

import java.util.Scanner; //Importación de la clase scanner
public class H02E04 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in); //Declaración del escáner
System.out.println("Introduzca un valor de x"); //Solicitud al usuario
double x, resultado; //Declaración de variables
x = in.nextDouble(); //Respuesta del usuario
resultado = ((x*x*x)/((3+x)*(3+x))) + (5* (1/(9*x))); //Ecuación en función de x
System.out.println("El resultado de la ecuación para x = " + x + " es " + resultado); //Respuesta final
in.close(); //Cierre del escáner
    }
}
