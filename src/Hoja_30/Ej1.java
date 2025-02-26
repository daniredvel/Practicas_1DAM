package Hoja_30;

import java.util.Scanner;
import java.io.*;

public class Ej1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

            File dic = new File("Spanish.txt");
            String palabraBuscada;
            System.out.println("Indica la palabra a buscar");
            palabraBuscada=teclado.nextLine();

        teclado.close();
    }
}
