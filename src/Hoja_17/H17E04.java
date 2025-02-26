package Hoja_17;

import java.util.Scanner;
public class H17E04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;

        System.out.println("Escribe un texto:");
        texto=in.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(texto.charAt(j));
            }
            System.out.println();
        }

        in.close();
    }
}
