package Hoja_3;

import java.util.Scanner;
public class H03E05Casting {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double numero;
        int parteEntera;

        System.out.println("Escriba un número decimal");
        numero = in.nextDouble();
        parteEntera = (int)(numero + 0.5);
        /*Al sumar 0.5 si el numero a redondear tiene una parte decimal de 0,5 
        la parte entera sera un número superior, es decir, redondeada. Por eso al hacer el casting a int
        y quedarse unicamente la parte entera se redondea.
       */
      System.out.println("El número redondeado es: " + parteEntera );
        in.close();
    }
}
