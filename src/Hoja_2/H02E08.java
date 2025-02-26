package Hoja_2;

import java.util.Scanner;
public class H02E08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num1, num, num3;
        System.out.println("Escribe un número de 3 cifras");
        num = in.nextInt();
        num1 = num/100;
        int num1a = (int) num1;
     double num2 = num1 - num1a;
     int num2a = (int) (num2*10); 
        int numA = (int) num;
        num3 = numA/10;
        num3 = num3*10;
        double num3a = num-num3;
        int num3f = (int) num3a;
      System.out.println(num1a);
      System.out.println(num2a);
      System.out.println(num3f);

        in.close();
    }
}
