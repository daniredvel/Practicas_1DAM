package Hoja_7;

import java.util.Scanner;

public class H07E09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, ncifras, n, n1;
        System.out.println("Escriba un número");
        num = in.nextInt();
        ncifras = 0;
        n1=num;
        if (num > 0) {

            while (n1 > 9) {
                n1 = n1 / 10;
                ncifras++;
            }
            ncifras++;
            n = 0;
            int index;
            index = 1;

            while (num / (Math.pow(10,(ncifras-1))) != n) {

                n = (int)(num / (Math.pow(num,(ncifras-index))));
                System.out.println(n);
                index++;
            }

        } else {
            System.out.println("Escriba un número positivo");
        }
        in.close();
    }
}
