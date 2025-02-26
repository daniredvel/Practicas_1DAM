package Proyecto_reservas.vistas;
import java.util.Scanner;
public class Utiles {
    public static void pausa(Scanner teclado) {
        System.out.println("Pulsa Intro para continuar");
        teclado.nextLine();
        for (int i = 1; i <=80 ; i++) {
            System.out.println();
        }
    }
}
