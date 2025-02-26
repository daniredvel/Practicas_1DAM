package Hoja_18;

public class Rectangulo {
    private Punto punto;
    private double largo;
    private double ancho;

    public Rectangulo(Punto punto, double largo, double ancho){
        this.punto=punto;
        this.largo=largo;
        this.ancho=ancho;
    }
    public Rectangulo(double largo, double ancho){
        this.punto=0,0;
        this.largo=largo;
        this.ancho=ancho;
    }

    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

}