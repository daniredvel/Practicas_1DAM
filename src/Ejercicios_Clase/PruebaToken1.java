package Ejercicios_Clase;

import java.util.StringTokenizer;

public class PruebaToken1 {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("25-108-36-2819","-");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
