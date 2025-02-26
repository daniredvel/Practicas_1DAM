package Ejercicios_Clase;

public class Cuadrado implements areaCalculabe {
    private Punto[] puntos;
    private double area;
    public Cuadrado(Punto p1, Punto p2){
       puntos = new Punto[4];
       //Izquierda inferior
       puntos[0]=new Punto(p1.getX(), p1.getY());
       //Derecha superior
       puntos[1]=new Punto(p2.getX(), p2.getY());
       //Derecha inferior
       puntos[2]=new Punto(p2.getX(), p1.getY());
       //izquierda superior
       puntos[3]=new Punto(p1.getX(), p2.getY());

    }
    public Cuadrado(Punto p1, Punto p2, Punto p3){
        puntos = new Punto[4];
        //Izquierda inferior
        puntos[0]=new Punto(p1.getX(), p1.getY());
        //Derecha superior
        puntos[1]=new Punto(p2.getX(), p2.getY());
        //Derecha inferior
        puntos[2]=new Punto(p3.getX(), p3.getY());
        //izquierda superior
        puntos[3]=new Punto(p1.getX(), p2.getY());
    }
    public Cuadrado(Punto p1, Punto p2, Punto p3, Punto p4){
        puntos = new Punto[4];
        //Izquierda inferior
        puntos[0]=new Punto(p1.getX(), p1.getY());
        //Derecha superior
        puntos[1]=new Punto(p2.getX(), p2.getY());
        //Derecha inferior
        puntos[2]=new Punto(p3.getX(), p3.getY());
        //izquierda superior
        puntos[3]=new Punto(p4.getX(), p4.getY());
    }
    @Override
    public void escribir(){
        System.out.println( "P1: ("+puntos[0].getX()+","+puntos[0].getY()+") "+
                            "P2: ("+puntos[1].getX()+","+puntos[1].getY()+") "+
                            "P3: ("+puntos[2].getX()+","+puntos[2].getY()+") "+
                            "P4: ("+puntos[3].getX()+","+puntos[3].getY()+") ");
    }

    @Override
    public void calcularArea() {
        double base = puntos[0].getX()+puntos[2].getX();
        double altura = puntos[3].getY()+puntos[1].getY();
        this.area=base*altura;
    }

    @Override
    public void escribirArea() {
        System.out.println(this.area);
    }
}
