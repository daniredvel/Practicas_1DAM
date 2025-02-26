package Hoja_12;

import java.util.Scanner;

public class H12E01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    String simbolo;
        System.out.println("Escribe un simbolo");
        simbolo = in.nextLine();
        char simbol = simbolo.charAt(0);
        for(int cont=32; cont<=simbol;cont++){
            System.out.print((char)cont+" ");
        }
        in.close();
    }
}
