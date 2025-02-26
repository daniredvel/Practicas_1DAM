package Hoja_23;

import java.util.Objects;
import java.util.Scanner;

public class Equipos {

    private Equipo [] equipos_comp;
    private final int NUM_EQUIPOS=8;
    private int marcador=0;
    public Equipos(){
        equipos_comp = new Equipo[NUM_EQUIPOS];

    }
    public void añadirEquipo(String name_equip, String presidente, String localidad){
        if (marcador<NUM_EQUIPOS){
            equipos_comp[marcador]= new Equipo(name_equip, presidente, localidad);
            if (marcador!=NUM_EQUIPOS-1) marcador++;
        }
    }
    public boolean existe (String name_comp) {
        boolean nameValido=true;
        if (equipos_comp[0] != null) {
            for (int i = 0; i < marcador; i++) {
                if ((Objects.equals(equipos_comp[i].getNombre().toUpperCase(), name_comp.toUpperCase())))
                    nameValido = false;
            }
        }
        return nameValido;
    }
    public void list(){
        if (equipos_comp[0]!=null){
            for (int i = 0; i < marcador; i++) {
                if (i!=marcador-1) System.out.print(equipos_comp[i].getNombre()+", ");
                else System.out.print(equipos_comp[i].getNombre()+".");
            }
            System.out.println("\n");
        } else System.out.println("No hay equipos\n");
    }
    public boolean jugadorExiste (String name_comp) {
        boolean nameValido=false;
        if (equipos_comp[0] != null) {
            for (int i = 0; i < marcador; i++) {
                if(equipos_comp[i].comprobarJugador(name_comp)) nameValido=true;
            }
        }
        return nameValido;
    }

    public Equipo[] getEquipos_comp() {
        return equipos_comp;
    }

    public int getMarcador() {
        return marcador;
    }
    public void escribir(){
        for (int i = 0; i < marcador; i++) {
            System.out.println("Equipo "+(i+1)+": nombre: "+equipos_comp[i].getNombre()+
                    " presidente: "+equipos_comp[i].getPresidente()+
                    " localidad: "+equipos_comp[i].getLocalidad()+
                    "\n\tJugadores: ");
            for (int j = 0; j < marcador; j++) {
                equipos_comp[i].escribir();
            }
        }
    }
    public int buscarEquipo(String nombreEquipo){
        int posicion=0;
        for (int i = 0; i < marcador; i++) {
            if ((Objects.equals(equipos_comp[i].getNombre().toUpperCase(), nombreEquipo.toUpperCase()))) posicion=i;
        }
        return posicion;
    }
}
