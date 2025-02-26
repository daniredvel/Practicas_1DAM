package Ejercicios_Clase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ej4 {
    public static void main(String[] args) {
        LocalDateTime dt =LocalDateTime.now();
        LocalDateTime dt2 =LocalDateTime.of(2023,3,8,9,15,4);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy 'a las' kk:mm:ss");
        System.out.println( dt+"\n"+
                            dt2+"\n"+
                            dt2.plusHours(2)+"\n"+
                            dt2.plusMonths(3)+"\n"+
                            dt2.format(f)
                            );
    }
}
