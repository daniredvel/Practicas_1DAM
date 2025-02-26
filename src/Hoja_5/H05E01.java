package Hoja_5;

import java.util.Scanner;
public class H05E01{
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Escribe un número entero:");
    int num;
    num = in.nextInt();
    if(num>=0){
        System.out.println("Positivo");
    }
    else{
        System.out.println("Negativo");
    }
    in.close();
    }
}