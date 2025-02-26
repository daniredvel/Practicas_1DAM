package Hoja_4;

import java.util.Scanner;
public class H04E03 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
        int cont = 0;

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

        cont = (num1%2==0?cont+1:cont);
        cont = (num2%2==0?cont+1:cont);
        cont = (num3%2==0?cont+1:cont);
        cont = (num4%2==0?cont+1:cont);
        cont = (num5%2==0?cont+1:cont);
        cont = (num6%2==0?cont+1:cont);
        cont = (num6%2==0?cont+1:cont);
        cont = (num7%2==0?cont+1:cont);
        cont = (num8%2==0?cont+1:cont);
        cont = (num9%2==0?cont+1:cont);
        cont = (num10%2==0?cont+1:cont);

        System.out.println("Hay " + cont + " números pares" );

        in.close();
    }
}