package Hoja_24;

public class Articulo {
    private String nombre;
    private String descripcion;
    private int clave;
    private int cantidad;

    public String getNombre() {
        return nombre;
    }

    public int getClave() {
        return clave;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo(String nombre, String descripcion, int clave, int cantidad){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.clave=clave;
        this.cantidad=cantidad;
    }
    public Articulo(String nombre, String descripcion, int clave){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.clave=clave;
    }
}
