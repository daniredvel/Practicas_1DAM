package Hoja_2;

import java.util.Scanner;
public class H02E10{
    public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Escriba una letra");
int letra = in.nextLine().charAt(0);
int inicio = 'A';
int ultima = 'Z';
boolean respuesta = (inicio <= letra)&(letra <= ultima);
System.out.println(respuesta);
in.close();
    }
}