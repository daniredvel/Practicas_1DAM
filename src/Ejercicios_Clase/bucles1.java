package Ejercicios_Clase;

import java.util.Scanner;
public class bucles1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num;
        num=0;
        //Pide números hasta que se escriba uno negativo
        //Bucle con centinela, El Bucle se repite hasta que el centinela sea falso, no se sabe cuantas veces se va a repetir
        while (num>=0){ 
            System.out.println("escribe un número, negativo para salir");
            num = in.nextInt();
        }
        in.close();
    }
}
