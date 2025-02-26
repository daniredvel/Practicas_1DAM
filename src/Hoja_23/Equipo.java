package Hoja_23;

import java.util.Objects;

/**
 * The type Equipo.
 */
public class Equipo {
    private String nombre;
    private String localidad;
    private String presidente;
    private Jugador[] jugadores;
    private static final int MAX_Jugadores = 11;
    private byte marca;

    /**
     * Instantiates a new Equipo.
     *
     * @param nombre     the nombre
     * @param localidad  the localidad
     * @param presidente the presidente
     */
    public Equipo(String nombre, String localidad, String presidente){
        this.nombre=nombre;
        this.localidad=localidad;
        this.presidente=presidente;
        marca = 0;
        jugadores = new Jugador[MAX_Jugadores];
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets localidad.
     *
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Gets presidente.
     *
     * @return the presidente
     */
    public String getPresidente() {
        return presidente;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Sets localidad.
     *
     * @param localidad the localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Sets presidente.
     *
     * @param presidente the presidente
     */
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    private boolean lleno (){
        //return marca == MAX_Jugadores;
        if (marca==MAX_Jugadores) return true;
        else return false;
    }
    private boolean vacio (){
        //return marca == MAX_Jugadores;
        if (marca==0) return true;
        else return false;
    }

    /**
     * Añadir jugador.
     *
     * @param jugador_nuevo the jugador nuevo
     */
    public void añadirJugador(Jugador jugador_nuevo){
        if (!lleno()){
            jugadores [marca]=jugador_nuevo;
            marca++;
        }
    }

    /**
     * Quitar jugador.
     *
     * @param jugador_quitar the jugador quitar
     */
    public void quitarJugador (Jugador jugador_quitar){
        if (!vacio()){
            byte posicion_quitada=0;
            for (byte i = MAX_Jugadores-1;  i > 0; i--) {
                if (jugadores[i]!=null) {
                    if (Objects.equals(jugador_quitar.getNombre().toUpperCase(), jugadores[i].getNombre().toUpperCase())) {
                        jugadores[i] = null;
                        posicion_quitada = i;
                    }
                }
            }
                for (byte i = posicion_quitada; i < MAX_Jugadores; i++) {
                    if (i !=MAX_Jugadores-1){
                        jugadores[i]=jugadores[i +1];
                    } else jugadores[i]=null;

                }
            marca--;
        }
    }

    /**
     * Escribir.
     */
    public void escribir (){
        if (!vacio()){
            for (int i = 0; i < marca; i++) {
                if (i!=marca-1) System.out.print(jugadores[i].getNombre()+", ");
                else System.out.print(jugadores[i].getNombre()+".");
            }
        } else System.out.println("La lista esta vacia");
        System.out.println();
    }

    /**
     * Comprobar jugador boolean.
     *
     * @param nameJugador the name jugador
     * @return the boolean
     */
    public boolean comprobarJugador(String nameJugador){
        boolean nombreExistente = false;
        for (int i = 0; i < marca; i++) {
            if (Objects.equals(this.jugadores[i].getNombre().toUpperCase(), nameJugador.toUpperCase())) nombreExistente =true;
        }
        return nombreExistente;
    }
}