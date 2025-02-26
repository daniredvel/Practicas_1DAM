package Hoja_9;

import java.util.Scanner;
public class H09E04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, n;
        System.out.println("Escribe un número:");

        n=1;

        num = in.nextInt();
        for (int i = num; i <= num*20; i=num*n) {
            System.out.print(i + " ");
            n++;
        }


        in.close();
    }
}