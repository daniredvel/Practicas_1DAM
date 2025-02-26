package Hoja_15;

import java.util.Scanner;

public class H15E02 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
final int k=5;
int [] numeros = new int[k];
        for (int i=0; i<k;i++){
            System.out.println("Escribe el numero "+(i+1));
            numeros[i]=in.nextInt();
        }
for (int i=0; i<k;i++){
    for (int j =0; j<=i;j++){
        System.out.print(" ");
    }
    System.out.println(numeros[i]);
}
in.close();
    }
}
