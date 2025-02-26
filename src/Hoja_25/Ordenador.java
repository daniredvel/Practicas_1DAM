package Hoja_25;

public class Ordenador {
    protected int ram;
    protected int hd;
    protected String procesador;
    protected String nombre;
    protected boolean encendido;
    public Ordenador(String nombre){
        this.nombre=nombre;
        this.ram=4;
        this.hd=512;
        this.procesador="i3";
    }
    public Ordenador (String nombre, int ram, int hd, String procesador){
        this.nombre=nombre;
        this.ram=ram;
        this.hd=hd;
        this.procesador=procesador;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    public boolean encender(){
        return encendido=true;
    }
    public boolean apagar(){
        return encendido=false;
    }
    public void escribir(){
        System.out.println("Nombre: "+this.nombre+"\nProcesador: "+this.procesador+
                "\nRAM: "+ram+" GB\nHD: "+hd+"GB\nEncendido: "+(encendido?"Si":"No"));
    }
}
