package Hoja_34;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        if (GestorConexion.nuevaConexionMySQL("articulos","GestorArticulos","A12345a")){
            con=GestorConexion.getConexion();
        } else {
            System.out.println(GestorConexion.getError());
        }
        String lectura;
        Scanner teclado = new Scanner(System.in);
        boolean salida=false;
        //non se encarga de la validación del menú y salida de la salida del bucle de menú
        do{
            System.out.println("""
                                 1) Menú de categorías
                                 2) Menú de artículos
                                 3) Salir
                                  """);

            System.out.println("Escoge una opción");
            lectura=teclado.nextLine();

            switch (lectura) {
                case "1" -> {
                    boolean salidaCat = false;
                    do {
                        System.out.println("""
                                1) Añadir categoría
                                2) Eliminar categoría
                                3) Listar categorías
                                4) Volver al menú principal
                                 """);

                        System.out.println("Escoge una opción");
                        lectura = teclado.nextLine();

                        String nombre;
                        switch (lectura) {
                            case "1" -> {
                                System.out.println("Indica el nombre de la categoría:");
                                nombre = teclado.nextLine();
                                assert con != null;
                                System.out.println(UtilCategorias.anadirCategoria(nombre, con));
                            }
                            case "2" -> {
                                System.out.println("Indica el nombre de la categoría:");
                                nombre = teclado.nextLine();
                                assert con != null;
                                System.out.println(UtilCategorias.eliminarCategoria(nombre, con));
                            }
                            case "3" -> {
                                assert con != null;
                                System.out.println(UtilCategorias.listarCategorias(con));
                            }
                            case "4" -> //ultima opción, salida
                                    salidaCat = true;
                        }
                    } while (!salidaCat);
                }
                case "2" -> {
                    boolean salidaArt = false;
                    do {
                        System.out.println("""                          
                                1) Añadir artículo
                                2) Eliminar artículo
                                3) Modificar artículo
                                4) Mostrar datos de artículo
                                5) Listar todos los artículos de una categoría
                                6) Listar todos los artículos
                                7) Volver al menú principal
                                """);

                        System.out.println("Escoge una opción");
                        lectura = teclado.nextLine();
                        String nombre, clave, categoria;
                        int precio = 0;
                        switch (lectura) {
                            case "1" -> {
                                System.out.println("Indica la categoria:");
                                categoria = teclado.nextLine();
                                System.out.println("Indica la clave:");
                                clave = teclado.nextLine();
                                System.out.println("Indica el nombre:");
                                nombre = teclado.nextLine();
                                boolean non;
                                do {
                                    non = false;
                                    System.out.println("Indica el precio");
                                    lectura = teclado.nextLine();
                                    try {
                                        precio = Integer.parseInt(lectura);

                                    } catch (NumberFormatException nfe) {
                                        System.out.println("El precio debe de ser un número");
                                        non = true;
                                    }
                                } while (non);
                                assert con != null;
                                System.out.println(UtilArticulos.anadirArticulo(con, categoria, clave, nombre, precio));
                            }
                            case "2" -> {
                                System.out.println("Indica la categoria:");
                                categoria = teclado.nextLine();
                                System.out.println("Indica la clave:");
                                clave = teclado.nextLine();
                                assert con != null;
                                System.out.println(UtilArticulos.eliminarArticulo(con, categoria, clave));
                            }
                            case "3" -> {
                                String nuevaClave;
                                System.out.println("Indica la clave del artículo a modificar:");
                                clave = teclado.nextLine();
                                assert con != null;
                                System.out.println(UtilArticulos.modificarArticulo(clave, con));
                               /*
                                System.out.println("Indica la nueva clave:");
                                nuevaClave=teclado.nextLine();
                                */

                            }
                            case "4" -> {
                                System.out.println("Indica la clave:");
                                clave = teclado.nextLine();
                                assert con != null;
                                System.out.println(UtilArticulos.atributosArticulo(con, clave));
                            }
                            case "5" -> {
                                System.out.println("Indica la categoria:");
                                categoria = teclado.nextLine();
                                assert con != null;
                                System.out.println(UtilArticulos.listarArticulosCategoria(con, categoria));
                            }
                            case "6" -> {
                                assert con != null;
                                System.out.println(UtilArticulos.listarTodosArticulos(con));
                            }
                            case "7" -> //ultima opción, salida
                                    salidaArt = true;
                        }
                    } while (!salidaArt);
                }
                case "3" -> { //ultima opción, salida
                    salida = true;
                    System.out.println("Adios");
                }
            }
        }while (!salida);

        System.out.println(GestorConexion.cerrarConexion()?"Conexión cerrada":"No se pudo cerrar la conexión");

        teclado.close();

    }
}
