package Hoja_11;

import java.util.Scanner;

public class H11E01 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
      double precio, dinero_parada, dinero_total;
      int paradas, asientos, parada_actual, personas_suben, personas_bajan, asientos_ocupados,asientos_libres;
      dinero_total=0;
      dinero_parada=0;
      precio=1.25;
      paradas = 12;
      asientos = 40;
      parada_actual=1;
      asientos_ocupados=0;
      asientos_libres=asientos;
      while(parada_actual<paradas) { //Cuando la parada actual sea mayor que el número de paradas, sale del bucle
          System.out.println("Parada nº " + parada_actual+"\n--------------------------------\n Hay "+ asientos_ocupados +" asientos ocupados de un total de "+ asientos);
          if(asientos_ocupados>= asientos){
              System.out.println("El autobus está lleno");
          }else{
              if (asientos_libres >= asientos){
                  do {
                      System.out.println("¿Cuantas personas suben?"); //Pregunta cuantas personas suben
                      personas_suben = in.nextInt(); //Personas que suben
                      dinero_parada = personas_suben*precio;
                      System.out.println("Recaudación en la parada: "+ parada_actual + " es de: "+ dinero_parada);
                      if (personas_suben > asientos_libres) {
                          System.out.println("Error, no pueden subir más personas que los asientos libres que hay");
                      }

                  }while(asientos_libres <= personas_suben);
                  asientos_ocupados+=personas_suben; //asientos ocupados
                  personas_suben=0;
                  if(asientos_ocupados!=0 && parada_actual==0){
                      do {
                          System.out.println("¿Cuantas personas bajan?"); //Pregunta cuantas personas bajan
                          personas_bajan = in.nextInt(); //Personas que bajan
                          if (personas_bajan > asientos_ocupados) {
                              System.out.println("Error, no pueden bajar más personas que los asientos ocupados que hay");
                          }
                          asientos_ocupados-=personas_bajan;
                          personas_bajan=0;
                      } while (personas_bajan < asientos_ocupados);

                  }
              }


          }

          asientos_libres=asientos-asientos_ocupados;
          parada_actual++;
          dinero_total+=dinero_parada;
          dinero_parada=0;

          if(parada_actual==paradas){
              System.out.println("En la parada "+parada_actual+" se bajan las "+asientos_ocupados+
                      " personas que quedan en el autobús\n--------------------------------\nRecaudación total: "+dinero_total);
          }
      }
        in.close();
    }
}

