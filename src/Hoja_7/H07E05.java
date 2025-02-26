package Hoja_7;

import java.util.Scanner;
public class H07E05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char salida;
        do{
            System.out.println("Si quieres salir escriba si, SI o Si \n¿Quieres salir?");
            salida = in.nextLine().charAt(0);
        } while(salida != 'S' && salida != 's');
        in.close();

    }
}
