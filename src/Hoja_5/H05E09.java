package Hoja_5;

import java.util.Scanner;
public class H05E09 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        byte mes;
        System.out.println("Escriba el mes:");
        mes = in.nextByte();
        if(mes>=1 && mes<=12){
            if (mes == 1|| mes == 3|| mes == 5|| mes == 7 || mes == 8|| mes == 10 || mes == 12){
                System.out.println("El mes " + mes + " tiene 31 días");
            } else if (mes == 4|| mes == 6|| mes == 9|| mes == 11) {
                System.out.println("El mes " + mes +  " tiene 30 días");
            } else {
                System.out.println("El mes " + mes + " tiene 28 días");
            }
        } else {
            System.out.println("ERROR, NÚMERO DE MES INCORRECTO");
        }
        in.close();
    }
}
