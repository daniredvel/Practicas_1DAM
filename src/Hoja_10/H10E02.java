package Hoja_10;

import java.util.Scanner;

public class H10E02 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            double num, n, resultado;

            System.out.println("Escriba un número:");
            num = in.nextInt();
            resultado=0;
            if(num%2 == 0){
                resultado=num/2;
            }else if(num%3==0){
                resultado=num/3;
            }else if(num%5==0){
                resultado=num/5;
            }else if(num%7==0){
                resultado=num/7;
            }else {
                resultado=num;
            }
            if(resultado == num){
                System.out.println("El número es primo");
            }else{
                System.out.println(resultado);
            }
            in.close();
        }
    }

