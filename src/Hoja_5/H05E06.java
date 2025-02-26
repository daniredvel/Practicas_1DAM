package Hoja_5;

import java.util.Scanner;
public class H05E06 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int lado1, lado2, lado3;
        System.out.println("Escriba los 3 lados de un triangulo");
        lado1 = in.nextInt();
        lado2 = in.nextInt();
        lado3 = in.nextInt();
        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1){
            if(lado1 == lado2 || lado2 == lado3 || lado1 == lado3){
                if(lado1 == lado2 && lado2 == lado3){
                System.out.println("El triangulo formado es equilatero");
                }
                else {
                    System.out.println("El triangulo formado es isosceles");
                }
            } 
            
            
            if(lado1 != lado2 && lado2 != lado3 && lado1 != lado3){
                System.out.println("El triangulo formado es escaleno");
            }

        } else{
            System.out.println(lado1 + ", " + lado2 + ", "+ lado3 +  " No forman un triangulo");
        }
        in.close();
    }
}
