package Hoja_33.H33E01;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String lectura;

        try {
            System.out.println("Indica la ruta del archivo BMP:");
            Scanner teclado = new Scanner(System.in);

            lectura=teclado.nextLine();
            File archivo = new File(lectura);
            RandomAccessFile ramArchivo = new RandomAccessFile(archivo,"rw");

            //Lectura del alto
            ramArchivo.seek(18);
            int ancho =ramArchivo.readInt();
            ancho =Integer.reverseBytes(ancho);


            //Lectura del alto
            ramArchivo.seek(22);
            int alto =ramArchivo.readInt();
            alto =Integer.reverseBytes(alto);
            System.out.println("Ancho: "+ancho+" px. Alto: "+ alto+" px.");

            teclado.close();
        }catch (Exception e){
            System.out.println("Error al leer el archivo");
        }
    }
}
