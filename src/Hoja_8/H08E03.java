package Hoja_8;

import java.util.Scanner;
public class H08E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Escriba un número");

        int j = 0;

        for(int num = in.nextInt(); num != j; ++j) {
            System.out.print("\n");

            for(int i = 1; i != num + 1; ++i) {
                System.out.print(" * " );
            }
        }

        in.close();
    }
}
