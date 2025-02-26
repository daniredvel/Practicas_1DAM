package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E09DiasMes {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int mes;

        System.out.println("Escribe un número de mes");
        mes=in.nextInt();

        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8
            ||mes==10 || mes==12){
            System.out.println("El mes tiene 31 días");
        }
        else if(mes==2){
            System.out.println("El mes tiene 28 días");
        }
        else if(mes==4 || mes==6 || mes==9 || mes==11){
            System.out.println("El mes tiene 30 días");
        }
        else{
            System.out.println("Ese mes no existe");
        }
        in.close();
    }
}
