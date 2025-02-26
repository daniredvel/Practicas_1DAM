package Hoja_3;

import java.util.Scanner;
public class H03E10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int hora1, hora2, minutos1, minutos2, tiempo1, tiempo2, diferenciaHoras, diferenciaMinutos;
        System.out.println("Escriba las horas y minutos del primer tiempo");
        hora1 = in.nextInt();
        minutos1 = in.nextInt();
        System.out.println("Escriba las horas y minutos del segundo tiempo");
        hora2 = in.nextInt();
        minutos2 = in.nextInt();
        tiempo1 = (hora1*60)+ minutos1;
        tiempo2 = (hora2*60) + minutos2;
        diferenciaHoras = (tiempo1 - tiempo2)/60;
        diferenciaMinutos = (tiempo1 - tiempo2)%60;
        System.out.println("La diferencia es de " + diferenciaHoras + " horas y " + diferenciaMinutos + " minutos");
        //System.out.println("La diferencia es de " + Math.abs(diferenciaHoras) + " horas y " + Math.abs(diferenciaMinutos) + " minutos");

        in.close();
    }
}
