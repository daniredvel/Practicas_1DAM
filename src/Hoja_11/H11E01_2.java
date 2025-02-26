package Hoja_11;

import java.util.Scanner;

public class H11E01_2 {
    public static void main(String[] args) {
        int parada_actual, personas_suben, personas_bajan, asientos_ocupados;
        double dinero_total, dinero_parada;
        final double DINERO = 1.25;
        final int ASIENTOS = 40;
        final int PARADAS = 3;
        Scanner in = new Scanner(System.in);
        personas_suben = 0;
        personas_bajan = 0;
        parada_actual = 1;
        asientos_ocupados = 0;
        dinero_total = 0;
        while (parada_actual-1 < PARADAS) {
            System.out.println("Parada nº " + parada_actual+"\n--------------------------------\n Hay "+ asientos_ocupados +
                    " asientos ocupados de un total de "+ ASIENTOS);
            if (asientos_ocupados >= ASIENTOS) {
                System.out.println("El autobus esta lleno");
            }
                do {
                    System.out.println("¿Cuantas personas suben?");
                    personas_suben = in.nextInt();
                    if (personas_suben > ASIENTOS - asientos_ocupados) {
                        System.out.println("ERROR, no pueden subir más personas que asientos libres hay");
                    }

                } while (personas_suben > ASIENTOS -  asientos_ocupados);

                dinero_parada = DINERO * personas_suben;
                System.out.println("Las ganancias en la parada han sido de: " + dinero_parada);
                dinero_total += dinero_parada;
                asientos_ocupados+=personas_suben;

            if(parada_actual!=PARADAS){
            if(asientos_ocupados!=0) {
                    do {
                        System.out.println("¿Cuantas personas bajan?");
                        personas_bajan = in.nextInt();
                        if (personas_bajan > asientos_ocupados) {
                            System.out.println("ERROR, no pueden bajar más personas que asientos ocupados hay");
                        }
                    } while (personas_bajan > asientos_ocupados);
                    asientos_ocupados -= personas_bajan;
                }
            }else{
                System.out.println("En la parada "+(parada_actual-1)+" se bajan las "+asientos_ocupados+
                        " personas que quedan en el autobús\n--------------------------------\nRecaudación total: "+dinero_total);
            }
            parada_actual++;
        }

        in.close();
    }
}

/* Falta que en la primera parada no pregunta quien baja y falta que en la ultima parada no pregunte ni quien sube ni quien baje*/

