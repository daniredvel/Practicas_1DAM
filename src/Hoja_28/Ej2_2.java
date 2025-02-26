package Hoja_28;

import java.io.*;
import java.util.Scanner;
public class Ej2_2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Indica el archivo que quieras abrir");
            Scanner in = new Scanner(new File(teclado.nextLine()));
            System.out.println("Indica el nombre del archivo de destino");
            PrintWriter out = new PrintWriter(teclado.nextLine());
            while (in.hasNext()) out.println(in.nextLine());
            out.close(); in.close(); teclado.close();
        } catch (FileNotFoundException fnf) { System.out.println("Error al leer el archivo");
        } catch (Exception e) { System.out.println("Error");}
    }
}