package Hoja_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ej6 {
    //Error con números de más 9/10 cifras en la clave
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            String ruta;
            String clave="";

            try {
                //La validación del archivo se realiza a traves del control de excepciones
                //Si falla la creación del File o el Scanner el resto del programa no se ejecuta
                System.out.println("Indica el archivo");
                ruta = teclado.nextLine();
                // Leemos la ruta del archivo
                File archivo = new File(ruta);
                // Creamos un objeto file que recoja el archivo indicado
                Scanner lecturaArchivo = new Scanner(archivo);
                // Creamos un escáner para leer el archivo
                File augustoFile = new File("augusto.txt");
                //Archivo donde almacenar el resultado del cifrado
                PrintWriter augusto = new PrintWriter(augustoFile);
                //Printwriter que escribira el resultado del cifrado
                boolean salir = true;
                //Booleano que controla el bucle de validación de la lectura y trasformación (String-int) de la clave
                int claveNum = 0;
                //Variable que almacena la clave de cifrado

                do {
                    //Este bucle controla que la clave, leida como String, sea un número
                    /*
                     * La variable salir controla la repetición del bucle:
                     * Si el bucle se repite significa que salir es false, es decir, ha habido una excepción
                     *                      y por tanto la clave leida no es el número
                     * Si el bucle no se repite salir es true (valor asignado en la declaración) esto hace que
                     *                       unicamente se muestre una vez mensaje el primer mensaje
                     */
                    System.out.println(salir ? "Indica una clave" : "El valor debe ser numerico");
                    clave = teclado.nextLine();
                    // clave del cifrado
                    try {
                        claveNum = Integer.parseInt(clave);
                        salir = true;
                    } catch (NumberFormatException nf) {
                        //Si ha habido una excepción provocada al transformar la clave a número debe volver a preguntar
                        salir = false;
                    }
                } while (!salir);



                while (lecturaArchivo.hasNextLine()) {
                    // Este bucle lee las líneas y continúa mientras haya más líneas en el archivo
                    String lecturaBucle = lecturaArchivo.nextLine();
                    //lecturaBucle almacena la linea que el StringTokenizer fragmentara en los tokens a encriptar
                    StringTokenizer textoParaCifrar = new StringTokenizer(lecturaBucle);

                    while (textoParaCifrar.hasMoreTokens()) {
                        String tokenParaCifrar = textoParaCifrar.nextToken();
                        // Almacenamos en la string tokenParaCifrar cada token del string textoParaCifrar con el que trabajemos
                        String palabraCifrada = "";
                        //palabraCifrada almacenara el String que cifradoAugusto le pase, la palabra ya encriptada
                        palabraCifrada= Util.cifradoAugsto(tokenParaCifrar,clave);
                        //A Util.cifradoAugusto le pasamos el token y la clave
                        augusto.print(palabraCifrada);
                        //Añadimos al archivo agusto.txt a través del PrintWriter augusto la nueva linea
                    }
                    augusto.println(); // Nueva línea después de cada línea del archivo original

                }

                lecturaArchivo.close();
                augusto.close();
                //Cerramos el Scanner y el PrintWriter
                System.out.println("Cifrado completado. Resultados guardados en augusto.txt");
                //Indicamos al usuario que el programa se ha ejecutado correctamente

            } catch (FileNotFoundException fnf) {
                System.out.println("Error al leer el archivo");
                //Si no se ha encontrado el archivo o hay algun error con este se indica
            } catch (NoSuchElementException nse) {
                System.out.println("El archivo está vacío");
                //Si el Scanner no encuentra elementos indica que el archivo esta vacio
            } catch (Exception e) {
                System.out.println("Error");
                //Control de cualquier otra excepción
            }
            teclado.close();
            //Cerramos la entrada del sistema
        }
    }