package Hoja_9;

import java.util.Scanner;
public class H09E02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, n;
        num = (int) Math.round(Math.random()*101+1);
        System.out.println("¡Adivina!");
        //System.out.println(num);
        do {
            n = in.nextInt();
            if(num == n){
                System.out.println("Correcto");
            } else if (num < n){
                System.out.println("El número es menor");
            } else{
                System.out.println("El número es mayor");
            }

    }while(n != num);
        in.close();
    }
}
