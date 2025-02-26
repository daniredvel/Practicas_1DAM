package Examenes.E_Tema9.Util;

import DB.GestorConexion;
import DB.InfoError;
import Models.Pensamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilMenu {
    public static String borrarUsuario(String usuario){
        Connection con = GestorConexion.getConexion();
        String sql = "delete from usuarios where nombre=?;";

        PreparedStatement ps;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.executeUpdate();
            return "Usuario borrado correctamente";


        }catch (SQLException sqle){
            return InfoError.getMensaje(InfoError.ERROR_BORRAR);
        }

    }
    public static byte buscarUser(String usuario){
        Connection con = GestorConexion.getConexion();
        //0 para lista vacía
        //1 para usuario encontrado
        //-1 para usuario no encontrado

        String sql = "SELECT * FROM usuarios WHERE nombre = ?;";

        PreparedStatement ps;
        ResultSet rs;

        try{
        ps = con.prepareStatement(sql);
        ps.setString(1,usuario);
        rs = ps.executeQuery();
        if (listaVacia() == 0) return 0;
        else if (listaVacia() == -1) return -1;
        else {
            if (rs.next()) return 1;
            else return -1;
        }

        }catch (SQLException sqle){
            return -1;
        }


    }
    private static byte listaVacia(){
        Connection con = GestorConexion.getConexion();

        //0 para lista vacía
        //1 para lista no vacia
        //-1 para excepción

        String sql = "SELECT * FROM usuarios;";

        PreparedStatement ps;
        ResultSet rs;

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) return 1;
            else return 0;

        }catch (SQLException sqle){
            return -1;
        }
    }
    public static boolean anadirUsuario(String usuario){
        Connection con = GestorConexion.getConexion();
        if (buscarUser(usuario)!=1){
            String sql = "INSERT INTO usuarios VALUES (?);";

            PreparedStatement ps;

            try{
                ps = con.prepareStatement(sql);
                ps.setString(1,usuario);
                ps.executeUpdate();
                return true;

            }catch (SQLException sqle){
                return false;
            }
        } else return false;
    }
    public static void listarUsuario(){
        Connection con = GestorConexion.getConexion();

        PreparedStatement ps;
        ResultSet rs;

        try {
            String sql = "select * from usuarios";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Usuario: " + rs.getString("nombre"));
            }
        }catch (SQLException sqle){
            System.out.println("Error al listar los usuarios");
        }
    }
}
