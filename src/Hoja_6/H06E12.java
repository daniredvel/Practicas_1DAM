package Hoja_6;

import java.util.Scanner;
public class H06E12 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double num1, num2, resultado;
    num1 = Math.floor(Math.random()*10+1);
    num2 = Math.floor(Math.random()*10+1);
    System.out.println("Dime cuamto es " + num1 + " por " + num2);
    resultado = in.nextDouble();
    if(resultado == num1 * num2){
        System.out.println("¡Correcto!");
    } else {
        System.out.println("Incorrecto");
    }
    in.close();  
    }
}
