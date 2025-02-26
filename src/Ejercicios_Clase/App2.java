package Ejercicios_Clase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean salir=false;
        int opcion=0;
        ArrayList lista = new ArrayList();
        Iterator iterador = lista.iterator();
        String o;
        int posicion=0;


        do {
            System.out.print("""
                    1. Añadir nombre.
                    2. Eliminar nombre.
                    3. Mostrar lista.
                    4. Buscar.
                    5. Salir.\s
                    """);

            opcion=Integer.parseInt(in.nextLine());

            if (opcion==1){
                //Añadir nombre
                System.out.println("Que nombre quieres añadir:");
                o=in.nextLine();
                if (!App2.buscar(o, lista)) lista.add(o);

                else {
                     posicion=((App2.posicion(o, lista))+1);
                    System.out.println("El nombre esta en la posición: "+posicion+" de la lista");
                }
            } else if (opcion==2) {
                //Quitar nombre
                System.out.println("Que nombre quieres quitar:");
                o=in.nextLine();
                lista.remove(o);
            } else if (opcion==3) {
                //Recorre la lista
                for (Object nombre : lista) {
                    System.out.println(nombre);
                }

            } else if (opcion==4) {
                System.out.println("Que nombre quieres buscar:");
                o=in.nextLine();
                if(App2.buscar(o, lista)) {
                    posicion=((App2.posicion(o, lista))+1);
                    System.out.println("El nombre esta en la posición: "+posicion+" de la lista");
                }
                else System.out.println("El nombre no esta en la lista");
            } else if (opcion==5) {
                salir=true;
            }
        }while (!salir);
        in.close();

    }
    public static boolean buscar(Object buscar, ArrayList lista){
        return lista.contains(buscar);
    }
    public static int posicion(Object buscar, ArrayList lista){
        return lista.indexOf(buscar);
    }
}

