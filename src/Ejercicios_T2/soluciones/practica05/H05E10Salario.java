package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E10Salario {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String nombre, apellidos;
        int edad;
        double salario;

        System.out.println("escribe tu nombre");
        nombre=in.nextLine();
        System.out.println("escribe tus apellidos");
        apellidos=in.nextLine();
        System.out.println("escribe tu edad");
        edad=in.nextInt();
        System.out.println("escribe tu salario");
        salario=in.nextDouble();
        
        if(salario<1000){
            if(edad<30) salario *= 1.03;
            else if(edad<=45) salario *= 1.1;
            else salario *= 1.15;
        }
        else if(salario<=2000){
            if(edad>45) salario *= 1.03;
            else salario *= 1.1;
        }
        System.out.println(nombre + " " + apellidos + " tu salario será de "+
                salario + " euros");
        in.close();
    }
}