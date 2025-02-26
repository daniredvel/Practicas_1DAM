package Hoja_14;

import java.util.Scanner;

public class H14E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i=0,num,n, cont=0, n2,n3;
        double numero;
        System.out.println("Escriba un número:");
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
       for(int j = i-1; j>=0;j--){
           System.out.print(numeros[j]+" ");
       }

        in.close();
    }
}
