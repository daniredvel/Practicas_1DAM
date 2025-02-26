package Proyecto_reservas.modelos;

public class Sala {
    private String codSala;
    private String nombre;

    public Sala(String codSala, String nombre) {
        this.codSala = codSala;
        this.nombre = nombre;
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return codSala + " - " + nombre;
    }
}
