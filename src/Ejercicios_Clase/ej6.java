package Ejercicios_Clase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class ej6 {
    public static void main(String[] args) {
        Period p = Period.of(0,4,12);
        LocalDate d = LocalDate.now();
        LocalDate d2 = LocalDate.of(2015,1,4);
        Period p2 = Period.between(d,d2);

        System.out.println( p.plusMonths(4)+"\n"+
                            p.plusDays(21)+"\n"+
                            p2);
    }
}
