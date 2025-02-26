package Proyecto_juegoDB.Util;

import bd.Poblacion;

import javax.swing.plaf.IconUIResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilBD {
    public static Poblacion[] obtenerPoblaciones(int poblacion, Connection conexion){
        String sql = "SELECT l.nombre AS nombre, p.nombre AS provincia FROM localidades l JOIN provincias p USING(n_provincia) WHERE poblacion >= ?;";
        PreparedStatement ps;
        ResultSet rs;
        ArrayList <Poblacion> alMunicipios = new ArrayList<>();
        int cont=0;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1,poblacion);

            rs = ps.executeQuery();

            while (rs.next()){
                alMunicipios.add(new Poblacion(rs.getString("nombre"), rs.getString("provincia")));
                cont++;
            }
            if (cont > 50) {
                Poblacion [] municipios = new Poblacion [cont];

                for (int i = 0; i < cont; i++) {
                    municipios [i] = alMunicipios.iterator().next();
                }

                return municipios;
            }
            else {
               return null;
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        return null;}

    }
}
