package Hoja_5;

import java.util.Scanner;
public class H05E13 {
    public static void main(String[] args){
        byte opcion;
        double num1, num2;
        Scanner in = new Scanner(System.in);
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Invertir signo");
        System.out.println("");
        System.out.println("");
        System.out.println("Escribe opción:");

        opcion = in.nextByte();

       if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 )
       {
         System.out.println("Escriba dos números:");
         num1 = in.nextDouble();
         num2 = in.nextDouble();
         if(opcion == 1){
            System.out.println(num1 + num2);
         } 
         if(opcion == 2){
            System.out.println(num1 - num2);
         } 
         if(opcion == 3){
            System.out.println(num1 * num2);
         } 
         if(opcion == 4){
            System.out.println(num1 / num2);
         } 
       }
       if(opcion == 5 )
       {
         System.out.println("Escriba un número:");
         num1 = in.nextDouble();
          System.out.println(num1*-1);
        }
        in.close();
    }
}
