package Hoja_3;

import java.util.Scanner;
public class H03E06 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Double num, decimal;
        System.out.println("Escribe un número");
        num = in.nextDouble();
        double division = num/2;
        int entero = (int)division;
        decimal = division - entero;
        boolean par = decimal == 0.0;
        System.out.println(par);
        in.close();
    }
}
