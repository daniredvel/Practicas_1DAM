package Hoja_34;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilCategorias {
    public static String anadirCategoria(String nombre, Connection con){
        String sql,idCat;
        int id_categoria;
        PreparedStatement ps;
        try {
                idCat="SELECT MAX(id_categoria) AS id_categoria FROM categorias";
                ps = con.prepareStatement(idCat);
                ResultSet rs = ps.executeQuery();
                rs.next();
                id_categoria =rs.getInt("id_categoria");
                id_categoria++;
                sql = "INSERT INTO CATEGORIAS(id_categoria, nombre) VALUES (?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1,id_categoria);
                ps.setString(2,nombre);
                ps.executeUpdate();
                ps.close();
                return "Categoria añadida";

        } catch (SQLException sqle){

            if (sqle.getMessage().contains("uk")){
                return "Esa categoría ya existe";
            } else if (sqle.getMessage().contains("Before start of result set")) {
                id_categoria=0;
                try{
                    sql = "INSERT INTO CATEGORIAS(id_categoria, nombre) VALUES (?,?)";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1,id_categoria);
                    ps.setString(2,nombre);
                    ps.executeUpdate();
                    ps.close();
                    return "Categoria añadida";
                } catch (SQLException sqle2){
                    return ("ERROR");
                }
            } else
                return "Error interno";
            }
        }
    public static String eliminarCategoria(String nombre, Connection con){
            PreparedStatement ps;
            try {
            String sql = "SELECT nombre FROM ARTICULOS WHERE id_categoria=(SELECT id_categoria WHERE nombre=?)";
            ps = con.prepareStatement(sql);
                ps.setString(1,nombre);
                ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("nombre");
        } catch (SQLException sqle){
           if (sqle.getMessage().contains("Illegal operation on empty result set.")){
               try {
                   String sql = "DELETE FROM CATEGORIAS WHERE nombre=?";
                   ps = con.prepareStatement(sql);
                   ps.setString(1,nombre);
                   ps.executeUpdate();
                   ps.close();
                   return "Categoria eliminada";
               } catch (SQLException sqle2){
                   System.out.println(sqle2.getMessage());
                   return "Error";
               }
           } else {
               System.out.println(sqle.getMessage());
               return "Elimina los articulos antes de elimianr la categoria: "+nombre;
           }
        }

        }


    public static String listarCategorias(Connection con){
       PreparedStatement ps;
       StringBuilder res= new StringBuilder();
        try {
            String sql = "SELECT nombre FROM categorias";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                res.append(rs.getString("nombre")).append("\n");
            }

        } catch (SQLException sqle){
            res = new StringBuilder(("Error al leer la base de datos"));
        }
        return "Categorias:\n" + res;
    }
    }

