package Ejercicios_Clase;

import java.time.Duration;
import java.time.LocalDateTime;

public class ej5 {
    public static void main(String[] args) {
        Duration d = Duration.ofHours(4);
        d=d.plusMinutes(13);
        LocalDateTime dt=LocalDateTime.of(2024,3,2,12,0,0);
        LocalDateTime dt2=LocalDateTime.now();

        Duration d2 = Duration.between(dt,dt2);

        System.out.println( d+"\n"+
                            d.plusHours(3).plusMinutes(12).plusSeconds(30)+"\n"+
                            dt.plusHours(3).plusMinutes(30)+"\n"+
                            d2
                );
    }
}
