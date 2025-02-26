package Hoja_28;

import java.util.Scanner;
import java.io.*;
public class Ej2 {
    public static void main(String[] args) {
        String ruta="volcado.txt";
        String lectura="";
        try {
            File archivo = new File(ruta);
            //Crea un objeto file con un archivo existente indicado la ruta de este en la declaración del String
            File archivo2 = new File("archivo2");
            //Crea un nuevo archivo llamado archivo2
            Scanner in = new Scanner(archivo);
            //El escaner lee el primer archivo
            PrintWriter out = new PrintWriter(archivo2);
            //Se escribe en el segundo
            while (in.hasNext()){
                //Mientras el escaner tenga más lineas que leer continuara el bucle
                out.println(in.nextLine());
                //el archivo2 recoge la sigiente linea del escaner (archivo)
            }
            out.close();
            in.close();
        } catch (FileNotFoundException fnf){
            System.out.println("Error al leer el archivo");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
