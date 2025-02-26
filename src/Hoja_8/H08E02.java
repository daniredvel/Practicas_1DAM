package Hoja_8;

import java.util.Scanner;

public class H08E02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i,j, num;
        j = 0;

        System.out.println("Escriba un número");
        num = in.nextInt();
        while (num != j) {
            System.out.print("\n");
            i=1;
            while (i != num + 1) {
                System.out.print(" " + i);
                i++;
            }
            j++;
        }
        in.close();

    }
}
