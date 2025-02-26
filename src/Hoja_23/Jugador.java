package Hoja_23;

public class Jugador {
    private String nombre;
    private int goles;

    public int getGoles() {
        return goles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Jugador(String nombre){
        this.nombre=nombre;
        this.goles=0;
    }
    public Jugador(String nombre, int goles){
        this.nombre=nombre;
        if (goles>0) this.goles=goles;
        else this.goles=0;
    }
    public void escribir(){
        System.out.println("nombre:"+this.nombre);
        System.out.println("goles:"+this.goles);
    }
}
