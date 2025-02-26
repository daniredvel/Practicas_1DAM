package Hoja_6;

import java.util.Scanner;

public class H06E06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Fecha de hoy
        int diaH, mesH, añoH;
        // Fecha de nacimiento
        int diaN, mesN, añoN;
        // Calcular la edad
        int edad;
        System.out.println("Escriba su fecha de nacimiento:");
        diaN = in.nextInt();
        mesN = in.nextInt();
        añoN = in.nextInt();
        System.out.println("Escriba la fecha de hoy:");
        diaH = in.nextInt();
        mesH = in.nextInt();
        añoH = in.nextInt();
        if (mesN == mesH) {
            if (diaN <= diaH) {
                edad = añoH - añoN;
            } else {
                edad = (añoH - añoN) - 1;
            }
        } else if (mesH <= mesN) {
            edad = (añoH - añoN) - 1;

        } else {
            edad = añoH - añoN;
        }
        System.out.println("Tu edad es: " + edad + " años");
        in.close();
    }
}
