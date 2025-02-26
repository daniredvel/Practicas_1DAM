package Hoja_12;

import java.util.Scanner;

public class H12E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1, n2;
        int cont = 2;
        int mayor;
        int menor;
        int divisor;
        System.out.println("Escribe dos números:");
        n1 = in.nextInt();
        n2 = in.nextInt();
        if (0 < n1 && 0 < n2) {
            mayor=Math.max(n1,n2);
            menor=Math.min(n1,n2);
            divisor=menor;
            while(mayor%divisor!=0 || menor%divisor!=0){
                divisor--;
            }System.out.println("El máximo común divisor de "+n1+" y "+n2+" es "+divisor);
        } else {
            System.out.println("Error, los numeros han de ser positivos.");

        }
                in.close();
            }
        }


