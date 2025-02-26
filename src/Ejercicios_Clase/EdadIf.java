package Ejercicios_Clase;

import java.util.Scanner;
public class EdadIf {
    public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("¿Cual es tu edad?");
byte edad;
final byte EDAD_MINIMA;
EDAD_MINIMA = 16;
edad = in.nextByte();
if(edad >= EDAD_MINIMA){
    System.out.println("Bienvenido a la discoteca");
}
else{
    System.out.println("Adios, te esperamos en " + (EDAD_MINIMA-edad) + " años");
}
in.close();
    }
}
