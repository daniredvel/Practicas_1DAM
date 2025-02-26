package Hoja_29;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UtilEj2 {
    // Función para contar ocurrencias de una palabra en un archivo
    public static int contar(String palabra, File archivo) {
        int cont = 0;
        try {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(linea, " ,.;:-?!¡¿()[]{}\"");
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken().toLowerCase();
                    if (token.equals(palabra)) {
                        cont++;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
        return cont;
    }
}
