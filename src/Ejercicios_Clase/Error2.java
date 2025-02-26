package Ejercicios_Clase;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Error2 {
    public static void divide() throws Exception {
        //Throws lanza una excepción que sobrevive a la clase
        //Si la excepción está en el método sobrevive y puede usarse en el programa principal u otras clases
        int n1, n2;
        Scanner in=new Scanner(System.in);
        System.out.println("Vamos a dividir 2 números enteros");
        System.out.println("Introduce el primer número");
        n1 = in.nextInt();
        System.out.println("Introduce el segundo número");
        n2 = in.nextInt();
        System.out.println("El resultado de la división es: " +
                n1 / n2);

    }
    public static void main(String[] args) {
        try{
            divide();
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
}
