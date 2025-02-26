package Hoja_25;

public class Movil extends Ordenador {
    private String tipo;
    private Camara camara;
    //¿?¿?
    public Movil(String nombre, int ram, int hd, String procesador, String tipo,double apertura, int megapixeles, String marca){
        super(nombre, ram, hd, procesador);
        this.tipo=tipo;
        this.camara = new Camara(apertura, megapixeles, marca);
    }
    public void escribir(){
        System.out.println("Nombre: "+nombre+"\nEncendido:  "+(encendido?"Si":"No")+"\nTipo: "+tipo+"\nRAM: "+ram+"\nHD: "+hd+" GB\nProcesador: "+procesador+
                "\nCamara:\nApertura: "+ camara.apertura+"\nMegapixeles: "+ camara.megapixeles+"\nMarca "+camara.marca);
    }
}
