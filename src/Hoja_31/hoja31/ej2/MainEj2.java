package Hoja_31.hoja31.ej2;

import java.io.File;
import java.util.Scanner;

public class MainEj2 {
    public static void main(String[] args) {
        int opcion=0;
        String lectura;
        Scanner teclado = new Scanner(System.in);
        boolean non, salida=false;
        //non se encarga de la validación del menú y salida de la salida del bucle de menú
        File archivoSalas = new File("salas.bin");

        do {
        System.out.println("""
                1> Añadir información sobre sala
                2> Modificar información sobre sala
                3> Mostrar listado sobre salas
                4> Mostrar suma total de asistentes
                5> Salir\s
                        """);
        do {
            non=false;
            System.out.println("Escoge una opción");
            lectura=teclado.nextLine();
            try {
                opcion=Integer.parseInt(lectura);
                if (opcion<1||opcion>5) {
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

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:
                salida=true;
                break;
        }
}while (opcion!=5);
        teclado.close();
    }
}
