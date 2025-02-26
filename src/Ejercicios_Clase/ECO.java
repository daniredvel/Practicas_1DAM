package Ejercicios_Clase;

import java.io.*;
import java.util.Scanner;

public class ECO {
    public static void main(String[] args) {
        String lectura="";
        boolean salir;
        Scanner in = new Scanner(System.in);
        try{
            File archivo = new File("datos.txt");
            PrintWriter out=new PrintWriter(archivo);
            do {
                salir=false;
                if (!(lectura.equalsIgnoreCase("FIN"))){
                    System.out.println("Indica el texto");
                    lectura= in.nextLine();
                    if (!lectura.equalsIgnoreCase("FIN")) out.println(lectura);
                } else {
                    out.close();
                    salir=true;
                }
            } while (!salir);
        } catch (FileNotFoundException fnf){
            System.out.println("Archivo no leido");
        }
        /*
        * catch (IOException ioe){
            System.out.println("Error al manipular el archivo");
        }
        * El IDE indica que la excepción ya ha sido recogida, sin embargo, si la memoria esta llena da otra excepción
        * */

    }
}
