package Ejercicios_Clase;

import java.util.Scanner;

public class bucles2 {
     public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num;
        //Pide números hasta que se escriba uno negativo
        //Bucle con contador
        do { 
            System.out.println("escribe un número, negativo para salir");
            num = in.nextInt();
        } while (num>=0);
        in.close();
    }
}
