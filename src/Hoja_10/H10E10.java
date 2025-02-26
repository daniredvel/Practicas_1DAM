package Hoja_10;

import java.util.Scanner;
public class H10E10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número");
        num = in.nextInt();
        for (int i = num, k=1,m=1; i >= 1 && k <= num; i--, k++) {
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
                m--;
                m+=2;
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
