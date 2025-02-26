package Hoja_1;

public class H01E04 {
    public static void main(String[] args) {
        double x = 5;
        double Resultado;
        Resultado = ((x*x*x)/((3+x)*(3+x))) + (5* (1/(9*x)));
        //Las potencias estan formadas por cadenas de multiplicaciones
        System.out.println("El resultado de la ecuación es x = " + Resultado);
    } 
}