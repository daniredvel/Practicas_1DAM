package Ejercicios_Clase;

import java.util.Scanner;
import java.util.StringTokenizer;
public class PruebaToken2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String texto;
        StringTokenizer st;

        System.out.println("Escribe el nº de serie");
        texto = in.nextLine();
        st = new StringTokenizer(texto,"-");
        //otra opción: "\\p{L}{3}-\\d{5}-\\w{2}-\\d{3}
        if(!texto.matches("[A-Z]{3}-[0-9]{5}-[A-Z0-9]{2}-[0-9]{3}")){
            System.out.println("Mal número de serie");
        }
        else{
            st.nextToken();
            st.nextToken();
            System.out.println(st.nextToken());
        }
    }
}
