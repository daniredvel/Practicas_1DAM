package Hoja_18.H18_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Rectangulo {
    private Punto punto;
    private double largo;
    private double ancho;
    private char caracter;
    private boolean dentro=false;

    public Rectangulo(Punto punto, double largo, double ancho){
        this.punto=punto;
        this.largo=largo;
        this.ancho=ancho;
    }
    public Rectangulo(double largo, double ancho){
        this.punto=new Punto();
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

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public char getCaracter() {
        return caracter;
    }

    public void cambiarEsquina(double x, double y){
        this.punto=new Punto(x,y);
    }

    public void dibujar(){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
 public void dibujar(char caracter){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                System.out.print(caracter+" ");
            }
            System.out.println();
        }
    }

    public void interior(double x, double y){
        dentro = x < this.largo+ punto.getX() && x > 0 && y < this.ancho+ punto.getY() && y > 0;
        System.out.println(dentro);
    }

    public void vertices(){
        double x=this.punto.getX();
        double y=this.punto.getY();

        Punto [] puntos = new Punto[4];
        puntos [0]= new Punto(this.punto.getX(), this.punto.getY());
        puntos [1]= new Punto(this.punto.getX(),this.punto.getY()-ancho);
        puntos [2]= new Punto(this.punto.getX()+largo,this.punto.getY());
        puntos [3]= new Punto(this.punto.getX()+largo,this.punto.getY()-ancho);

        System.out.println("""
                Punto 1: Esquina de arriba a la izquierda
                Punto 2: Esquina de abajo a la izquierda
                Punto 3: Esquina de arriba a la derecha
                Punto 4: Esquina de abajo a la derecha
                """);

        for (int i = 0; i < 4; i++) {
            System.out.println("Punto: " + (i+1) + " = X: " + puntos[i].getX() + " Y: " + puntos[i].getY());
        }

    }

}
