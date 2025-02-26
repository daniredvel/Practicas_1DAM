package Hoja_7;

import java.util.Scanner;

public class H07E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num;
        do {
            System.out.println("Escriba un número positivo");
            num = in.nextDouble();
        } while (Math.signum(num) == -1);
        System.out.println(Math.sqrt(num));
        in.close();
    }
}
