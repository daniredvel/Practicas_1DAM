package Hoja_17;

import java.util.Arrays;
import java.util.Scanner;
public class H17E05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        char letra='A';
        int num=0, cont=0;

        System.out.println("Escriba un texto:");
        texto=in.nextLine();

        char [] letras_leidas = new char[texto.length()];


            for (int i = 0; i < texto.length(); i++) {
                letra = texto.charAt(i);
                num = 0;
                for (int j = 0; j < texto.length(); j++) {

                    //Si la letra no se ha leido antes se cuenta cuantas veces aparece
                    if (letra == texto.charAt(j)) {
                        num++;
                        //Si no ha sido leida antes, se almacena en un array de letras leidas
                        letras_leidas[i] = texto.charAt(j);
                    }
                }
                for (int j = 0; j < texto.length(); j++) {
                    if (letra==letras_leidas[j])cont++;
                }
                if (cont<=1){
                if (num < 1) {
                    System.out.println(letra + " " + num + " vez");
                } else {
                    System.out.println(letra + " " + num + " veces");
                }
            }
                cont=0;
            }


        in.close();
    }
}
