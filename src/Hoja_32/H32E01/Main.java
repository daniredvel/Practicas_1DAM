package Hoja_32.H32E01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion=0;
        String lectura;
        Scanner teclado = new Scanner(System.in);
        boolean non, salida=false;
        //non se encarga de la validación del menú y salida de la salida del bucle de menú
        do{
        System.out.println("""
                1> Añadir nuevo catastros
                2> Modificar catastro.
                3> Listar todos los catastros.
                4> Borrar catastro.
                5> Recuperar catastro.
                6> Salir.
                        """);
        do {
            non=false;
            System.out.println("Escoge una opción");
            lectura=teclado.nextLine();
            try {
                opcion=Integer.parseInt(lectura);
                if (opcion<0||opcion>6) {
                    //Número de opciones
                    System.out.println("Opción no valida");
                    non=true;
                }

            } catch (NumberFormatException nfe){
                System.out.println("La opción depede de ser un número");
                non=true;
            }
        } while (non);
            String nombre, direccion;
            double metros;

        switch (opcion){

            case 1:
                System.out.println("Escribe el nombre");
                nombre=teclado.nextLine();

                System.out.println("Escribe el dirección");
                direccion=teclado.nextLine();

                do {
                    non=false;
                    System.out.println("Indica los metros");
                    lectura=teclado.nextLine();
                    try {
                        metros =Double.parseDouble(lectura);
                    } catch (NumberFormatException nfe){
                        System.out.println("La opción depede de ser un número");
                        non=true;
                    }
                } while (non);

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6 : //ultima opción, salida
                salida=true;
                break;
        }
        }while (opcion!=6/*n opciones*/);

        teclado.close();
    }
}
