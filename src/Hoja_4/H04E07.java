package Hoja_4;

import java.util.Scanner;
public class H04E07 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean texto;
        int a, z, ñMayus, ñ, aMayus, zMayus, letra;
        
        a = 'a';
        z = 'z';
        aMayus = 'A';
        zMayus = 'Z';
        ñMayus = 'Ñ';
        ñ='ñ';
        System.out.println("Escriba una letra");
        letra = in.nextLine().charAt(0);
        texto = (letra >= a&&letra <= z)||(letra >= aMayus)&&(letra <= zMayus) || (letra <= ñMayus)&(letra >= ñ);
        
        System.out.println(texto);

        in.close();
    }

}