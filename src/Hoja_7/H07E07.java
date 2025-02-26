package Hoja_7;

import java.util.Scanner;
public class H07E07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,num;
        System.out.println("Escriba un número");
        num = in.nextInt();
        num++;
        n=num-(num-1);
        do{
            System.out.println(n);
            n++;
        }while (num != n);
        n-=2;
        do{
            System.out.println(n);
            n--;
        }while (0 != n);
        in.close();
    }
}


