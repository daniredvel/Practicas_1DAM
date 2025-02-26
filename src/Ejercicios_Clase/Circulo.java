package Ejercicios_Clase;

public class Circulo implements areaCalculabe{
    private Punto centro;
    private double radio;
    private final static double PI = 3.14159;
    private double area;
    public Circulo(Punto centro, double radio){
        this.centro=centro;
        this.radio=radio;
    }

    @Override
    public void calcularArea() {
        this.area=PI*(radio*radio);
    }

    @Override
    public void escribirArea() {
        System.out.println(this.area);
    }
    @Override
    public void escribir(){
        System.out.println("Centro: ("+centro.getX()+","+centro.getY()+"), "+"radio: "+radio);
    }
}
