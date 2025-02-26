package Hoja_31;

import java.io.File;
import java.io.RandomAccessFile;

public class Pruebas {
    public static void main(String[] args) {
       File f = new File("movimiento.bin");
       try {
           RandomAccessFile raf = new RandomAccessFile(f,"rw");
       } catch (Exception e){
           System.out.println("Error");
       }

    }
}
