package Hoja_12;

import java.util.Scanner;

public class H12E04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número:");
        num=in.nextInt();
        for(int n1=0, n2=num; n1<=num; n1++, n2--){
            System.out.println(n1+" "+n2);
        }
            in.close();
    }
}
