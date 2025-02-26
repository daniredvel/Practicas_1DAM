package Hoja_8;

import java.util.Scanner;
public class H08E09 {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int num;
                System.out.println("Escribe un número:");

                num = in.nextInt();

                for(int i = 1; i<= num; i++ ){
                    for(int j =1; j<= i; j++){
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    System.out.println();
                }
                in.close();
            }
        }





