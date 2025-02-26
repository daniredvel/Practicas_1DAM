package Hoja_22;

import java.util.Arrays;

public class Pila {
    private String [] elementos;
    //private final String [] elementos;¿?
    private int posicion=0;
    private static final int MAX=50;
    //Static significa que es una propiedad comun a todos los objetos creados de esa clase.
    public Pila(){
        int k = 50;
        elementos =new String[k];
    }
    public boolean full(){
        return posicion==MAX;
    }
    public boolean empty(){
        return posicion==0;
    }
    public void push(String introducir){
        if (!full()){
        elementos[posicion]=introducir;
        posicion++;
        }
    }
    public String pop() {
        if (!empty()) {
            String aux = elementos[posicion - 1];
            posicion--;
            elementos[posicion] = null;
            return aux;
        } else return null;
    }
    public void list(){
        if (this.elementos[0]!=null){
            for (int i = 0; i < posicion; i++) {
                if (i!=posicion-1) System.out.print(elementos[i]+", ");
                else System.out.print(elementos[i]+".");
            }
            System.out.println();
        }else System.out.println("La pila esta vacia");
    }
    public Pila add(Pila pila2){
        Pila pila3=new Pila();
        for (int i = 0; i < this.posicion; i++) {
            pila3.push(pila2.elementos[i]);
        }
        //Copia el primer array
        for (int i = 0, j=posicion; i < pila3.posicion|| j < pila3.posicion+posicion; i++, j++) {
            pila3.elementos[j]=this.elementos[i];
        }
        //Copia el segundo array a partir de la posición marcada por el primer array
        return pila3;
    }
    public void setEmpty(){
        //Arrays.fill(elementos, null);
        posicion=0;
    }

    public int available(){
        return MAX-posicion;
    }
    /*
    public void escribir(){
        System.out.println(Arrays.deepToString(this.elementos));
    }
     */
}

