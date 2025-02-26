package Hoja_3;

import java.util.Scanner;
public class H03E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double celsius, farenheit, kelvin; 
        System.out.println("Introduzca la temperatura en grados Celsius");
        celsius = in.nextDouble();
        farenheit = (celsius*(9/5)) + 32;
        kelvin = celsius +273.15;
        System.out.println(celsius + " grados celsius son " + farenheit + " grados Farenheit y " + kelvin + " grados Kelvin" );
        in.close();
    }
}
