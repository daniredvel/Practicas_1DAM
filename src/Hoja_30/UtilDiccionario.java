package Hoja_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UtilDiccionario {
    public static String buscar(String palabraBuscada, File Diccionario){
        String res;
        try {
            Scanner diccionario = new Scanner(Diccionario);
        } catch (FileNotFoundException errorLeerDiccionario){
            return "Diccionario no encontrado";
        }
    }
}
