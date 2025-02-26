package Hoja_3;

import java.util.Scanner;
public class H03E09 {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        double num1, num2, num3;
        System.out.println("Escriba los lados");
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        boolean triangulo = (num1+num2 > num3)&&(num1+num3 > num2)&&(num2+num3 > num1);
        System.out.println(triangulo);
        in.close();
    }
}
