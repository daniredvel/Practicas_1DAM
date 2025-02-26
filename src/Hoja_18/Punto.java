package Hoja_18;

public class Punto {
    private double x;
    private double y;

    public Punto(){
        //Constructor de un punto en x=0 e y=0
        this.punto(0,0);
    }
     public Punto(double x, double y){
        //Constructor indicando x e y
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void cambiarCoords(double a, double b){
        this.x = a;
        this.y = b;
    }
    public void copia(Punto p_copia){
        this.x = p_copia.getX();
        this.y = p_copia.getY();
    }
    public boolean iguales(Punto p_copia){
        boolean iguales= p_copia.x == this.x && p_copia.y == this.y;
        return iguales;
    }
    public void sumaCoords(Punto p_copia){
        this.x+= p_copia.getX();
        this.y+= p_copia.getY();
    }
    public double obtenerDistancia(Punto p_copia){
        double distHoriz=Math.abs(p_copia.x-this.x);
        double distVert=Math.abs(p_copia.y-this.y);
        double distancia = Math.sqrt(((distHoriz)*(distHoriz))+((distVert)*(distVert)));
        return distancia;
    }
}
