package Hoja_15;

import java.util.Scanner;

public class H15E05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=0;
        boolean salida=false;
        int [] numeros1=new int[10];
        int [] numeros2=new int[10];
        int [] numeros1_aux=new int[10];
        int [] numeros2_aux=new int[10];

        System.out.println("Escribe 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros1[i]=in.nextInt();
        }
        System.out.print("El primer array es: ");
        for (int a=0; a < 10; a++) {
            System.out.print(+numeros1[a]+" ");
        }
        System.out.println();
        System.out.println("Escribe otros 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros2[i]=in.nextInt();
        }
        System.out.print("El segundo array es: ");
        for (int a=0; a < 10; a++) {
            System.out.print(+numeros2[a]+" ");
        }
        System.out.println();

       /* for (int igual:numeros1) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10 && !salida; j++) {
                    if(numeros1[i]!=numeros2[j]){
                        salida=true;
                    }
                }
                    if (salida) diferencia++;
            }
                salida=false;
        }*/

        numeros2_aux=numeros2;
        numeros1_aux=numeros1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (numeros1_aux[i]==numeros2_aux[j]){
                    n++;
                    numeros1_aux[i]=-5;
                    numeros2_aux[j]=-3;
                }
            }
        }
        if(n>=10){
            System.out.println("Los arrays tienen los mismos numeros");
        }else {
            System.out.println("Los arrays no tienen los mismos numeros");
        }
        in.close();
    }
}
