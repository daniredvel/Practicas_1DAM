package Hoja_33.H33E01;
import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Main_V2 {
    public static void main(String[] args) {
        String lectura, errMsg="";

        try {
            System.out.println("Indica la ruta del archivo BMP:");
            Scanner teclado = new Scanner(System.in);

            lectura=teclado.nextLine();
            File archivo = new File(lectura);
            RandomAccessFile ramArchivo = new RandomAccessFile(archivo,"rw");

            if (lectura.endsWith("bmp")){

                char cLetras = (char)(ramArchivo.readByte());
                char cLetras2 = (char)(ramArchivo.readByte());

                if (cLetras=='B'&&cLetras2=='M'){

                    //Lectura del ancho
                    ramArchivo.seek(18);
                    int ancho =ramArchivo.readInt();
                    ancho =Integer.reverseBytes(ancho);

                    //Lectura del alto
                    int alto =ramArchivo.readInt();
                    alto =Integer.reverseBytes(alto);
                    System.out.println("Ancho: "+ancho+" px. Alto: "+ alto+" px.");

                }else errMsg="El archivo debe de ser Windows BitMap (\"BMP\")";

            } else errMsg="El archivo debe de ser Windows BitMap (\"BMP\")";

            System.out.print(errMsg.isEmpty() ? "":errMsg);

            teclado.close();

        }catch (EOFException eofe){
            eofe.printStackTrace();
            System.out.println("El archivo debe de ser Windows BitMap (\"BMP\")");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al leer el archivo");
        }
    }
}
