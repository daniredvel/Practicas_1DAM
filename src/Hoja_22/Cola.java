package Hoja_22;

import java.util.Arrays;

public class Cola {
    private String [] elementos_cola;
    //private final String [] elementos;¿?
    private int posicion_cola=0;
    private static final int MAX=50;
    //Static significa que es una propiedad comun a todos los objetos creados de esa clase.
    public Cola(){
        elementos_cola = new String[MAX];
        //Nuestro constructor crea un Array con tantos elementos como se han indicado antes
    }
    public void add(String nuevo){
        if (!full()){
           elementos_cola[posicion_cola]=nuevo;
           posicion_cola++;
        }
    }
    public String poll(){
        if (!empty()) {
            String elementoAux = elementos_cola[0];
            elementos_cola[0] = null;
            Cola aux = new Cola();
            for (int i = 0; i < posicion_cola; i++) aux.elementos_cola[i] = this.elementos_cola[i];
            //Copia el array en un array euxiliar

            for (int i = posicion_cola, j = posicion_cola - 1; i > 0; i--, j--) {
                this.elementos_cola[j] = aux.elementos_cola[i];
            }
            //Copia el array auxiliar en el array original desplazando cada elemento a la izquierda eliminando un elemento
            posicion_cola--;
            //Restamos un elemento a la posicion , que indica el indice de la cola
            return elementoAux;
            //Devolvemos el elemento guardado previamente, es decir, el elemento eliminado
        } else return null;
        //Si la cola esta vacia no podemos extraer elementos
    }
    public boolean full(){
        return posicion_cola==MAX;
    }
    public boolean empty(){
        return posicion_cola==0;
    }
    public void setEmpty(){
        //Arrays.fill(this.elementos_cola, null);
        posicion_cola=0;
        /*Al poner la posicion a cero, comenzaremos a escribir desde el principio,
         *ignorando los elementos previos y sobreescribiendo sobre estos
         */
    }
    public int avaibe(){
        return MAX-posicion_cola;
    }
    public void list(){
        if (this.elementos_cola[0]!=null){
            for (int i = 0; i < posicion_cola; i++) {
                if (i!=posicion_cola-1) System.out.print(elementos_cola[i]+", ");
                else System.out.print(elementos_cola[i]+".");
            }
            System.out.println();
        }else System.out.println("La cola esta vacia");
    }
}