package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;

public class H05E04MayusMinus {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char caracter;

        System.out.println("Escribe un carácter");
        caracter = in.next().charAt(0);

        if(caracter>='A' && caracter<='Z'){
            System.out.println("Es una letra mayúscula");
        }
        else if(caracter>='a' && caracter<='z'){
            System.out.println("Es una letra minúscula");
        }
        else if(caracter>='0' && caracter<='9'){
            System.out.println("Es un número");
        }
        else{
            System.out.println("No es letra ni número");
        }
        in.close();

    }
}
