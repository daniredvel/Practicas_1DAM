package Examenes.E_Tema8b.src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilCitas {
    public static String buscar(String autor, File fichero){
        String res="No se encontraron citas del autor", lectura;
       try {
        Scanner in = new Scanner(fichero);

              while (in.hasNext()){
                  lectura=in.nextLine();
                  if (lectura.equalsIgnoreCase(autor)){
                      res=in.nextLine();
                  }
              }
              in.close();

       } catch (FileNotFoundException fnfe){
           res = "error al leer el archivo";
       }
          return res;
    }

    public static String citaAleatoria (File fichero){
        String res="No se encontraron citas del autor", lectura;
        try {
            Scanner in = new Scanner(fichero);
            Scanner in2 = new Scanner(fichero);
            int cont=0;
            while (in.hasNext()){
                cont++;
                in.nextLine();
            }
            String[] sLista = new String[--cont];

            for (int i = 0; i < cont; i++) {
                sLista[i]=in2.nextLine();
            }

            int n;
            do {
                n = (int) (Math.random()*cont+1);
            } while (n%2!=0);

            res=sLista[n]+"\n"+sLista[n+1];


            in.close();
        } catch (FileNotFoundException | ClassCastException fnfe) {
            res = "error al leer el archivo";
            fnfe.printStackTrace();
        }
        return res;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
