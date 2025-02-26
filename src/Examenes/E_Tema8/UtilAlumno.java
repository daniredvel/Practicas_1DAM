package Examenes.E_Tema8;

import java.util.ArrayList;

public class UtilAlumno {
    public static boolean buscar(InfoAlumno o, ArrayList <InfoAlumno> lista){
        boolean res=false;
        boolean ret=false;
        for (InfoAlumno a :
                lista) {
            res = a.getCodAlumno() == o.getCodAlumno();
            if (res){
                ret = true;
            }
        }
        return ret;
    }
}
