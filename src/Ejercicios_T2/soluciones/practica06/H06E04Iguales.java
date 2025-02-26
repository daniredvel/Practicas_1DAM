package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;
public class H06E04Iguales {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int x, y, z;

        System.out.println("Escribe tres números positivos");
        x=in.nextInt();
        y=in.nextInt();
        z=in.nextInt();

        if(x==y && y==z)
            System.out.println("Los tres números son iguales a " +x);
        else if(x==y || x==z){
            System.out.println("Dos números son iguales a " +x);
        }
        else if (y==z) {
            System.out.println("Dos números son iguales a " + y);
        }
        else{
            System.out.println("No hay números iguales");
        }
        in.close();
    }
}
