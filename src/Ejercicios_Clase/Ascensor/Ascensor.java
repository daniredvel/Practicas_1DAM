package Ejercicios_Clase.Ascensor;

public class Ascensor {
    private int piso=0;
    public void subir(){
        this.piso++;
    }
    public void bajar() {
        this.piso--;
    }

    //SET -- modifica una propiedad
    public void setPiso(int piso) {
        this.piso = piso;
    }

    //GET -- devuelve el valor de una propiedad
    public int getPiso() {
        //return finaliza el objeto
        return piso;
    }
    public void copiar(Ascensor a){
        this.piso=a.piso;

    }
}


