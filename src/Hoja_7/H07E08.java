package Hoja_7;

import java.util.Scanner;
public class H07E08 {
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
        int horas, pago, horas_extra;
    System.out.println("¿Horas de trabajo?");
    horas = in.nextInt();
    if(horas>35){
        horas_extra = horas-35;
        pago = horas*15 + horas_extra*22;
    }pago = horas*15;
    System.out.println(pago + " euros");
    in.close();
    }
}
