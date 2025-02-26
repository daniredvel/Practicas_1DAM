package Hoja_17;

import java.util.Scanner;
public class H17E01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        System.out.println("Escribe un texto:");
        texto=in.nextLine();
        for (int i = 0; i < texto.length(); i++) {
            System.out.println(texto.charAt(i));
        }
        in.close();
    }
}
