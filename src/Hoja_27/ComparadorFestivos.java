package Hoja_27;

import java.util.Comparator;

public class ComparadorFestivos implements Comparator<Festivo> {
    @Override
    public int compare(Festivo f1, Festivo f2) {
        return f1.getFecha().compareTo(f2.getFecha());
    }
}
