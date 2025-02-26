package Hoja_6;

import java.util.Scanner;
public class H06E05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char letra, letraMayus;
        int letraNum;
        System.out.println("Escribe una letra minuscula:");
        letra = in.nextLine().charAt(0);
        letraNum = (int) letra;
        if (letraNum >= 'a' && letraNum <= 'z'){
            letraNum = letraNum - 32;
            letraMayus = (char) letraNum;
            System.out.println(letra + " en mayuscula es: " + letraMayus);
            }
        else {
            System.out.println("ERROR, escribe una letra minuscula");
        }
        in.close();
    }
}
