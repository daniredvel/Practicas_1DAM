package Ejercicios_T2.soluciones.practica07;

import java.util.Scanner;

public class H07E08PagoHoras {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        final int PRECIO_NORMAL = 15;
        final int PRECIO_EXTRA = 22;
        int horas, horasNormales,horasExtra, pago;

        System.out.println("Introduce las horas trabajadas");
        horas = in.nextInt();
        horasExtra = (horas>35?horas-35:0);
        horasNormales = horas - horasExtra;
        pago = horasNormales * 15 + horasExtra * 22;
        System.out.println("El pago es de "+pago+" euros");

        in.close();
    }
}
