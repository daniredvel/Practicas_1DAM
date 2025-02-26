package Hoja_5;

import java.util.Scanner;
public class H05E02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Escribe un número entero:");
    int num;
    num = in.nextInt();
    if(num>=0){
        System.out.println(num + "Es positivo");
    }
    else{
        System.out.println("El valor absoluto de " + num + " es:" + -1*num);
    }
        in.close();
    }
}
