package Hoja_15;

import java.util.Scanner;
public class H15E07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[]salas=new boolean[15];
        boolean opcion=false, salir=false;
        byte opcion_e;

        /*
        Calculo de salas ocupadas aleatorias

        for (int i = 0; i < 15; i++) {
            int salas_ocupadas=(int)(Math.random()+0.5);
            if(salas_ocupadas>1){
                salas[i]=true;
        }
        }
         */
        do {
        System.out.println("Bienvenido a nuestra aplicación de reserva de salas, escoge una opción:");
        System.out.println("1) Reservar sala\n2) Liberar sala\n3) Listar salas\n4) Salir\n¿Que opción escoges?");
        opcion_e= in.nextByte();
            opcion= opcion_e >= 5 || opcion_e <= 0;
            if (opcion_e==1){
                int sala;
                do {
                    System.out.println("¿Que sala quieres reservar?");
                     sala = in.nextInt();
                     if (salas[(sala - 1)]) System.out.println("Esa sala esta ocupa, escoga otra.");
                }while (salas[(sala - 1)]);

                    salas[(sala - 1)]=true;

            }else if (opcion_e==2){
                int sala;
                do {
                    System.out.println("¿Que sala quieres liberar?");
                    sala = in.nextInt();
                    if (!salas[(sala - 1)]) System.out.println("Esa sala no esta reservada, escoga otra.");
                }while (!salas[(sala - 1)]);

                salas[(sala - 1)]=false;
            }else if (opcion_e==3){
                System.out.print("Estan libres las salas:");
                for (int i = 0; i < 15; i++) {
                    if (salas[i]) System.out.print(i+1);
                }
            }else if (opcion_e==4){
                salir=true;
            }
        } while (opcion || salir);

        in.close();
    }
}
