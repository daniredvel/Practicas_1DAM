package Hoja_1;

public class H01E07 {
    public static void main(String[] args) {
        long dinero = 234125;
        long bill500 = dinero/500;
        long bill200 = (dinero%500)/200;
        long bill100 = ((dinero%500)%200)/100;
        long bill50 = (((dinero%500)%200)%100)/50;
        long bill20 = ((((dinero%500)%200)%100)%50)/20;
        long bill10 = (((((dinero%500)%200)%100)%50)%20)/10;
        long bill5 = ((((((dinero%500)%200)%100)%50)%20)%10)/5;
        long mnd2 = (((((((dinero%500)%200)%100)%50)%20)%10)%5)/2;
        long mnd1 = (((((((dinero%500)%200)%100)%50)%20)%10)%5)%2;

        /*El programa funciona primero diviendo la cantidad de dinero entre el valor del  billete, el siguiente dinero a dividir
        es el resto de la operación anterior encadenandose los restos.
        Podria hacerse de otra manera, convirtiendo el resto de la operación anterior a una variable nueva y usar esa variable
        en la nueva operación evitando asi largas cadenas de restos.
         */

        System.out.println(dinero + " euros repartidos en billetes son: " + bill500 + " billetes de 500, " + bill200 + " billetes de 200, "
        + bill100 + " billetes de 100, " + bill50 + " billetes de 50, " + bill20 + " billetes de 20, " + bill10 + " billetes de 10, "
        + bill5 + " billetes de 5, " + mnd2 + " monedas de 2, " + mnd1 + " monedas de 1.");    
        
            /*Este codigo sirve para tener el numero de billetes individualmente y no seguidos en una frase elavorada
            como el println anterior
            System.out.println(bill500);
            System.out.println(bill200);
            System.out.println(bill100);
            System.out.println(bill50);
            System.out.println(bill20);
            System.out.println(bill10);
            System.out.println(bill5);
            System.out.println(Mnd2);
            System.out.println(Mnd1);
            */
    }
}
