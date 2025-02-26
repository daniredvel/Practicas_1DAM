package Hoja_27;

import java.util.ArrayList;
import java.util.Collection;

public class Util {

    static public <Festivo> boolean eliminar(Festivo o, Collection<Festivo> lista) {
        return lista.remove(o);
    }
    static public <Festivo> boolean existe(Festivo o, Collection<Festivo> lista) {
        return lista.contains(o);
    }
    static public String buscar(Festivo o, Collection<Festivo> lista) {
        if (Util.existe(o,lista)){
            return o.getNombre();
        } else return "";
    }
    static public <Festivo> boolean añadir(Festivo o, Collection<Festivo> lista) {
        return lista.add(o);
    }
    static public <Festivo> void listar( Collection<Festivo> lista) {
        if (!lista.isEmpty()) {
            for (Festivo f : lista) {
                System.out.println(f.toString());
            }
        } else System.out.println("Lista vacía");
    }
}
