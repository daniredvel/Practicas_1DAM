package Hoja_3;

import java.util.Scanner;
public class H03E05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num, decimal;
        System.out.println("Escribe un número");
        num = in.nextDouble();
        int numEntero = (int) num;
        decimal = num-numEntero;
        double aprox = (decimal >= 0.5)? (numEntero + 1):(numEntero);
        System.out.println(aprox);
        in.close();
    }
}
