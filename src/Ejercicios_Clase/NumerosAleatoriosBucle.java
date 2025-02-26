package Ejercicios_Clase;

public class NumerosAleatoriosBucle {
    public static void main(String[] args) {
        /*
         * Los contadores tienen tres partes:
         * el valor inicial: int cont=1
         * la condición cont<=0
         * la operación del contador cont++
         * Al tener el =, si el cont empezara en 0 el contador saldria disparado, se
         * ejecutaria 4 veces: 0, 1 , 2, 3.
         */
        int cont = 1;
        while (cont <= 3) {
            System.out.println((int) (Math.random() * 100 + 1));
            cont++;
        }
    }
}
