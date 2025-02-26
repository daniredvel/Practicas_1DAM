package Hoja_3;

import java.util.Scanner;
public class H03E07 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num1, num2, num3;
        System.out.println("Escriba 3 números");
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        boolean orden = (num1 >= num2)&(num2 >= num3);
        System.out.println(orden);
        in.close();
    }
}
