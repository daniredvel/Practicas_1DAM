package Hoja_5;

import java.util.Scanner;

public class H05E08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char estudiante;
        // Los descuentos son acumulables, por eso hay varias variables que dependen de
        // otras variables
        int edad, euro, coste12_16, coste65, coste_menor_12, coste12_16_Estudiante, coste_menor_12_Estudiante,
                coste_menor_25;
        euro = 5; // precio normal de la entrada
        coste12_16 = 2; // Precio de la entrada para personas de entre 12 y 16
        coste65 = 2; // Precio de la entrada para mayores de 65
        coste_menor_12 = 0; // Precio de la entrada para menores de 12
        coste12_16_Estudiante = coste12_16 / 2; // Precio de la entrada para personas de entre 12 y 16 que son
                                                // estudiantes
        coste_menor_12_Estudiante = coste_menor_12 / 2; // Precio de la entrada para personas menores de 12 que son
                                                        // estudiantes
        coste_menor_25 = 3; // Precio de la entrada para menores de 25
        System.out.println("Indique su edad");
        edad = in.nextInt();
        in.nextLine();
        System.out.println("Indica si eres estudiante. Escriba una S en caso afirmativo y una N en caso negativo");
        estudiante = in.nextLine().charAt(0);
        
        if (edad < 25) { // Si la edad es menor de 25
            if (estudiante == 's' || estudiante == 'S') { // Si es estudiante (Y menor de 25)
                if (edad < 16 && edad > 12) { // Si tiene menos de 25 y es estudiante pregunta si esta entre 16 y 12
                    if (estudiante == 's' || estudiante == 'S') { // Si es estudiante de entre 12 y 16
                        System.out.println("La entrada vale:" + coste12_16_Estudiante);
                    } else { // Si tiene entre 12 y 16 y no es estudiante
                        System.out.println("La entrada vale:" + coste12_16);
                    }
                }
            } else {
                System.out.println("El precio de la entrada es de:" + coste_menor_25);
            }
            if (edad < 12 && (estudiante == 's' || estudiante == 'S')) { // Si tiene menos de 12 y es estudiante
                System.out.println("El precio de la entrada es de:" + coste_menor_12_Estudiante);
            } else // Si tiene menos de 12 y no es estudiante
            {
                System.out.println("El precio de la entrada es de:" + coste_menor_12);
            }

        }
        if (edad > 25) { // Si es mayor de 25
            if (edad > 65) { // Si tiene mas de 65 años
                if (estudiante == 's' || estudiante == 'S') { // Si teniendo mas de 65 años y es estudiante
                    System.out.println("La entrada vale:" + coste65);
                } else { // Si tiene mas de 65 años y no es estudiante
                    System.out.println("La entrada vale:" + euro + " euros");
                }
            } else {
                System.out.println("La entrada vale:" + euro + " euros");

            }
            in.close();

        }

    }
}