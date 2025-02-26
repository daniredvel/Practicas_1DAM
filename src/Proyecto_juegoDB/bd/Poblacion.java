package Proyecto_juegoDB.bd;

public class Poblacion {
    private String nombre;
    private String provincia;
    private boolean acierto;
    private int fallos;

    public Poblacion(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.acierto=false;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", provincia: "+provincia+" acierto "+acierto+" fallos "+fallos;
    }
}
