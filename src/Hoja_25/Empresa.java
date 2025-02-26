package Hoja_25;

import java.util.Objects;

public class Empresa {
    public String nombre;
    private int marca;
    private static final int TAM = 500;
    private Ordenador[] listaOrdenadores;
    public Empresa(String nombre){
        this.nombre=nombre;
        listaOrdenadores =new Ordenador[TAM];
        marca=0;
    }
    public Ordenador[] getListaOrdenadores() {
        return listaOrdenadores;
    }

    public void añadirOrdenador(Ordenador ordenador){
        if (marca<=TAM){
            listaOrdenadores[marca]= ordenador;
            marca++;
        }
    }
    public void retirar(Ordenador ordenador){
        int posicionRetirar=-1;
        for (int i = 0; i <marca; i++) {
            if (listaOrdenadores[i]==ordenador) posicionRetirar=i;
        }
        ordenar(posicionRetirar);
    }
    public void retirar(String nombreOrdenador){
        int posicionRetirar=-1;
        for (int i = 0; i <marca; i++) {
            if (Objects.equals(listaOrdenadores[i].nombre, nombreOrdenador)) posicionRetirar=i;
        }
        ordenar(posicionRetirar);
    }

    //Ordena la lista desplazando los elementos hacia la izquierda a partir del null
    private void ordenar(int posicionRetirar) {
        if (posicionRetirar!=-1){
            if (marca>0){
                listaOrdenadores[posicionRetirar]= null;
                for (int i = posicionRetirar; i < marca-1; i++) {
                    listaOrdenadores[i]=listaOrdenadores[i+1];
                }
                marca--;
            }
        }else System.out.println("Máquina no encontrada");
    }
    public void escribir(){
        for (int i = 0; i < marca; i++) {
            listaOrdenadores[i].escribir();
        }
    }

    //La propiedad encendido, true
    public void encenderTodo(){
        for (int i = 0; i < marca; i++) {
            listaOrdenadores[i].encender();
        }
    }
    public void retirarPcs(int cantidad){
        boolean salida=false; //Centinela que vigila que se haya llegado al máximo de pc pese a no haber revisado toda la lista
        byte cont=0;
        for (int i = 0; i < marca||salida; i++) {
            //Sale del bucle una vez haya revisado toda la lista o retirado la cantidad de pc indicada
            if (!(listaOrdenadores[i] instanceof Movil) || !(listaOrdenadores[i] instanceof Portatil)){
                //Si no es Móvil o Portatil es simplemente un Ordenador
                        //Si es  un Ordenador no movil ni portatil, le elimina
                         listaOrdenadores[i]=null;
                         //Ordena la lista
                         ordenar(i);
                         //Cuenta cuantos ordenadores se han retirado
                         cont++;
            }
            //Centinela de cantidad maxima
            if (cont>=cantidad) salida=true;
        }
        //Info cantidad ordenadores eliminados, puede que en la lista haya menos pcs que los indicados a retirar
        System.out.println("Ordenadores retirados " + cont);
    }
    //Shuffle
    public void revolver(){
        int n_random1=(int) (Math.random()*TAM);
        int n_random2=(int) (Math.random()*TAM);
        for (int i = 0; i < 50; i++) {
            Ordenador aux = listaOrdenadores[n_random1];
            listaOrdenadores[n_random1]=listaOrdenadores[n_random2];
            listaOrdenadores[n_random2]=aux;
        }
    }
    //Renombrar todos los elementos de la lista
    public void renombrar(String new_name){
        for (int i = 0, j = 1; i < marca; i++,j++) {
            listaOrdenadores[i].nombre=(new_name+""+j);
        }
    }
    public void ampliarDiscoPortatil(int new_disco){
        for (int i = 0; i < marca; i++) {
            //Si el ordenador es un portaatil amplia su disco
            if (listaOrdenadores[i] instanceof Portatil) listaOrdenadores[i].hd=new_disco;
        }
    }
    //Ejemplo de uso de getClass
    public void ampliarDisco(int disco, Ordenador clase){
        for (int i = 0; i < marca; i++) {
            if (clase.getClass().equals("class Movil")){
                listaOrdenadores[i].hd=disco;
            }
            else if (clase.getClass().equals("class Portatil")){
                listaOrdenadores[i].hd=disco;
            }
            else {
                listaOrdenadores[i].hd=disco;
            }
        }
    }
}