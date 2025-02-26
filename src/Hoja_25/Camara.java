package Hoja_25;

public class Camara {
    public double apertura;
    public int megapixeles;
    public String marca;
    public Camara(double apertura, int megapixeles, String marca){
        this.apertura=apertura;
        this.megapixeles=megapixeles;
        this.marca=marca;
    }
    public void escribir(){
        System.out.println("Apertura: "+this.apertura+"\nMegapixeles: "+this.megapixeles+
                "\nMarca: "+marca);
    }
}
