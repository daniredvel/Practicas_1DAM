package Hoja_22;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cola personas=new Cola();
        byte valor=0;
        boolean salir = false;
        do{
        System.out.print("""
                1) Añadir una persona a la cola
                2) Atender a una persona
                3) Mostrar la lista de personas en la cola
                4) Salir
                Escriba una opción:
                """);
        valor=in.nextByte();

        if (valor==1){
            if (!personas.full()){
                String nuevo;
                System.out.println("¿Que nombre quieres añadir?");
                in.nextLine();
                nuevo =in.nextLine();
                personas.add(nuevo);
            } else System.out.println("La cola esta llena");
        } else if (valor==2){
            System.out.println(personas.poll());
        } else if (valor==3) {
            personas.list();
        } else if (valor==4) {
            salir=true;
        }
        }while(!salir);
        in.close();
    }
}