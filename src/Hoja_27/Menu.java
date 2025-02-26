package Hoja_27;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;

public class Menu {
    private int opción;
    private static String lista;
    private TreeSet<Festivo> listaFestivos;
    public Menu(String lista){
        Menu.setLista(lista);
        listaFestivos = new TreeSet<>(new ComparadorFestivos());
    }
    public static void setLista(String lista) {
        Menu.lista = lista;
    }
    public void opcion(){
        do {
            try {
                System.out.println(lista);
                Scanner in = new Scanner(System.in);
                System.out.println("Opción:");
                this.opción = Integer.parseInt(in.nextLine());
                Festivo f;
                if (opción == 1) {
                     f = Festivo.nuevoFestivo();
                     if (Util.añadir(f, listaFestivos)) System.out.println("Añadido");
                     else System.out.println("Ya existe ese festivo");
                } else if (opción == 2) {
                    if (!listaFestivos.isEmpty()) {
                        f = Festivo.nuevoFestivo();
                        if (Util.eliminar(f, listaFestivos)) System.out.println("Eliminado");
                        else System.out.println("Ese festivo no existe");
                    } else System.out.println("Lista vacía");
                } else if (opción == 3) {
                    if (!listaFestivos.isEmpty()) {
                        Util.listar(listaFestivos);
                    } else System.out.println("Lista vacía");
                } else if (opción == 4) {
                    if (!listaFestivos.isEmpty()) {
                        f = Festivo.nuevoFestivo();
                        System.out.println(Util.buscar(f, listaFestivos));
                    } else System.out.println("Lista vacía");
                }
            } catch (NoSuchFieldError e){
                System.out.println("Error");
            }
        } while (opción!=5);
    }
}
