package Hoja_32.H32E01;

import java.util.Comparator;

public class Comparacion  implements Comparator <Vivienda>  {

    @Override
    public int compare(Vivienda o1, Vivienda o2) {
        return Long.compare(o1.getnCatastro(), o2.getnCatastro());

    }
}
