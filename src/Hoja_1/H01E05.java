package Hoja_1;

public class H01E05 {
    public static void main(String[] args) {
        long grados = 20000;
        long Vueltas = grados/360;
        long UltimaVuelta = grados%360;
        //Cada vuelta son 360º, por eso se dividen las vueltas entre los grados y el resto de la división son los grados restantes 
        System.out.println(Vueltas + " vueltas");
        System.out.println(UltimaVuelta + " grados en la ultima vuelta");
    }
}
