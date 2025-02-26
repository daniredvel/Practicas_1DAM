package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;

public class H06E07Ecuacion {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double a, b, c;
        double res, raiz;

        System.out.println("Escribe los coeficientes a, b y c de la ecuación de segundo grado");
        a=in.nextDouble();
        b=in.nextDouble();
        c=in.nextDouble();
        raiz=b*b-4*a*c;//para no hacer continuamente esta operación lo guardamos en la variable raiz
        if(raiz<0){//raíz cuadrada de número negativo
            System.out.println("No hay soluciones reales");
        }
        else if(raiz==0){
            res=-b/(2*a);
            System.out.println("La solución es " + res);
        }
        else{
            res=(-b+Math.sqrt(raiz))/(2*a);
            System.out.println("La primera solución es " + res);
            res=(-b-Math.sqrt(raiz))/(2*a);
            System.out.println("La segunda solución es " + res);
        }

    }

}
