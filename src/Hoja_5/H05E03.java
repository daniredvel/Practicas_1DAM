package Hoja_5;

import java.util.Scanner;

public class H05E03 {
    
    public static void main(String[] args){
Scanner in = new Scanner(System.in);
int num1, num2;
System.out.println("Escriba dos números enteros:");
num1=in.nextInt();
num2=in.nextInt();
if(num1>=num2){
    System.out.println(num1);
}
else{
    System.out.println(num2);
}

in.close();
    }
}
