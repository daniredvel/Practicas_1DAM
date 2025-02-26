package Proyecto_espacios.Util;

import DB.GestorConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util_departamentos {
    public static String listarDepartamentos(){
        Connection con = GestorConexion.getConexion();
        PreparedStatement ps;
        StringBuilder res= new StringBuilder();
        try {
            String sql = "SELECT nombre FROM DEPARTAMENTOS";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                res.append(rs.getString("nombre")).append("\n");
            }

        } catch (SQLException sqle){
            res = new StringBuilder(("Error al leer la base de datos"));
        }
        return "Salas:\n" + res;

    }
    public static String anadirDepartamentos(String codigo, String nombre){
        PreparedStatement ps;
        Connection con = GestorConexion.getConexion();
        String sql;
        try{
            sql = "INSERT INTO DEPARTAMENTOS(CODIGO, NOMBRE) VALUES (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo);
            ps.setString(2,nombre);
            ps.executeUpdate();
            ps.close();
            return "Departamento añadida";
        } catch (SQLException sqle2){
            return ("ERROR");
        }
    }
    public static String eliminarDepartamentos(String codigo){
        PreparedStatement ps;
        Connection con = GestorConexion.getConexion();
        String sql;
        try{
            sql = "DELETE FROM departamentos WHERE CODIGO = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo);
            ps.executeUpdate();
            ps.close();
            return "Departamento eliminado";
        } catch (SQLException sqle2){
            return ("ERROR");
        }
    }

    public static String obtenerCod(String nombre) throws SQLException {
        Connection con = GestorConexion.getConexion();
        String sql = "SELECT CODIGO FROM departamentos WHERE NOMBRE = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,nombre);
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            return rs.getString("CODIGO");
        } else return null;
    }
}