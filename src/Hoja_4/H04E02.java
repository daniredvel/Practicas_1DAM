package Hoja_4;

import java.util.Scanner;
public class H04E02 {
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    double  num1, num2, num3, num4, num5, numMedia;
    System.out.println("Introduzca 5 números");
    num1 = in.nextDouble();
    num2 = in.nextDouble();
    num3 = in.nextDouble();
    num4 = in.nextDouble();    
    num5 = in.nextDouble();
    numMedia = (num1 + num2 + num3 + num4 + num5)/5;
    System.out.println("La media es de " + numMedia);
    in.close();
    }
}
