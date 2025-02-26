package Hoja_4;

import java.util.Scanner;
public class H04E04 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num, num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;

        System.out.println("Escribe 10 números");

        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        num4 = in.nextInt();
        num5 = in.nextInt();
        num6 = in.nextInt();
        num7 = in.nextInt();
        num8 = in.nextInt();
        num9 = in.nextInt();
        num10 = in.nextInt();

        num = num1; 

        num = (num>num2)? num:num2;
        num = (num>num3)? num:num3;
        num = (num>num4)? num:num4;
        num = (num>num5)? num:num5;
        num = (num>num6)? num:num6;
        num = (num>num7)? num:num7;
        num = (num>num8)? num:num8;
        num = (num>num9)? num:num9;
        num = (num>num10)? num:num10;

        System.out.println("El número mayor es:" + num);

        in.close();
    }
}
