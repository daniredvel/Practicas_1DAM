package Hoja_35.modelos;
/**
 * Clase que representa una localidad de la base de datos
 */
public class Localidad {
    private String nombre;
    private int poblacion;
    private String provincia;
    private String comunidad;

    public Localidad(String nombre, int poblacion, String provincia, String comunidad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.comunidad = comunidad;
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
        this.poblacion = 0;
        this.provincia = "";
        this.comunidad = "";
    }

    public Localidad(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.provincia = "";
        this.comunidad = "";

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }
}
