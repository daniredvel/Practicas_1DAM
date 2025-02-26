package Hoja_31.hoja31.ej1.Clases;

import java.io.Serializable;

public class Movimiento implements Serializable {
    String nombre;
    //nombre del cliente
    double cantidad;
    //Cantidad del movimiento
    long id;
    //número identificador del movimiento

    public Movimiento(String nombre, double cantidad, long id){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.id=id;
    }

    @Override
    public String toString() {
        return "Usuario: " + this.nombre+", cantidad: " + this.cantidad + ".";
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }
}
