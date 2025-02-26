package Hoja_1;

public class P01E07Resto {
    public static void main(String[] args) {
        long dinero = 234125;
        long resto;
        long bill500 = dinero/500;
        resto = dinero%500;
        long bill200 = resto/200;
        resto = bill200%200;
        long bill100 = resto/100;
        resto = bill100%100;
        long bill50 = resto/50;
        resto = bill50%50;
        long bill20 = resto/20;
        resto = bill20%20;
        long bill10 = resto/10;
        resto = bill10%10;
        long bill5 = resto/5;
        resto = bill5%5;
        long mnd2 = resto/2;
        resto = mnd2%2;
        long mnd1 = resto;

        System.out.println(dinero + " euros repartidos en billetes son: " + bill500 + " billetes de 500, " + bill200 + " billetes de 200, "
        + bill100 + " billetes de 100, " + bill50 + " billetes de 50, " + bill20 + " billetes de 20, " + bill10 + " billetes de 10, "
        + bill5 + " billetes de 5, " + mnd2 + " monedas de 2, " + mnd1 + " monedas de 1.");  
    }
}
