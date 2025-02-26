package Hoja_8;

import java.util.Scanner;

public class H08E04 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int num1, num2;
            System.out.println("Escriba la altura");
            num1=in.nextInt();
            System.out.println("Escriba el ancho");
            num2=in.nextInt();
            int j = 0;

            for(int num = num1; num != j; ++j) {
                System.out.print("\n");

                for(int i = 1; i != num2 + 1; ++i) {
                    System.out.print(" * " );
                }
            }

            in.close();
        }
    }


