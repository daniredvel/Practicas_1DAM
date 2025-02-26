package Examenes.E_Tema5;

public class Dibujador {

    public static void linea(int tam){
        for (int i = 0; i < tam; i++) {
            System.out.print("X ");
        }
    }
    public static void cuadrado(int tam){
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print("X ");
            }
            System.out.println();
        }
    }

}
