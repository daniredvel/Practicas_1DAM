package Hoja_15;

import java.util.Scanner;
public class H15E06_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int [] numeros = new int[10];
            int n;
            boolean salida;
        for (int i = 0; i < 10; i++) {
            salida=false;
            System.out.println("Escribe el numero "+(i+1));
            n= in.nextInt();
            for (int j = 0; j < 10; j++) {
                if (numeros[j]==n&&!salida){
                    System.out.println("Números iguales, escribe otro número");
                    i--;
                    salida = true;
                }
            }
            numeros[i] = n;
        }
        in.close();
    }
}
