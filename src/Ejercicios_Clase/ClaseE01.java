package Ejercicios_Clase;

import java.util.Scanner; //Importat Scanner
import java.util.Locale; //Importar Locale
public class ClaseE01 {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.useLocale(Locale.US);//Configuración estadounidense
    double num1, num2; //num1 almacena el número 1. num2 almacena el número 2.
    System.out.println("Escribe dos números");
    num1 = in.nextDouble(); //Leer el número 1
    num2 = in.nextDouble(); // Leer el número 2
    double suma = num1 + num2; //Suma
    System.out.println("la suma es " + suma); //Texto impreso en pantalla con la suma final
    in.close(); //cerrar el escáner
}
    
}
