package Hoja_5;

import java.util.Scanner;
public class H05E10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int edad;
        double salario, salario_Mayor_45, salario_Menor_45, salario_Menor_30, salario_30_45, salario_Mayor_45_menos_1000;
        String nombre;
        System.out.println("Escriba el nombre y apellidos de la persona");
        nombre = in.nextLine();
        System.out.println("Escriba su salario y su edad");
        salario = in.nextDouble();
        edad = in.nextInt();
        salario_Mayor_45 = salario + (salario*0.03);
        salario_30_45 = salario + (salario*0.03);
        salario_Menor_45 = salario + (salario*0.1);
        salario_Mayor_45_menos_1000 = salario + (salario*0.15);
        salario_Menor_30 = 1100;
        if (salario<2000){
                if (salario >= 1000 && salario < 2000) {
                    if (edad>45){
                        System.out.println("El salario de: " + nombre + " es de: " + salario_Mayor_45);
                    } else {
                        System.out.println("El salario de: " + nombre + " es de: " + salario_Menor_45);
                    }
                } if (salario < 1000){
                    if (edad <30){
                        System.out.println("El salario de: " + nombre + " es de: " + salario_Menor_30);
                    } if (edad >= 30 && edad <= 45){
                        System.out.println("El salario de: " + nombre + " es de: " + salario_30_45);

                    } if (edad > 45){
                        System.out.println("El salario de: " + nombre + " es de: " + salario_Mayor_45_menos_1000);
                    }
                }
        } else {
            System.out.println("El salario de: " + nombre + " es de: " + salario);
        }
        in.close();
    }
}
