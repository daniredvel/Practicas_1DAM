package Hoja_8;

import java.util.Scanner;

public class H08E07 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int num1, num2;
            char ltr; //33 - 254
            System.out.println("Escriba un caracter:");
            ltr=(char) Math.round( Math.random()*255+33); //Caracter ASCII, desde el 33 (!) hasta el 254 (■)
            num1= (int) Math.round( Math.random()*81+1);//altura entre 1 y 80
            num2=(int) Math.round( Math.random()*21+2);;//anchura entre 2 y 20
            int j = 0;
            System.out.println(num1);
            System.out.println(num2);

            for(int num = num1; num != j; ++j) {
                System.out.print("\n");

                for(int i = 1; i != num2 + 1; ++i) {
                    System.out.print(ltr);
                }
            }

            in.close();
        }
    }


