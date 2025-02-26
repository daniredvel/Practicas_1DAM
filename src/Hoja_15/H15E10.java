package Hoja_15;

import  java.util.Arrays;
public class H15E10 {
    public static void main(String[] args) {
        final int LARGO = 10;
        int numero;
        int cont = 2;
        int mayor = 1;
    boolean[]numeros=new boolean[LARGO];
    Arrays.fill(numeros,true);
        for (int i = 2; i < numeros.length; i+=2) {
            numeros[i]=false;
        }
        numeros[2]=true;

        for (int i = 0; i < numeros.length; i++) {
            while(cont<=i/2){
                if(i%cont==0){
                    mayor=cont;
                }
                cont++;
                numeros[cont]=false;
            }
        }
        for (boolean a:numeros) {
            System.out.print(a+" ");
        }
    }
}
