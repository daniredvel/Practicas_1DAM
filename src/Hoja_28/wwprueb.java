package Hoja_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class wwprueb {
    public static void main(String[] args) throws FileNotFoundException {


        /*
         * Modificar el ejercicio anterior pero almacenando la clave en un array
         *
         * Añadir una segunda variable al bucle de cifrado que inidique el numero del array de la clave
         *
         * Añadir al bucle una condición final: si el contador 1 aun no ha llegado al limite (tamaño del token)
         * y el segundo ha llegado al final de la clave que vuelva al indice 0 en la siguiente vuelta del bucle
         *
         * Cambiar el archivo que crea de 'césar.txt' a 'augusto.txt'
         */

                Scanner teclado = new Scanner(System.in);
                String ruta;
                String clave;
                String lectura;
                boolean txtEncontrado = false;
                String filaCifrada;
                char[] letras = new char[27];
                letras[0] = 'A';
                for (int i = 1; i < letras.length; i++) {
                    if (i != 14) letras[i] = (char) (letras[i - 1] + 1);
                    else {
                        letras[i] = 'Ñ';
                        letras[15] = 'O';
                        i++;
                    }
                }


                    System.out.println("Indica el archivo");
                    ruta = teclado.nextLine();
                    // Leemos la ruta del archivo
                    File archivo = new File(ruta);
                    // Creamos un objeto file que recoja el archivo indicado
                    Scanner lecturaArchivo = new Scanner(archivo);
                    // Creamos un escáner para leer el archivo
                    boolean errorNum = true;
                    boolean salir = true;
                    int claveNum = 0;

                    while (errorNum) {
                        System.out.println(salir ? "Indica una clave" : "El valor debe ser numerico");
                        clave = teclado.nextLine();
                        // clave del cifrado
                        try {
                            claveNum = Integer.parseInt(clave);
                            errorNum = false;
                        } catch (NumberFormatException nf) {
                            salir = false;
                        }
                    }

                    File cesarFile = new File("cesar.txt");
                    PrintWriter cesar = new PrintWriter(cesarFile);

                    while (lecturaArchivo.hasNextLine()) {
                        String lecturaBucle = lecturaArchivo.nextLine();
                        // Este bucle lee las líneas y continúa mientras haya más líneas en el archivo
                        StringTokenizer textoParaCifrar = new StringTokenizer(lecturaBucle);
                        while (textoParaCifrar.hasMoreTokens()) {
                            String tokenParaCifrar = textoParaCifrar.nextToken();
                            // Almacenamos en la string tokenParaCifrar cada token del string textoParaCifrar
                            String palabraCifrada = "";
                            palabraCifrada=Util.cifradoCesar(tokenParaCifrar,claveNum);
                            cesar.print(palabraCifrada);
                        }
                        cesar.println(); // Nueva línea después de cada línea del archivo original
                    }

                    lecturaArchivo.close();
                    cesar.close();
                    System.out.println("Cifrado completado. Resultados guardados en cesar.txt");


                teclado.close();
            }
        }
