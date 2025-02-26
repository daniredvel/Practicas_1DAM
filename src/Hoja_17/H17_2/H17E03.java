package Hoja_17.H17_2;

import java.util.Scanner;

public class H17E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        int clave, i=0,num,n, cont=0, n2,n3;
        char simbolo_final=0;
        double numero;
        System.out.println("Escribe un texto:");
        texto=in.nextLine();
        System.out.println("Escribe una clave:");

        num=in.nextInt();
        n=num;
        numero=num;
        while (n!=0){
            n/=10;
            i++;
        }
        int [] numeros = new int[i];
        for(int j = 0; j<i;j++) {
            n=num%10;
            numeros[j]=n;
            num/=10;
        }
        for (int k = 0; k < texto.length(); k++) {
            for (int j = 0; j < i-1; j++) {
                simbolo_final=(char)(texto.charAt(k)+numeros[j]);
            }   //¿?
            System.out.print(""+simbolo_final);
        }
        in.close();
    }
}
