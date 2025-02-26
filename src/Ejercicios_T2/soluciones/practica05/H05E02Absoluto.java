package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E02Absoluto {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;

        System.out.println("Escribe un número");
        numero=in.nextInt();
        if(numero<0){
            System.out.println("El valor absoluto de "+numero+" es "+(-numero));
        }
        else{
            System.out.println("El valor absoluto de "+numero+" es "+numero);
        }
        in.close();
    }
}
