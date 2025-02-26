package Hoja_29;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ej2 {
    public static void main(String[] args) {
        // TreeSet para almacenar las palabras ordenadas alfabéticamente y eliminar duplicados
        TreeSet<String> palabrasOrdenadas = new TreeSet<>();

        try {
            // Cambia "archivo.txt" con el nombre de tu archivo
            File archivo = new File("archivo.txt");
            Scanner scanner = new Scanner(archivo);

            // Itera sobre cada línea del archivo
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                // Divide la línea en palabras usando StringTokenizer con varios delimitadores
                StringTokenizer tokenizer = new StringTokenizer(linea, " ,.;:-?!¡¿()[]{}\"");
                while (tokenizer.hasMoreTokens()) {
                    String palabra = tokenizer.nextToken().toLowerCase();
                    palabrasOrdenadas.add(palabra); // Agrega la palabra al TreeSet
                }
            }
            scanner.close();
        } catch (FileNotFoundException nfe)  {
            System.out.println("Archivo no encontrado");
        }

        // Imprimir las palabras encontradas y sus conteos
        System.out.println("Palabras encontradas y sus conteos:");
        for (String palabra : palabrasOrdenadas) {
            int palabrasContador = UtilEj2.contar(palabra, new File("archivo.txt"));
            System.out.println(palabra + ": " + palabrasContador);
        }
    }
}
