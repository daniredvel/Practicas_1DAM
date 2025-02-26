package Examenes.E_Tema9.Util;

import DB.GestorConexion;
import Models.Pensamiento;

import java.sql.*;
import java.time.LocalDateTime;

public class UtilUsuario {

    public static void listarPensamiento(){
        Connection con = GestorConexion.getConexion();

        PreparedStatement ps;
        ResultSet rs;

        try {
            String sql = "select * from pensamientos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Pensamiento p = new Pensamiento();
            while (rs.next()){
                p.setUsuario(rs.getString("nombre"));
                p.setCodigo(rs.getInt("cod_pensamiento"));
                p.setPensamiento(rs.getString("pensamiento"));
                p.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                System.out.println(p);
            }
        }catch (SQLException sqle){
            System.out.println("Error al listar los pensamientos");
        }
    }
    public static String anadirPensamiento(String usuario, String pensamiento){
        Connection con = GestorConexion.getConexion();
        String sql="INSERT INTO pensamientos VALUES (?,?,?,?)";
        LocalDateTime fecha = LocalDateTime.now();
        PreparedStatement ps;
        int codigo = fecha.getDayOfYear()+ fecha.getYear()+ fecha.getHour()+fecha.getSecond()+fecha.getMinute();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setInt(2,codigo);
            ps.setString(3, pensamiento);
            ps.setTimestamp(4, Timestamp.valueOf(fecha));
            ps.executeUpdate();
            return "Pensamiento añadido con exito";

        } catch (SQLException sqle){
            return "Error al añadir el pensamiento";
        }
    }
}
