package Hoja_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ej5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String ruta;
        String clave;
        String lectura;
        boolean txtEncontrado=false;
        String filaCifrada;
        char [] letras = new char[27];
        letras[0]='A';
        for (int i = 1; i < letras.length; i++) {
            if (i != 14) letras[i]=(char) (letras[i-1]+1);
            else {
                letras[i]='Ñ';
                letras[15]='O';
                i++;
            }
        }

        try {
            System.out.println("Indica el archivo");
            ruta = teclado.nextLine();
            //Leemos la ruta del archivo
            File archivo = new File(ruta);
            //Creamos un objeto file que recoga el archivo indicado
            Scanner lecturaArchivo = new Scanner(archivo);
            //Creamos un escaner para leer el archivo
            boolean errorNum=true;
            boolean salir=true;
            int claveNum=0;

            while (errorNum){
                System.out.println(salir ? "Indica una clave" : "El valor debe ser numerico");
                clave = teclado.nextLine();
                //clave del cifrado
                try {
                    claveNum=Integer.parseInt(clave);
                    errorNum=false;
                } catch (NumberFormatException nf) {
                    salir=false;
                }
            }

            File césarFile = new File("césar.txt");
            PrintWriter césar=new PrintWriter(césarFile);

            while (lecturaArchivo.hasNextLine()) {
                String lecturaBucle=lecturaArchivo.nextLine();
                //Este bucle lee las lineas y continua mientras halla más lineas en el archivo
                StringTokenizer textoParaCifrar = new StringTokenizer(lecturaBucle);
                while (textoParaCifrar.hasMoreTokens()) {
                    String tokenParaCifrar=textoParaCifrar.nextToken();
                    //Almacenamos en la string tokenParaCifrar cada token del string textoParaCifrar
                    for (int i = 0; i < lecturaBucle.length(); i++) {
                        if (tokenParaCifrar.charAt(i) >= 65 && tokenParaCifrar.charAt(i) <= 90) {
                            //Si el if es true significa que es una letra mayuscula
                            boolean mayor=false;
                            //Mayor se encarga de indicar si se ha sobrepasado la lista de letras
                            if (tokenParaCifrar.charAt(i) + claveNum > 90) {
                                mayor = true;

                                /*
                                 * Si el if es true significa que la suma de la clave y la posición del simbolo
                                 * es más que el valor de la Z y por ende hay volver a empezar el abecedario
                                 */

                            }
                                char linea=(char) (tokenParaCifrar.charAt(i) + claveNum);

                            if (!mayor) filaCifrada = "" + (linea);
                            else filaCifrada = "" + (linea-65);
                           césar.println(filaCifrada);

                        }
                    }
                }
            }

            lecturaArchivo.close();
            césar.close();

        } catch (FileNotFoundException fnf){
            System.out.println("Error al leer el archivo");
        } catch (NoSuchElementException nse){
            System.out.println("El archivo esta vacio");
        } catch (Exception e){
            System.out.println("Error");
        }
        teclado.close();
    }
}
