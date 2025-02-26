package Hoja_2;

import java.util.Scanner;
public class H02E09 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Escriba un número entero");
int número = in.nextInt();
boolean num = número>=5;
System.out.println(num);
in.close();
    }
}
