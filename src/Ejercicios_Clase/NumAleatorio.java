package Ejercicios_Clase;

import java.io.*;
public class NumAleatorio {
    public static void main(String[] args) {
        try{
            File archivo=new File("num.txt");
            PrintWriter out=new PrintWriter(archivo);
            for (int i = 0; i < 1000000; i++) {
              out.println((int)(Math.random()*100+1));
            }
            out.close();
        }catch(FileNotFoundException fnf){
            System.out.println("Error, archivo no leido");
        }
    }
}
