package Hoja_28;

import java.util.Scanner;
import java.io.*;

public class Ej1 {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String lectura="";
      try {
          File archivo = new File("volcado.txt");
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
