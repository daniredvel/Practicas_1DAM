package Ejercicios_Clase;

import java.time.LocalDate;

public class ej1 {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(2024, 10, 9);

        System.out.println(fecha);
        System.out.println(fecha2);

        System.out.println(fecha2.plusMonths(2));

        System.out.println(fecha.getDayOfYear());

        if (fecha.isLeapYear())
             System.out.println("Es bisiesto");
        else System.out.println("No es bisiesto");
    }
}
