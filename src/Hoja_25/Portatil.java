package Hoja_25;

public class Portatil extends Ordenador{
    protected double peso;
    public Portatil(String nombre){
        super(nombre);
        this.peso=3;
    }
    public Portatil(String nombre, int ram, int hd, String procesador, int peso){
        super(nombre, ram, hd, procesador);
        this.peso = peso;
    }
    public void escribir(){
        System.out.println("Nombre: "+this.nombre+"\nProcesador: "+this.procesador+
                "\nRAM: "+ram+" GB\nHD: "+hd+"GB\nEncendido: "+(encendido?"Si":"No")+"\nPeso: "+peso+" Kg");
    }
}
