package Hoja_31.hoja31.ej1;

import java.io.File;
import java.util.Scanner;
import hoja31.ej1.Clases.*;

public class MainEj1 {
    public static void main(String[] args) {
        int opcion=0;
        String lectura;
        Movimientos movimientos = new Movimientos();
        Scanner teclado = new Scanner(System.in);
        boolean non, salida=false;
        //non se encarga de la validación del menú y salida de la salida del bucle de menú
        File archivo = new File("movimientos.bin");

        do {

            System.out.print("""
                    -------------------------------
                    1- Añadir movimiento al archivo
                    2- Consultar movimiento por número
                    3- Consultar movimiento por nombre
                    4- Cantidad de movimientos
                    5- Salir
                    -------------------------------
                    """);
            do {
                non = false;
                System.out.println("Escoge una opción");
                lectura = teclado.nextLine();
                try {
                    opcion = Integer.parseInt(lectura);
                    if (opcion < 1 || opcion > 4) {
                        //Número de opciones
                        System.out.println("Opción no valida");
                        non = true;
                    }

                } catch (NumberFormatException nfe) {
                    System.out.println("La opción depede de ser un número");
                    non = true;
                }
            } while (non);

            String nombre;

            switch (opcion) {
                case 1:
                    String sCantidad;
                    double cantidad = 0;
                    System.out.println("Indica tu nombre");
                    nombre = teclado.nextLine();

                    do {
                        non = false;
                        System.out.println("Indica la cantidad");
                        sCantidad = teclado.nextLine();
                        try {
                           cantidad = Double.parseDouble(sCantidad);
                        } catch (NumberFormatException nfe) {
                            System.out.println("La cantidad debe ser un número");
                            non = true;
                        }
                    } while (non);

                    System.out.println(movimientos.añadirMovimiento(nombre, cantidad, archivo) ? "Movimiento añadido con exito" : "Error al añadir el movimiento");

                    break;

                case 2:
                    String movimiento = "";
                    do {
                        non = false;
                        System.out.println("Indica el número de movimiento:");
                        movimiento = teclado.nextLine();
                        try {
                            System.out.println(movimientos.listarMovimientoNumero(Long.parseLong(movimiento),archivo));
                        } catch (NumberFormatException nfe) {
                            non = true;
                        }
                    } while (non);
                    break;

                case 3:
                    System.out.println("Indica el nombre:");
                    nombre = teclado.nextLine();
                    System.out.println(movimientos.listarMovimientoNombre(nombre, archivo));
                    break;

                case 4:
                    salida = true;
                    break;
            }
        }while (opcion!=4);

        teclado.close();
    }
}
