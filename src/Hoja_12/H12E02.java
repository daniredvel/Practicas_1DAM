package Hoja_12;

import java.util.Scanner;

public class H12E02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int grado, vuelta;
        grado=0;
        vuelta=0;
        do {
            System.out.println("Escriba el tamaño del giro:");
            grado=in.nextInt();
            vuelta+=grado;
        }while (grado!=0);
        System.out.println("Resultado: "+vuelta/360+" vueltas y "+(vuelta-((vuelta/360)*360))+" grados");
        in.close();
    }
}
