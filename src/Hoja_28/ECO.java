package Hoja_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ECO {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Scanner teclado = new Scanner(System.in);
            String lectura="";
            try {
                System.out.println("Indica la ruta del archivo");
                String ruta=teclado.nextLine();
                File archivo = new File(ruta+".txt");
                PrintWriter out = new PrintWriter(archivo);

                System.out.println("Escribe una linea");
                lectura= in.nextLine();
                while (!lectura.trim().equals("")){
                    out.println(lectura);

                    System.out.println("Escribe una linea");
                    lectura= in.nextLine();
                }
                out.close();
            } catch (FileNotFoundException fnf){
                System.out.println("Error al leer el archivo");
            } catch (Exception e){
                System.out.println("Error");
            }

            in.close();
        }
    }