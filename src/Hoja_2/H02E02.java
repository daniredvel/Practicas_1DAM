package Hoja_2;

import java.util.Scanner; //Importación de la clase scanner
public class H02E02 {
    public static void main(String[] args) {
Scanner in = new Scanner (System.in); //Declaración del escáner
double grados, vueltas, radianes; //Declaración de variables
final double PI = 3.14159265358979323846; //Declaración de PI como constante
System.out.println("Introduce un número de grados"); //Solicitud del número de grados
grados = in.nextDouble(); //El usuario introduce el número de grados
vueltas = grados/360; //Calculo de las vueltas
radianes= vueltas*(2*PI); //Conversión a radianes
System.out.println(grados + " son " + radianes + " radianes"); //Respuesta final
in.close(); //Cierre del escáner
    }
}
