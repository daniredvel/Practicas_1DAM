package Hoja_15;

import java.util.Arrays;
import java.util.Scanner;
public class H15E09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int [] numeros = new int[60];
        int n=0, opcion;
        boolean salida, salida_programa=false;

        do {
            System.out.println("Escoge una opción");
            System.out.println("1) Siguiente número\n2) Salir");
            opcion= in.nextInt();


            if (opcion==1){
        for (int i = 0; i < 60; i++) {
            salida=false;
            n= (int)(Math.random()*61+1);
            for (int j = 0; j < 60; j++) {
                if (numeros[j]==n&&!salida){
                    i--;
                    salida = true;
                }
            }
            numeros[i] = n;


        }
                System.out.println(n);
            }
            if (opcion==2){
                salida_programa=true;
            }
            for (int a:numeros) {
                for (int i = 0; i < 60; i++) {
                    salida_programa= a == i;
                }
            }
            System.out.println(Arrays.toString(numeros));
        }while ( salida_programa);

in.close();
    }
}
