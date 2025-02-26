package Hoja_17;

import java.util.Scanner;
public class H17E02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        int clave;
        char simbolo_final;
        System.out.println("Escribe un texto:");
        texto=in.nextLine();
        System.out.println("Escribe una clave:");
        clave=in.nextInt();
        char [] array_texto = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            simbolo_final=(char)(texto.charAt(i)+clave);
            array_texto[i]=simbolo_final;
        }
        String texto_final = new String(array_texto);
        System.out.println(texto_final);
        in.close();
    }
}
