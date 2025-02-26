package Ejercicios_T2.soluciones.practica08;

public class H08E07Rectangulo4 {
    public static void main(String[] args) {
        int ancho = (int)(Math.random() * 80 + 1);
        int alto = (int)(Math.random() * 19 + 2);
        char caracter = (char)(Math.random() * 94 + 33);
        for(int i = 1; i <= alto; i++){
            for (int j = 1; j <= ancho; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }
}
