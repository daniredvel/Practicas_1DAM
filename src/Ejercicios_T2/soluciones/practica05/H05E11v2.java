package Ejercicios_T2.soluciones.practica05;

import java.util.Scanner;
public class H05E11v2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numero;
        boolean multiplo2,multiplo3, multiplo5;
        byte contMultiplos=0;
        String texto;

        System.out.println("Escribe un número positivo");
        numero=in.nextInt();
        if(numero<=0){
            System.out.println("El número no es positivo");
        }
        else{
           multiplo2=(numero%2==0);
           multiplo3=(numero%3==0);
           multiplo5=(numero%5==0);
          if(multiplo2) contMultiplos++;
          if(multiplo3) contMultiplos++;
          if(multiplo5) contMultiplos++;
          if(contMultiplos==0){
              System.out.println("El número no es múltiplo de 2, 3 ni 5");
          }
          else{
              texto="El número es múltiplo de ";
              if(multiplo2) texto+="dos";
              if(multiplo3) {
                  if(contMultiplos==2) texto+=" y tres";
                  else if(contMultiplos>2) texto += ", tres";
                  else texto+="tres";
              }
              if(multiplo5) {
                  if(contMultiplos>=2) texto+=" y cinco";
                  else texto+="cinco";
              }
              System.out.println(texto);
          }
        }
    }
}
