package Hoja_6;

import java.util.Scanner;
public class H06E09 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char letra;
        double num;
        num = Math.random()*99+30;
        letra = (char) Math.floor(num);
        System.out.println("El número: " + Math.floor(num) + " en ASCII es: " + letra);
        in.close();
    }
}
