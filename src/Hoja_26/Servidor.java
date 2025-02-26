package Hoja_26;

public class Servidor extends Ordenador{
    private int tipo;
    /*
    * 1 para Windows - valor por defecto
    * 2 para Linux
    */
    public Servidor (String nombre){
        super(nombre);
    }
    public Servidor (int ip1, int ip2, int ip3, int ip4, int bitsRED){
        super(ip1, ip2, ip3, ip4, bitsRED);
    }
    public Servidor (int ip1, int ip2, int ip3, int ip4, int bitsRED, String nombre){
        super(ip1, ip2, ip3, ip4, bitsRED, nombre);
    }

    public void setTipo(int tipo) {
        //Se valida que el tipo de Servidor se 1 (Windows) o 2 (Linux), no se aceptan más valores
        if (2>=tipo && tipo>0) this.tipo = tipo;
        else System.out.println("Error, tipo no valido");
    }

    public int getTipo() {
        return tipo;
    }
}
