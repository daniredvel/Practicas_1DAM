package Ejercicios_Clase;

public class Primos {
    public static boolean esPrimo(int n){
        if (n<1) return false;
        else if (n == 1) return true;
        else{
            boolean primo=true;
            int i=2;
            while (primo && i<=Math.sqrt(n)){
                primo = !(n % i == 0);
                i++;
            }
            return primo;
        }

    }
}
