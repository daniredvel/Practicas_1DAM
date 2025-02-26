package Hoja_4;

import java.util.Scanner;
public class H04E05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double num1, num2, num3, num4, millar, centenas, decenas, unidades, numFinal;
        System.out.println("Escribe 4 números");
        num1 = in.nextDouble();
        num2 = in.nextDouble();
        num3 = in.nextDouble();
        num4 = in.nextDouble();
      
        unidades = num4;
        decenas = num3*10;
        centenas = num2*100;
        millar = num1*1000;
        
        numFinal = unidades + decenas + centenas + millar;

        System.out.println(numFinal);

    in.close();
    }
}
