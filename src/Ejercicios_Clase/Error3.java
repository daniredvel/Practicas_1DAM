package Ejercicios_Clase;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Error3 {
    //Throws lanza una excepción que ha causado el programa. Throw lanza una excepción creada por él.
    /*
     * Las propias excepciones lanzan una excepción que almacena la excepción previa
     * de esta manera las excepciones sobreviven a los métodos
     * y con otros métodos como get.Message se diferencian las excepciones
     */
    public static void divide() throws Exception {
        int n1, n2;
        Scanner in=new Scanner(System.in);
        System.out.println("Vamos a dividir 2 números enteros");
        try {
            System.out.println("Introduce el primer número");
            n1 = in.nextInt();
            System.out.println("Introduce el segundo número");
            n2 = in.nextInt();
            System.out.println("El resultado de la división es: "
                    + n1 / n2);

        }
        catch (InputMismatchException nfe) {
            throw new Exception(
                    "No has introducido 2 números enteros");
        }
        catch (ArithmeticException ae) {
            throw new Exception(
                    "No se puede dividir por 0");
        }
    }
    public static void main(String[] args) {
        try{
            divide();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
}