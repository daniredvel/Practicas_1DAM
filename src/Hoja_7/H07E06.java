package Hoja_7;

import java.util.Scanner;

public class H07E06 {
    public static void main(String[] args){
             Scanner in = new Scanner(System.in);
        char salida;
        int i;
        i=0;
        do{
            System.out.println("Si quieres salir escriba si, SI o Si \n¿Quieres salir?");
            salida = in.nextLine().charAt(0);
            i++;
        } while(salida != 'S' && salida != 's' && i != 5);
        in.close();
    }
}
