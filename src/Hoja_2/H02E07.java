package Hoja_2;

import java.util.Scanner;
public class H02E07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Escriba un número sin decimales de dinero");
        long dinero = in.nextLong();
        long bill500 = dinero/500;
        long bill200 = (dinero%500)/200;
        long bill100 = ((dinero%500)%200)/100;
        long bill50 = (((dinero%500)%200)%100)/50;
        long bill20 = ((((dinero%500)%200)%100)%50)/20;
        long bill10 = (((((dinero%500)%200)%100)%50)%20)/10;
        long bill5 = ((((((dinero%500)%200)%100)%50)%20)%10)/5;
        long mnd2 = (((((((dinero%500)%200)%100)%50)%20)%10)%5)/2;
        long mnd1 = (((((((dinero%500)%200)%100)%50)%20)%10)%5)%2;
        
        System.out.println(dinero + " euros repartidos en billetes son: " + bill500 + " billetes de 500, " + bill200 + " billetes de 200, "
        + bill100 + " billetes de 100, " + bill50 + " billetes de 50, " + bill20 + " billetes de 20, " + bill10 + " billetes de 10, "
        + bill5 + " billetes de 5, " + mnd2 + " monedas de 2, " + mnd1 + " monedas de 1.");  
        in.close();
    }
}
