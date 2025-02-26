package Hoja_28;

import java.io.*;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String ruta;
        String texto;
        boolean txtEncontrado=false;
        boolean centinela=false;
        try {
            System.out.println("Indica el archivo");
            ruta=teclado.nextLine();
            //Leemos la ruta del archivo
            File archivo= new File(ruta);
            //Creamos un objeto file que recoga el archivo indicado
            Scanner in = new Scanner(archivo);
            //Creamos un escaner para leer el archivo
            System.out.println("Indica el texto");
            texto=teclado.nextLine();
            //texto a buscar
            do {
                if (texto.equals(in.nextLine())) {
                    //Si el texto indicado se ha encontrado, el centinela pasa a verdadero y se muestra el mensaje
                    txtEncontrado=true;
                    System.out.println("Texto encontrado");
                } if
                (!txtEncontrado&&!centinela) {
                    System.out.println("Texto no encontrado");
                    centinela=true;
                    //Gracias a centinela sabemos si ya se ha indicado con anterioridad que el texto no se ha encontrado
                }
                //Si no se ha encontrado se indica

            }while (in.hasNext()&&!txtEncontrado);
                in.close();
        } catch (FileNotFoundException fnf){
            System.out.println("Archivo no encontrado");
        } catch (Exception e){
            System.out.println("Error");
        }

        teclado.close();
    }
}
