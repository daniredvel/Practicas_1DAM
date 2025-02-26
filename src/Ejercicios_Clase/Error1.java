package Ejercicios_Clase;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Error1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n1, n2;
        boolean error;


        do {
            error=false;
        System.out.println("Vamos a dividir 2 números enteros");
        try {
            System.out.println("Introduce el primer número");
            n1 = in.nextInt();
            System.out.println("Introduce el segundo número");
            n2 = in.nextInt();
            System.out.println("El resultado de la división es: " +
                    n1 / n2);
        } catch (InputMismatchException nfe) {
            System.out.println(
                    "No has introducido 2 números enteros");
            in.nextLine();
            error=true;
        } catch (ArithmeticException ae) {
            System.out.println("No se puede dividir por 0");
            in.nextLine();
            error=true;
        } finally {
            System.out.println("Fin del programa");
        }
        }while (error);
    }
}