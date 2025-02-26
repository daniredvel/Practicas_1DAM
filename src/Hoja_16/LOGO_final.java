package Hoja_16;

import java.util.Arrays;
import java.util.Scanner;

public class LOGO_final {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            final int LARGO = 8, ANCHO = 15;
            boolean salir = false, lapiz = false, goma = false;
            int tortuga_x = 0, tortuga_y = 0, opcion;
            char simbolo = '·', simbolo_pintado = '█', simbolo_tortuga = 'X';
            int[][] tortuga = new int[LARGO][ANCHO];
            int[][] tablero = new int[LARGO][ANCHO];

            do {
                for (int[] a : tortuga) {
                    Arrays.fill(a, 3);
                }
                tortuga[tortuga_x][tortuga_y] = -1;
                // Pintar el tablero
                for (int i = 0; i < LARGO; i++) {
                    for (int j = 0; j < ANCHO; j++) {
                        if (tortuga[i][j] == -1) {
                            System.out.print(simbolo_tortuga);
                        } else if (tablero[i][j] == 0) {
                            System.out.print(simbolo);
                        } else if (tablero[i][j] == 1) {
                            System.out.print(simbolo_pintado);
                        }
                    }
                    System.out.println();
                }
                System.out.println("""

                    MENU
                    0. Salir
                    1. Bajar lápiz 
                    2. Subir lápiz
                    3. Bajar goma
                    4. Subir goma
                    5. Mover arriba
                    6. Mover abajo
                    7. Mover izquierda
                    8. Mover derecha
                    9. Mostrar tablero""");
                // Pintar el tablero

                System.out.println("Escoge una opción");
                opcion = in.nextInt();
                if (opcion == 0) {
                    salir = true;
                }
                if (opcion == 1) {
                    lapiz = true;
                    goma = false;
                }
                if (opcion == 2) {
                    lapiz = false;
                }
                if (opcion == 3) {
                    goma = true;
                    lapiz = false;
                    tablero[tortuga_x][tortuga_y] = 0;
                }
                if (opcion == 4) {
                    goma = false;
                }
                if (opcion == 5) {
                    if (tortuga_x == 0) {
                        tortuga_x++;
                    }
                    tortuga_x--;
                }
                if (opcion == 6) {
                    if (tortuga_x == ANCHO - 1) {
                        tortuga_x--;
                    }
                    tortuga_x++;
                }
                if (opcion == 7) {
                    if (tortuga_y == 0) {
                        tortuga_y++;
                    }
                    tortuga_y--;
                }
                if (opcion == 8) {
                    if (tortuga_y == LARGO - 1) {
                        tortuga_y--;
                    }
                    tortuga_y++;
                }

                if (opcion == 9) {
                    for (int i = 0; i < LARGO; i++) {
                        for (int j = 0; j < ANCHO; j++) {
                            if (tablero[i][j] == 0) {
                                System.out.print(simbolo);
                            } else if (tablero[i][j] == 1) {
                                System.out.print(simbolo_pintado);
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("\n");
                }
                if (!lapiz&&!goma);

                else if (lapiz) {
                    tablero[tortuga_x][tortuga_y] = 1;
                }
                else if (goma) {
                    tablero[tortuga_x][tortuga_y] = 0;
                }
            } while (!salir);
            in.close();
        }
    }