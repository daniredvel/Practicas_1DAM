package Ejercicios_T2.soluciones.practica07;

public class H07E04ASCIIExt {
    public static void main(String[] args) {
        char cont = 0;
        while(cont<256) {
            System.out.println(cont + " Código:" + (int)cont);
            cont++;
        }
    }

}
