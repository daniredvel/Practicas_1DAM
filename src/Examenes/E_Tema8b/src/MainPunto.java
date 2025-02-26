package Examenes.E_Tema8b.src;

import java.io.File;
import java.util.Scanner;

public class MainPunto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double distancia=Double.MAX_VALUE;
        File fichero = new File("puntos 1.dat");
        try {
            System.out.println("Indica la cordenada X:");
            String x = in.nextLine();
            System.out.println("Indica la cordenada Y:");
            String y = in.nextLine();
            Punto p = new Punto(Integer.parseInt(x),Integer.parseInt(y));

            System.out.println("En el archivo, el punto más cercano es: ("+ UtilPuntos.distancia(p,fichero).getX()+", "+ UtilPuntos.distancia(p,fichero).getY()+")");


        }catch (NumberFormatException nfe){
            System.out.println("Las coordenadas deben ser numeros");
        }
        in.close();

    }
}
