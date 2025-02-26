package Examenes.E_Tema7;

import java.util.ArrayList;
import java.util.Scanner;

public class Wifi {
    private String SSID;
    private String descripcion;
    private String canal;
    private ArrayList <String> usuarios;

    public Wifi(String SSID, String descripcion, String canal){
        this.canal=canal;
        this.descripcion=descripcion;
        this.SSID=SSID;
        this.usuarios=new ArrayList<>();
    }
    public static Wifi crearWifi(){
        Scanner in = new Scanner(System.in);
        String SSID2;
        String descripcion2;
        String canal2;
        boolean error=false;
        do {
            error=false;
            System.out.println("Dime el SSID del Wifi");
            SSID2=in.nextLine();
            if (!(SSID2.length()>=4&&SSID2.length()<=20)) {
                error=true;
                System.out.println("El SSID debe de tener de 4 a 20 letras o números");
            }
        }while (error);

        System.out.println("Dame la descripción");
        descripcion2=in.nextLine();
        do {
            error=false;
            System.out.println("Dime el canal");
            canal2=in.nextLine();
            try {
                if (!(Integer.parseInt(canal2) >= 1 && Integer.parseInt(canal2) <= 14)) {
                    error = true;
                    System.out.println("El Canal debe de estar entre 1 y 14");
                }
            } catch (NumberFormatException nfe){
                System.out.println("El canal ha de ser un número");
            } catch (Exception e){
                System.out.println("Error al leer el número");
            }
        }while (error);

        return new Wifi(SSID2, descripcion2, canal2);
    }
    public boolean añadirUsuario(String nombre){
        return usuarios.add(nombre);
    }

    public String getSSID() {
        return SSID;
    }

    @Override
    public String toString() {
        return "SSID: "+this.SSID+" descripción "+this.descripcion+" canal: "+canal;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }
}
