package Hoja_6;

import java.util.Scanner;
public class H06E07 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double a, b, c, resultado1, resultado2;
        System.out.println("Escribe los coeficiente a, b y c de la ecuación de 2º grado");
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        resultado1 = ((-b)+Math.sqrt(Math.pow(b, 2)-(4*a*c)))/(2*a);
        resultado2 = ((-b)-Math.sqrt(Math.pow(b, 2)-(4*a*c)))/(2*a);
        System.out.println("Los resultados de la ecuación son: " + resultado1 + " y " + resultado2);
        in.close();
    }
}
