package Ejercicios_Clase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ej2 {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(2024, 10, 9);
        DateTimeFormatter f =
                DateTimeFormatter.ofPattern("d/MM/yyyy");
        DateTimeFormatter f2 =
                DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy");
        DateTimeFormatter f3 =
                f2.withLocale(new Locale("fr","FR"));

        System.out.println( fecha.format(f)  +"\n"+
                            fecha2.format(f) +"\n"+
                            fecha.format(f2) +"\n"+
                            fecha2.format(f2)+"\n"+
                            fecha.format(f3) +"\n"+
                            fecha2.format(f3)
                            );
    }
}
