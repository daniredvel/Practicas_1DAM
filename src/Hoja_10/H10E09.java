package Hoja_10;

import java.util.Scanner;
public class H10E09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número");
        num = in.nextInt();
        int m=1;
        for (int i = num, k=1; i >= 1 && k <= num; i--, k++) {
            int j=0,p=0,r=1,v=1,n=1;
            while(j!=i) {
                System.out.print(" ");
                j++;
            }
            while(p!=k) {
                System.out.print(n);
                p++;
                n++;
            }

            while(r!=k) {
                System.out.print(m);
                r++;
                m++;
            }
            while(v!=i) {
                System.out.print(" ");
                v++;
            }

            System.out.println();
        }
        in.close();
    }
}
