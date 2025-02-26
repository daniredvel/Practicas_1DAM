package Hoja_29;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String lectura, msgArchivo ="primer archivo";
        //msgArchivo sirve para indicar que archivo da error

        try {
            System.out.println("Indica el nombre del primer archivo");
            lectura = teclado.nextLine();
            File archivo1 = new File(lectura);
            Scanner lectura1 = new Scanner(archivo1);
            msgArchivo ="segundo archivo";

            System.out.println("Indica el nombre del segundo archivo");
            lectura = teclado.nextLine();
            File archivo2 = new File(lectura);
            Scanner lectura2 = new Scanner(archivo2);

            boolean continuar=true;
            String comparar1="", comparar2="";
            String msg ="Los archivos son iguales";
            do {
                comparar1=lectura1.nextLine();
                comparar2=lectura2.nextLine();
                
                if (!(lectura1.hasNext()&&lectura2.hasNext())){
                    continuar=false;
                    msg ="Los archivos son diferentes";
                }
                if(!(comparar1.equals(comparar2))){
                    continuar=false;
                    msg ="Los archivos son diferentes";
                }

                System.out.println(msg);
            } while (continuar);

            System.out.println(msg);

            lectura1.close(); lectura2.close();

        } catch (FileNotFoundException fnf){
            System.out.println("El "+ msgArchivo +" no se ha encontrado");
        } catch (NoSuchElementException nse){
            System.out.println("Error al leer el segundo archivo");
        }
        teclado.close();
    }
}
