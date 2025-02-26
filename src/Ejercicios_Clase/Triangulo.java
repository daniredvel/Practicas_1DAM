package Ejercicios_Clase;

public class Triangulo implements areaCalculabe{
    private Punto[] puntos;
    private double area;
    public Triangulo(Punto p1, Punto p2, Punto p3){
        puntos = new Punto[3];
        puntos[0]=new Punto(p1.getX(), p1.getY());
        puntos[1]=new Punto(p2.getX(), p2.getY());
        puntos[2]=new Punto(p3.getX(), p3.getY());
    }

    @Override
    public void calcularArea() {
        double base = puntos[0].getX()+puntos[1].getX();
        //Altura calculada siempre y cuando el triangulo tenga la misma y para los puntos de la base.
        double altura = puntos[0].getY()+puntos[1].getY();
        this.area=(altura*base)/2;
    }

    @Override
    public void escribirArea() {
        System.out.println(this.area);
    }
    @Override
    public void escribir(){
        System.out.println( "P1: ("+puntos[0].getX()+","+puntos[0].getY()+") "+
                "P2: ("+puntos[1].getX()+","+puntos[1].getY()+") "+
                "P3: ("+puntos[2].getX()+","+puntos[2].getY()+") " );
    }
}
