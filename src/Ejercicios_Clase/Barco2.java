package Ejercicios_Clase;

import java.util.Arrays;

public class Barco2 {
        public static void main(String[] args) {
            final int LARGO=20,ANCHO=50,CONT_BARCO=25;
            int barco_x, barco_y,cont=0, contador=1;
            boolean barco=true,rango_x=false,rango_y=false,limite_arriba_x=false,limite_drch_y=false,limite_abajo_x=false,limite_izq_y=false, barco_lado=false;
            final char BARCO='█', PUNTO='c';
            boolean[][] tablero=new boolean[LARGO][ANCHO];

            for (boolean[] a : tablero) {
                for (boolean b : a) {
                    b=false;
                }

            }
            do {
                barco_x=(int)(Math.random()*(LARGO));
                barco_y=(int)(Math.random()*(ANCHO));

                if (barco_x>0&&barco_x<LARGO)rango_x=true;
                if (barco_y>0&&barco_y<ANCHO)rango_y=true;
                if (barco_y==0)limite_izq_y=true;
                if (barco_y==ANCHO-1)limite_drch_y=true;
                if (barco_x==0)limite_arriba_x=true;
                if (barco_x==LARGO-1)limite_abajo_x=true;


                if (!tablero[barco_x][barco_y]) {
                barco=true; //True si no era verdadero
                }
                if (rango_y && rango_x&&!limite_abajo_x){
                    barco= !tablero[barco_x + 1][barco_y]; //False si tiene algun true debajo
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_drch_y){
                    barco= !tablero[barco_x][barco_y + 1]; //False si tiene algun true a la derecha
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_izq_y){
                    barco= !tablero[barco_x][barco_y - 1]; //False si tiene algun true a la izquierda
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_arriba_x){
                    barco= !tablero[barco_x - 1][barco_y]; //False si tiene algun true arriba
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_abajo_x&&!limite_drch_y){
                    barco= !tablero[barco_x + 1][barco_y + 1];//False si tiene algun true en la esquina inferior derecha
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_arriba_x&&!limite_izq_y){
                    barco= !tablero[barco_x - 1][barco_y - 1]; //False si tiene algun true en la esquina superior izquierda
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_abajo_x&&!limite_izq_y){
                    barco= !tablero[barco_x + 1][barco_y - 1];//False si tiene algun true en la esquina inferior izquierda
                    barco_lado=true;
                }
                if (rango_y&&rango_x&&!limite_arriba_x&&!limite_drch_y){
                    barco= !tablero[barco_x - 1][barco_y + 1];//False si tiene algun true en la esquina superior derecha
                    barco_lado=true;
                }

                if (barco&&!barco_lado) cont++;
                barco_lado=false;
            } while (cont < CONT_BARCO);


            for (int i = 0; i < LARGO; i++) {
                for (int j = 0; j < ANCHO; j++) {
                    if (tablero[i][j]) {
                        System.out.print(BARCO);

                    /*
                    System.out.print(contador);
                    contador++;
                     */

                    }else {
                        System.out.print(PUNTO);
                    }
                }
                System.out.println();
            }
        }
    }