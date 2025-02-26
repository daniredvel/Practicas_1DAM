package Hoja_6;

import java.util.Scanner;
public class H06E01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    double num, rt2, rt3, rt4, rt5, rt6;
        System.out.println("Escriba un número decimal");
        num = in.nextDouble();
        rt2 = Math.pow(num, 1.0/2);
        rt3 = Math.pow(num, 1.0/3);
        rt4 = Math.pow(num, 1.0/4);
        rt5 = Math.pow(num, 1.0/5);
        rt6 = Math.pow(num, 1.0/6);
        System.out.println("La raiz cuadrada de: " + num + " es:" + rt2);
        System.out.println("La raiz cubica de: " + num + " es:" + rt3);
        System.out.println("La raiz caurta de: " + num + " es:" + rt4);
        System.out.println("La raiz quinta de: " + num + " es:" + rt5);
        System.out.println("La raiz sexta de: " + num + " es:" + rt6);
        in.close();
    }
}