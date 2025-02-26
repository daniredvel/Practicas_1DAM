package Examenes.E_Tema7;

import java.util.Comparator;

public class ComparadorWifi implements Comparator<Wifi> {

    @Override
    public int compare(Wifi o1, Wifi o2) {
        char c1=o1.getSSID().charAt(0);
        char c2=o2.getSSID().charAt(0);
        if (c1>c2) return 1;
        else if (c2>c1) return -1;
        return 0;
    }
}
