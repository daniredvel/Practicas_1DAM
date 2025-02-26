package Hoja_24;

import java.util.Objects;

public class Almacen {
    private String nombre;
    private int tamaño;
    private Articulo[] articulos;
    private int marca;
    private static final int TAM=30;
    public Almacen(String nombre, int tamaño){
        marca=0;
        this.nombre=nombre;
        this.tamaño=tamaño;
        articulos=new Articulo[TAM];
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarArticulos(){
        for (int i = 0; i <TAM; i++) {
            if (i!=(TAM-1)) System.out.print(articulos[i].getNombre()+", ");
            else System.out.print(articulos[i].getNombre()+".");
        }
    }

    //Añadir articulos, cantidad igual a cero
    public void añadirArticulos(String nombre, String descripcion, int clave){
        if (marca<TAM){
            articulos[marca]=new Articulo(nombre, descripcion, clave);
            marca++;
        } else System.out.println("El almacen esta lleno");
    }


    //Añadir articulos incluyendo la cantidad
    public void añadirArticulos(String nombre, String descripcion, int clave, int cantidad){
        if (marca<TAM){
            articulos[marca]=new Articulo(nombre, descripcion, clave, cantidad);
            marca++;
        } else System.out.println("El almacen esta lleno");
    }
    /*
    * Retirar el articulo indicando la cantidad
    *
    * En caso de que la cantidad retirada sea igual a la cantidad total,
    * borra el articulo del almacen.
    *
    * Más tarde desplaza todos los articulos una posición menos
    * eliminando el articulo borrado, colocando un null al final de la lista
     */

    public void retirarArticulo (int clave, int cantidad) {
        int marcaRetirar=0; //Esta variable almacena el valor de la posición del Articulo
        if (articulos[0] != null) {
            //Comprobamos que la lista no este vacia
            for (int i = 0; i < marca; i++) {
                //Buscamos el Articulo por la clave
                if ((Objects.equals(articulos[i].getClave(), clave)))
                    marcaRetirar = i; //Almacenamos la posición del Articulo
                if (articulos[marcaRetirar].getCantidad()<=cantidad){
                    //Comprobamos la cantidad del Articulo
                    articulos[marcaRetirar].setCantidad(articulos[marcaRetirar].getCantidad()-cantidad);
                    //Quitamos la cantidad del articulo indicada
                    if  (cantidad==articulos[marcaRetirar].getCantidad()) {
                        //Si la cantidad ha sido la cantidad que tenemos de Articulo, retiramos el Articulo
                        for (int j = marcaRetirar; j < marca ; j++) {
                            //Desplazamos el articulo una posición menos, eliminando el articulo
                            if (j+1<marca){
                                articulos[j]=articulos[j+1];
                                //El ultimo articulo de la lista le igualamos a null.
                                //Asi evitamos articulos duplicados
                            } else articulos[j]=null;
                        }
                        //Un articulo menos, una posición menos
                        marca--;
                    }
                } else System.out.println("No hay tanta cantidad de este articulo.\nLa cantidad de este articulo es: " +  articulos[marcaRetirar]);
            }
        }
    }
    public void retirarArticulo (int clave) {
        //Esta variable almacenara la posición del articulo a retirar
        int marcaRetirar = 0;
        //Comprobamos si la lista no esta vacia
        if (articulos[0] != null) {
            for (int i = 0; i < marca; i++) {
                //Recorremos el array en busca del articulo a retirar a través de la clave
                if ((Objects.equals(articulos[i].getClave(), clave)))
                    //Una vez encontrado el articulo almacenaremos la posición en la variable
                    marcaRetirar = i;
                for (int j = marcaRetirar; j < marca; j++) {
                    //Una vez encontrada la posición del Articulo, desplazaremos todos los equipos una posición menos, retirando el articulo citado
                    if (j + 1 < marca) {
                        //Este if evita un error de tipo OutOfBounds, evitando que el j+1, salga del array
                        articulos[j] = articulos[j + 1];
                        //Iguala el articulo anterior al articulo sigiente desplazandose una posición menor
                    } else articulos[j] = null;
                }
                //Un articulo menos, una posición menos
                marca--;
            }
        }
    }
}