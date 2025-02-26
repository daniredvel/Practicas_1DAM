package Ejercicios_T2.soluciones.practica06;

import java.util.Scanner;

public class H06E12Multiplicar {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num1, num2, res;

        num1=(int)(Math.random()*10+1);
        num2=(int)(Math.random()*10+1);

        System.out.println("Dime cuánto es "+num1+" por "+num2);
        res=in.nextInt();

        if(res == num1*num2){
            System.out.println("¡Correcto!");
        }
        else{
            System.out.println("¡Incorrecto!");
        }

    }

}
