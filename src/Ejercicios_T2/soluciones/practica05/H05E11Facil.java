package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E11Facil {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;
        String texto;
        
        System.out.println("Escribe un número positivo");
        numero = in.nextInt();
        if(numero<=0){
            System.out.println("El número tiene que ser positivo");
        }
        else{//el número es válido
            if(numero%2!=0 && numero%3!=0 && numero%5!=0){
                texto="El número no es múltiplo ni de dos, ni de tres, ni de cinco";                
            }
            else{
                texto="El número es múltiplo de ";
                if(numero%2==0) texto += "dos ";
                if(numero%3==0) texto += "tres ";
                if(numero%5==0) texto += "cinco ";
            }
            System.out.println(texto);
        }
    }
    
}
