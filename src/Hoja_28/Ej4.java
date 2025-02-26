package Hoja_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ej4 {
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            String ruta;
            String texto;
            String lectura;
            boolean txtEncontrado = false;
            try {
                System.out.println("Indica el archivo");
                ruta = teclado.nextLine();
                //Leemos la ruta del archivo
                File archivo = new File(ruta);
                //Creamos un objeto file que recoga el archivo indicado
                Scanner in = new Scanner(archivo);
                //Creamos un escaner para leer el archivo
                System.out.println("Indica el texto");
                texto = teclado.nextLine();
                //texto a buscar
                int cont=0;
                ArrayList <String> lineasEncontradas = new ArrayList<>();
                do {
                    cont++;
                    lectura=in.nextLine();
                    if (lectura.indexOf(texto)> -1) {
                    //if (lectura.contains(texto)) {
                        lineasEncontradas.add(lectura+" "+cont);
                    }
                    //Si no se ha encontrado se indica

                }while (in.hasNext()&&!txtEncontrado);

                if (Ej4.conver(lineasEncontradas)!=null) System.out.println(Ej4.conver(lineasEncontradas));
                else System.out.println("No se han encontrado textos coincidentes");

                in.close();
            } catch (FileNotFoundException fnf){
                System.out.println("Archivo no encontrado");
            } catch (NoSuchElementException nse){
                System.out.println("Archivo vacio");
            }
            catch (Exception e){
                System.out.println("Error");
            }

            teclado.close();
        }


    public static String conver(ArrayList<String> lista) {
            String lineas=null;
            if (!lista.isEmpty()){
                lineas="";
                for (String s : lista) {
                    lineas+=s+"\n";
                }
            }
        return lineas;
    }
}


