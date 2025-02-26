package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E11Dificil {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;
        String texto;
        int contMultiplos=0;
        boolean multiplo2,multiplo3,multiplo5;
        
        System.out.println("Escribe un número positivo");
        numero = in.nextInt();
        if(numero<=0){
            System.out.println("El número tiene que ser positivo");
        }
        else{//el número es válido
            multiplo2 = (numero%2==0);
            multiplo3 = (numero%3==0);
            multiplo5 = (numero%5==0);
            if(multiplo2) contMultiplos++;
            if(multiplo3) contMultiplos++;
            if(multiplo5) contMultiplos++;

            if(contMultiplos==0){
                texto="No es múltiplo ni de dos, ni de tres, ni de cinco";
            }
            else{
                texto="El número es múltiplo de ";
                if(contMultiplos==1){
                    if(multiplo2) texto+="dos";
                    else if(multiplo3) texto+="tres";
                    else texto+="cinco";
                }
                else if(contMultiplos==2){
                    if(multiplo2 && multiplo3) texto+="dos y tres";
                    else if(multiplo2 && multiplo5) texto+="dos y cinco";
                    else texto+="tres y cinco";
                }
                else{
                    texto += "dos, tres y cinco";
                }
            }
            System.out.println(texto);
        }
    }
    
}
