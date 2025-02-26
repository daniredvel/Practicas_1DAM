package Hoja_6;

import java.util.Scanner;
public class H06E08 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double num, num1, num2, distancia, inicio;
        System.out.println("Escriba dos números enteros:");
        num1 = in.nextInt();
        num2 = in.nextInt();
        distancia = Math.abs(num1-num2);
        inicio = Math.min(num1, num2);
        num =  Math.random()*distancia+inicio;
        System.out.println(num);
        in.close();
    }
}
