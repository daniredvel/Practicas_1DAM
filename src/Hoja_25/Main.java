package Hoja_25;

public class Main {
    public static void main(String[] args) {
        //Cuantos moviles añade
        int añadirMoviles=50;
        //Cuantos pc añade
        int añadirPC=25;
        //Cuantos ordenadores hay
        int cont=0;
        Empresa infoValladolid = new Empresa("infoValladolid S.A.");
        //Crear los ordenadores
        for (int i = 0; i < añadirPC; i++) {
            if (i%2!=0){
                Portatil portatil = new Portatil(("PC"+(i+1)),16,1024,"i5",3);
                infoValladolid.añadirOrdenador(portatil);
            }else {
                Ordenador ordenador = new Ordenador(("PC"+(i+1)),16,1024,"i5");
                infoValladolid.añadirOrdenador(ordenador);
            }
            cont++;
        }
        //Crear moviles
        for (int i = 0; i < añadirMoviles; i++) {
            Movil movil = new Movil(("MB"+(i+1)),8,256,"Snapdragon 8 Gen 2","5G",2.2,12,"Carl Zeiss");
            infoValladolid.añadirOrdenador(movil);
            cont++;
        }
        //Encender todos
        infoValladolid.encenderTodo();
        //Retirar solo los pc
        infoValladolid.retirarPcs(20);
        //aux recoge cuantos ordenadores hay añadidos
        int aux = añadirPC;
        //Cuantos ordenadores se van a añadir
        añadirPC=20;
        for (int i = aux; i < añadirPC+aux; i++) {
                Portatil portatil = new Portatil(("PC"+(i+1)),16,1024,"i5",3);
                infoValladolid.añadirOrdenador(portatil);
                cont++;
        }
        //Desordenar la lista
        infoValladolid.revolver();
        //Renombrar los ordenadores como "COMP00", asignado n al número de su indice en el array +1 (para que empiece en 1)
        infoValladolid.renombrar("COMP");
        //Ampliar la memoria de los discos de los portatiles
        infoValladolid.ampliarDiscoPortatil(2048);
    }
}
