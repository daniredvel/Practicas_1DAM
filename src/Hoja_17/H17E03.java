package Hoja_17;

import java.util.Arrays;
import java.util.Scanner;

public class H17E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto, texto_cifrado, clave_tamaño;
        char simbolo_cifrado;
        int clave, n, numero, cont=0;

        System.out.println("Escribe un texto:");
        texto=in.nextLine();
        System.out.println("Escribe una clave:");
        clave=in.nextInt();

        n=clave;
        numero=clave;
        while (n!=0){
            n/=10;
            cont++;
        }

        int [] numeros=new int[cont];

        for(int j = 0; j<cont;j++) {
            n=clave%10;
            numeros[j]=n;
            clave/=10;
        }
        char[]clave_suma=new char[cont];
        char [] texto_cifrado_array = new char[texto.length()];
        for (int i = 0; i < cont; i++) {
            clave_suma[i]=(char)(numeros[i]);
        }

        for (int i = 0, j=0; i < texto.length(); i++, j++) {
            if (j<cont){
                System.out.println(j);
                simbolo_cifrado=(char)(texto.charAt(i)+clave_suma[j]);
                texto_cifrado_array[i]=simbolo_cifrado;
            }
            else j=0;
        }

        System.out.println( Arrays.toString(texto_cifrado_array));

        in.close();
    }
}
