package Hoja_6;

import java.util.Scanner;
public class H06E02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double dado;
        int resultado;
        dado = Math.random()*7;
        resultado = (int) dado;
        System.out.println(resultado);
        in.close();
    }
}
