package Examenes.E_Tema8b.src;

import java.io.File;
import java.util.Scanner;

public class MainCitas {
    public static void main(String[] args) {
        final int OPCION_MAX=3, OPCION_MIN=1;
        int opcion=0;
        String lectura, nombre;
        Scanner teclado = new Scanner(System.in);
        boolean non, salida=false;
        File fichero = new File("citas.txt");
        //non se encarga de la validación del menú y salida de la salida del bucle de menú
        do{
            System.out.println("""
                               --------------------------
                               1) Buscar citas por autor
                               2) Obtener cita aleatoria
                               3) Salir
                               --------------------------
                               """);
            do {
                non=false;
                System.out.println("Escoge una opción");
                lectura=teclado.nextLine();
                try {
                    opcion=Integer.parseInt(lectura);
                    if (opcion<OPCION_MIN||opcion>OPCION_MAX) {
                        //Número de opciones
                        System.out.println("Opción no valida");
                        non=true;
                    }

                } catch (NumberFormatException nfe){
                    System.out.println("La opción depede de ser un número");
                    non=true;
                }
            } while (non);



            switch (opcion){
                case 1:
                    System.out.println("Indica el autor:");
                    nombre=teclado.nextLine();

                    System.out.println(UtilCitas.buscar(nombre, fichero));
                    break;

                case 2:
                    System.out.println(UtilCitas.citaAleatoria(fichero));
                    break;

                case OPCION_MAX: //ultima opción, salida
                    salida=true;
                    break;
            }
        }while (!salida/*OPCION_MAX si esta es la opción de salida*/);

        teclado.close();
    }
}
