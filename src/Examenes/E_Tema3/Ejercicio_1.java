package Examenes.E_Tema3;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int X=8, Y=8;
        char [] [] tablero = new char[Y] [X];
        int tablero_x, tablero_y;
        char caracter;
        boolean valido=true;

        //Tablreo inicial hecho de puntos
        for (char [] a:tablero) {
            for (int i = 0; i < X; i++) {
                a [i]= '·';
            }
        }

        do {

            //Posición Y - vertical
            do {
                System.out.println("Dime la posición vertical:");
                tablero_y=in.nextInt();

                //Validación
                if (!(tablero_y<=Y)){
                    System.out.println("Posición incorrecta");
                    valido=false;
                } else valido=true;

            }while (!valido);

            if (tablero_y>=0) {
                //Posición X - Horizontal
                do {
                    System.out.println("Dime la posición horizontal:");
                    tablero_x = in.nextInt();

                    //Validación
                    if (!(tablero_x <= X && tablero_x >= 0)) {
                        System.out.println("Posición incorrecta");
                        valido = false;
                    } else valido = true;

                } while (!valido);

                //Carácter a escribir
                System.out.println("Dime un carácter");
                //in.nextLine() que evita errores en la lectura de char tras la lectura de int
                in.nextLine();
                caracter = in.nextLine().charAt(0);

                //Cambiar el tablero por el caracter escogido
                tablero[tablero_y][tablero_x] = caracter;

                //Pintar tablero
                for (int i = 0; i < Y; i++) {
                    for (int j = 0; j < X; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }while (tablero_y>=0);

        //Mensaje de salida
        System.out.println("¡Hasta pronto!");

        in.close();
    }
}
