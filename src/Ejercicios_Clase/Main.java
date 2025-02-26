package Ejercicios_Clase;

public class Main {
    public static void main(String[] args) {
        Punto p1= new Punto(2,3);
        Punto p2= new Punto(4,5);
        Punto p3= new Punto(0,0);
        double rad=5;
        Cuadrado c = new Cuadrado(p1, p2);
        Circulo c1 = new Circulo(p3,rad);
        c.escribir();
        c1.escribir();
        c.calcularArea();
        c1.calcularArea();
        c.escribirArea();
        c1.escribirArea();
    }
}
