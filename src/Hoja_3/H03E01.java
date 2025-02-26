package Hoja_3;

import java.util.Scanner;
public class H03E01 {
    public static void main(String[] args) {
             Scanner in = new Scanner(System.in);
       double masa, volumen, densidad;
        System.out.println("Escriba la masa");
        masa = in.nextDouble();
             System.out.println("Escriba el volumen");
        volumen = in.nextDouble();
        densidad = masa/volumen;
        System.out.println("La densidad es " + densidad);
        in.close();
    }
}