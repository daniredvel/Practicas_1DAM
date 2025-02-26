package Hoja_34;

public class Articulo {
    private String categoria, nombre, clave;
    private int id_categoria, precio;

    public Articulo(String categoria, String nombre, String clave, int id_categoria, int precio) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.clave = clave;
        this.id_categoria = id_categoria;
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "categoria: " + categoria +
                ", nombre: " + nombre  +
                ", clave: " + clave +
                ", precio: " + precio;
    }
}
