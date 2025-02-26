package Hoja_6;

import java.util.Scanner;
public class H06E03 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double resultado,x;
        System.out.println("Escriba un valor de x:");
        x = in.nextDouble();
        resultado = (Math.sqrt(x+ (2/(3*(Math.pow(x, 2)))))) / (2-Math.sin(x));
        System.out.println(resultado);
        in.close();
    }
}
