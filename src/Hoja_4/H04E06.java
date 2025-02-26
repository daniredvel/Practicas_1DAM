package Hoja_4;

import java.util.Scanner;
public class H04E06 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double salario; 
        int edad;
        boolean descuento;
        System.out.println("Escriba su salario");
        salario = in.nextDouble();
        System.out.println("Escriba su edad");
        edad = in.nextInt();
        descuento = (edad>=60)||(salario<=2000);
        System.out.println(descuento);
    in.close();
    }
}
