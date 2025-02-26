package Hoja_4;

import java.util.Scanner;
public class H04E01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Double coordenadaX1, coordenadaY1, PuntoMedioX, PuntoMedioY, coordenadaX2, coordenadaY2;
        System.out.println("Introduzca la primera coordenada x");
        coordenadaX1 = in.nextDouble();
        System.out.println("Introduzca la primera coordenada y");
        coordenadaY1 = in.nextDouble();
        System.out.println("Introduzca la segunda coordenada x");
        coordenadaX2 = in.nextDouble();
        System.out.println("Introduzca la segunda coordenada y");
        coordenadaY2 = in.nextDouble();
        PuntoMedioX = (coordenadaX2 + coordenadaX1)/2;
        PuntoMedioY = (coordenadaY2 + coordenadaY1)/2;
        System.out.println("El punto medio entre (" + coordenadaX1 + "," + coordenadaY1 
        + ") y (" + coordenadaX2 + "," + coordenadaY2 + ") es (" + PuntoMedioX + "," + PuntoMedioY + ")"  );
in.close();
    }
}