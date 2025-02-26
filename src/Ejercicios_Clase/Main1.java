package Ejercicios_Clase;

import java.util.*;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        lista.add("Ana");
        lista.add("Diego");
        lista.add("Pablo");
        lista.add("Sonia");
        lista.add("Mateo");
        lista.add("Marta");
        lista.remove("Mateo");
        Iterator iterador = lista.iterator();
        while (iterador.hasNext()){
            System.out.println(iterador.next());
        }
    }
}
