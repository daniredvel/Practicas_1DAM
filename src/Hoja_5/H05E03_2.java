package Hoja_5;

import java.util.Scanner;
public class H05E03_2 {
    public static void main(String[] args){
Scanner in = new Scanner(System.in);
int num1, num2;
System.out.println("Escriba dos números enteros:");
num1=in.nextInt();
num2=in.nextInt();
if(num1>num2){
    System.out.println(num1 + " es mayor que " + num2);
}
else if (num2>num1) {
    System.out.println(num2 + " es mayor que " + num1);
}
else if (num1 == num2) {
    System.out.println(num1 + " es igual a " + num2);
}
in.close();
    }
}
