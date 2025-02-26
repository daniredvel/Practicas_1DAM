package Ejercicios_Clase;

public class GrabarNumeros {
    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            if(Primos.esPrimo(i)){
                System.out.println(i);
            }
        }
    }
}
