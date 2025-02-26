package Hoja_17;

import java.util.Scanner;

public class H17E06 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String codigo, codigo_may;
    boolean valido=false;
        System.out.println("Escribe el código:");
        codigo=in.nextLine();
        codigo_may=codigo.toUpperCase();
        if (codigo_may.length()==5||codigo.length()==6)valido=true;
        else valido =false;
        //System.out.println("1: "+valido);

        if (codigo_may.charAt(0)=='S'||codigo.charAt(0)=='V'||codigo.charAt(0)=='X')valido=true;
        else valido =false;
        //System.out.println("2: "+valido);

        if (codigo_may.charAt(1)>'0'&&codigo.charAt(1)<'9') valido=true;
        else valido =false;
        //System.out.println("3: "+valido);

        if (codigo_may.charAt(4)>'A'&&codigo.charAt(4)<'Z') valido=true;
        else valido =false;
        //System.out.println("4: "+valido);

        if (codigo_may.charAt(4)=='X'){
            //System.out.println("5: "+valido);

            if (codigo_may.charAt(5)>'0'&&codigo.charAt(5)<'9') valido=true;
                else valido =false;

               // System.out.println("6: "+valido);

        } else if (codigo_may.length()==6){
            valido=false;
        }
        //System.out.println("7: "+valido);


        if (valido) System.out.println("El código: "+codigo+" es valido");
            else System.out.println("El código: "+codigo+" no es valido");

    in.close();
    }
}
