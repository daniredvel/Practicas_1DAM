package Ejercicios_Clase;

public class Pruebas {
    public static void main(String[] args) {
        final int LARGO=20, ANCHO=30, CONT_BARCO=15;
        int barco_x, barco_y,cont=0;
        boolean[][] tablero=new boolean[LARGO][ANCHO];
        char simbolo_barco='█', simbolo_vacio='·';

        do {
        barco_x=(int)(Math.random()*LARGO);
        barco_y=(int)(Math.random()*ANCHO);
        tablero[barco_x][barco_y]=true;

        cont++;
        }while (cont<=CONT_BARCO);
        for (int i = 0; i < LARGO; i++) {
            //Cuenta filas
            for (int j = 0; j < ANCHO; j++) {
                //Cuenta columnas
                if (tablero[i][j]){
                    //Comprueva el valor de las cordenadas i j, true=barco, false=vacio
                    System.out.print(simbolo_barco);
                }else{
                    System.out.print(simbolo_vacio);
                }
            }
            System.out.println();
        }
    }
}
