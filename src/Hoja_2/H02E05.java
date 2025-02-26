package Hoja_2;

import java.util.Scanner; //Importación de la clase scanner
public class H02E05 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in); //Declaración del escáner
long grados, vueltas, gradosFinal; //Declaración de las variables
System.out.println("Introduzca el número de grados"); //Solicitud al usuario
grados = in.nextLong(); //Respuesta del cliente
vueltas = grados/360; //Calculo de las vueltas
gradosFinal = grados%360; //Calculo del numero de grados restantes de la última vuelta
System.out.println(grados + " grados son " + vueltas + " vueltas y en la  última vuelta han habido " + gradosFinal + " grados");
//Respuesta final
in.close(); //Cierre del escáner
    }
}

