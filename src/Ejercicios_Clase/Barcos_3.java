package Ejercicios_Clase;

public class Barcos_3 {
    public static void main(String[] args) {
     final int LARGO=40, ANCHO=50, CONT_BARCO=25;
     boolean[][]tablero=new boolean[LARGO][ANCHO];
     boolean barco=true, limite_arriba_x=false, limite_abajo_x=false, limite_izq_y=false, limite_drch_y=false,
             limite_drch_y_arriba_x=false, limite_izq_y_arriba_x=false, limite_drch_y_bajo_x=false, limite_izq_y_bajo_x=false;
     char simbolo_barco='█', simbolo_vacio='·';
    int cont=0, barco_x,barco_y;
    do {
        barco_x=(int)(Math.random()*LARGO); //Cordenada x aleatoria (Realmente es la y, la altura)
        barco_y=(int)(Math.random()*ANCHO); //Cordenada y aleatoria (Realmente es la x, la anchura)
        System.out.println("\n "+cont+"\n");
        System.out.println("x:"+barco_x);
        System.out.println("y:"+barco_y);


        if (tablero[barco_x][barco_y]) barco=false;
            //Comprueba si la posición aleatoria esta ocupada

        //Limites

        if (barco_x==0) limite_arriba_x=true;
        //Limite superior

        else if (barco_x==LARGO-1) limite_abajo_x=true;
        //Limite inferior

        if (barco_y==0) limite_izq_y=true;
        //Limite izquierda

        else if (barco_y==ANCHO-1) limite_drch_y=true;
        //Limite derecha

        if (limite_arriba_x && limite_drch_y){
            limite_drch_y_arriba_x=true;

        }
        //Si esta en los limites de la derecha y arriba, esta en la esquina

        else if (limite_abajo_x && limite_drch_y){
            limite_drch_y_bajo_x=true;

        }
        //Si esta en los limites de la izquierda y abajo, esta en la esquina

        else if (limite_abajo_x && limite_izq_y){
            limite_izq_y_bajo_x=true;
        }
        //Si esta en los limites de la izquierda y abajo, esta en la esquina

        else if (limite_arriba_x && limite_izq_y){
            limite_izq_y_arriba_x=true;

        }

         if (limite_drch_y_arriba_x){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y-1]) barco=false;
            else if (tablero[barco_x+1][barco_y]) barco=false;
            else if (tablero[barco_x+1][barco_y-1]) barco=false;
        }
        //Comprueba, estando en la esquina superior derecha, si tiene algun true alrededor

         else if (limite_drch_y_bajo_x){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y-1]) barco=false;
            else if (tablero[barco_x-1][barco_y]) barco=false;
            else if (tablero[barco_x-1][barco_y-1]) barco=false;
        }
        //Comprueba, estando en la esquina inferior derecha, si tiene algun true alrededor

         else if (limite_izq_y_bajo_x){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y+1]) barco=false;
            else if (tablero[barco_x-1][barco_y]) barco=false;
            else if (tablero[barco_x-1][barco_y+1]) barco=false;
        }
        //Comprueba, estando en la esquina inferior izquierda, si tiene algun true alrededor
        else if (limite_izq_y_arriba_x){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y+1]) barco=false;
            else if (tablero[barco_x+1][barco_y]) barco=false;
            else if (tablero[barco_x+1][barco_y+1]) barco=false;
        }
        //Comprueba, estando en la esquina superior izquierda, si tiene algun true alrededor

         else if (limite_arriba_x){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x+1][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y+1]) barco=false;
            else if (tablero[barco_x][barco_y-1]) barco=false;
            else if (tablero[barco_x+1][barco_y+1]) barco=false;
            else if (tablero[barco_x+1][barco_y-1]) barco=false;
        }
        //Comprueba, estando arriba completamente, si tiene algun true alrededor

         else if (limite_abajo_x){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x-1][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y+1]) barco=false;
            else if (tablero[barco_x][barco_y-1]) barco=false;
            else if (tablero[barco_x-1][barco_y+1]) barco=false;
            else if (tablero[barco_x-1][barco_y-1]) barco=false;
        }
        //Comprueba, estando abajo, si tiene algun true alrededor

         else if (limite_drch_y){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y-1]) barco=false;
            else if (tablero[barco_x+1][barco_y]) barco=false;
            else if (tablero[barco_x-1][barco_y]) barco=false;
            else if (tablero[barco_x+1][barco_y-1]) barco=false;
            else if (tablero[barco_x-1][barco_y-1]) barco=false;
        }
        //Comprueba, estando a la derecha completamente, si tiene algun true alrededor

         else if (limite_izq_y){
            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y+1]) barco=false;
            else if (tablero[barco_x+1][barco_y]) barco=false;
            else if (tablero[barco_x-1][barco_y]) barco=false;
            else if (tablero[barco_x+1][barco_y+1]) barco=false;
            else if (tablero[barco_x-1][barco_y+1]) barco=false;
        }
        //Comprueba, estando a la izquierda completamente, si tiene algun true alrededor
         else {

            if (tablero[barco_x][barco_y]) barco=false;
            else if (tablero[barco_x][barco_y+1]) barco=false;
            else if (tablero[barco_x][barco_y-1]) barco=false;
            else if (tablero[barco_x+1][barco_y]) barco=false;
            else if (tablero[barco_x-1][barco_y]) barco=false;
            else if (tablero[barco_x+1][barco_y-1]) barco=false;
            else if (tablero[barco_x+1][barco_y+1]) barco=false;
            else if (tablero[barco_x-1][barco_y+1]) barco=false;
            else if (tablero[barco_x-1][barco_y-1]) barco=false;
        }
        //Si no estaba en ninguna posición limite, comprueba todos las posiciones de alrededor

        if (barco) {
            tablero[barco_x][barco_y]=true;
            cont++;
        }

        //Si barco es true, esa posición del tablero cumple los requisitos para ocuparse

    }while (cont<=CONT_BARCO);
//for para imprimir tablero
        for (int i = 0; i < LARGO; i++) {
            //Cuenta filas
            for (int j = 0; j < ANCHO; j++) {
                //Cuenta columnas
                if (tablero[i][j]){
                    //Comprueva el valor de las cordenadas i j, true=barco, false=vacio
                    System.out.print(simbolo_barco+" ");
                }else{
                    System.out.print(simbolo_vacio+" ");
                }
            }
            System.out.println();
        }
    }
}
