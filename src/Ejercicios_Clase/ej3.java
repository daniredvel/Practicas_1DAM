package Ejercicios_Clase;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ej3 {
    public static void main(String[] args) {
        LocalTime t1 = LocalTime.now();
        LocalTime t2 = LocalTime.of(9,15);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(t1+"\n"+t2);
        System.out.println(t2.plusHours(2));
        System.out.println(t2.format(f));
    }
}
