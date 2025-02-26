package Hoja_2;

import java.util.Scanner; //Importación de la clase scanner
public class H02E03 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in); //Declaracion del escáner
long Unicode; //Declaración de variables
System.out.println("Introduzca un número"); //Solicitud al usuario
Unicode = in.nextInt(); //Respuesta del usuario
char letra = (char) Unicode; //Casting para transformar el codigo UNICODE a su simbolo
System.out.println("El numero introducido en UNICODE corresponde con el simbolo " + letra); //Respuesta final
in.close(); //Cierre del escáner
    }
}
