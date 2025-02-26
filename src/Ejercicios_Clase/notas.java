package Ejercicios_Clase;

import java.util.Scanner;
public class notas {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("introduce la nota");
        double nota;
        nota = in.nextDouble();
        if((nota<0)||(nota>10)){
            System.out.println("Nota no valida");
        }
        else if(nota<5){
            System.out.println("Suspenso");
        }
        else if(nota<7){
            System.out.println("Aprobado");
        }
        else if(nota<9){
            System.out.println("Notable");
        }
        else if(nota<=10){
            System.out.println("Sobresaliente");
        }
        
        in.close();
        
    }
}