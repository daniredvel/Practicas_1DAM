package Hoja_34;

public class Categoria {
    private String nombre;
    private int id_categoria;

    public Categoria(String nombre, int id_categoria) {
        this.nombre = nombre;
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
