package Hoja_9;

import java.util.Scanner;
public class H09E05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, n, m, i;
        System.out.println("Escribe un número:");
        num = in.nextInt();
        m=1;
        n=1;
        i=0;
    do {
        System.out.println();
        do {
            i=m*n;
            System.out.print(i + " ");
            n++;
        }while(n!=num+1);
        n=1;
        m++;
    }while(m!=num+1);

        in.close();
    }
}