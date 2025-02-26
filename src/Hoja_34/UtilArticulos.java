package Hoja_34;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilArticulos {
    public static String anadirArticulo(Connection con,String categoria, String clave, String nombre, int precio){

        String sqlInsert, sqlSelect;
        sqlInsert = "INSERT INTO ARTICULOS(clave, nombre, precio, id_categoria) VALUES (?,?,?,?);";
        sqlSelect = "SELECT id_categoria FROM CATEGORIAS WHERE nombre = ?;";
        PreparedStatement ps;
        ResultSet rs;
        int n_cat;
        try {
            //Obtenemos el id_categoria
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1,categoria);
            rs = ps.executeQuery();
            rs.next();
            n_cat = rs.getInt("id_categoria");
            if (UtilArticulos.validacionArticulos(con, clave, categoria) == 1 || (UtilArticulos.validacionArticulos(con, clave, categoria) == -2)){
                ps = con.prepareStatement(sqlInsert);
                ps.setString(1, clave);
                ps.setString(2, nombre);
                ps.setInt(3, precio);
                ps.setInt(4, n_cat);
                ps.executeUpdate();
                ps.close();
                return "Articulo añadido";
            } else if (UtilArticulos.validacionArticulos(con, clave, categoria) == -1)return "Ya existe un articulo con esa clave";
            else return "Error";


        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            return "Error al añadir el articulo";
        }
    }
    private static byte validacionArticulos(Connection con, String clave, String categoria){

        /*
        *
        * Respuestas:
        * La clave existe: 0
        * La clave no existe: 1
        * Error de SQL: -1
        * Base de datos vacía: -2
        *
        */

        String sqlSelectArticulo = "SELECT clave FROM ARTICULOS WHERE id_categoria = ?;",
                claveBD;

        PreparedStatement ps;
        ResultSet rs;
        int n_cat;
        try {
            n_cat = UtilArticulos.obtnerID(con,categoria);


            ps = con.prepareStatement(sqlSelectArticulo);
            ps.setInt(1,n_cat);
            rs = ps.executeQuery();
            rs.next();
            claveBD = rs.getString("clave");

            if (claveBD.equalsIgnoreCase(clave)) return 0;
            else return 1;

        }catch (SQLException sqle){
            if (sqle.getMessage().contains("empty")) return -2;
            else return -1;
        }
    }

    public static String eliminarArticulo(Connection con,String categoria, String clave){
        String sqlSelect = "SELECT id_categoria FROM CATEGORIAS WHERE nombre = ?;",
                sqlDelete = "DELETE FROM ARTICULOS WHERE clave = ? && id_categoria = ?;";
        PreparedStatement ps;
        ResultSet rs;
        int n_cat;
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1,categoria);
            rs = ps.executeQuery();
            rs.next();
            n_cat = rs.getInt("id_categoria");

            if (UtilArticulos.validacionArticulos(con, clave, categoria) == 0){
                ps = con.prepareStatement(sqlDelete);
                ps.setString(1,clave);
                ps.setInt(2,n_cat);
                ps.executeUpdate();
                ps.close();
                return "Articulo eliminado";
            } else if (UtilArticulos.validacionArticulos(con, clave, categoria) == 1) return "No existe un articulo con esa clave";
              else if (UtilArticulos.validacionArticulos(con, clave, categoria) == -1) return "Error al eliminar el Articulo";
              else return "No existen articulos";


        }catch (SQLException sqle){
            return "Error al añadir el articulo";
        }

    }

    public static String listarTodosArticulos(Connection con){
        String  sqlSelect = "SELECT A.nombre AS nombre, CLAVE, C.NOMBRE AS categoria, PRECIO FROM ARTICULOS A JOIN CATEGORIAS C USING (id_categoria);";
        StringBuilder res=new StringBuilder();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();


            while (rs.next()){
                        res.append("Clave: ").append(rs.getString("clave")).append(", ")
                        .append("Nombre: ").append(rs.getString("nombre")).append(", ")
                        .append("Precio: ").append(rs.getInt("precio")).append(", ")
                        .append("Categoria: ").append(rs.getString("categoria")).append("\n\n");
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return res.toString();
    }
    private static int obtnerID(Connection con, String categoria){
        String sqlSelectCat="SELECT id_categoria FROM CATEGORIAS WHERE nombre = ?;";
        PreparedStatement psCat;
        ResultSet rsCat;
        try {
            psCat = con.prepareStatement(sqlSelectCat);
            psCat.setString(1,categoria);
            rsCat = psCat.executeQuery();
            rsCat.next();
            return rsCat.getInt("id_categoria");
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            return -1;
        }

    }
    public static String listarArticulosCategoria(Connection con, String categoria){
        String  sqlSelect = "SELECT nombre, CLAVE, PRECIO FROM ARTICULOS WHERE id_categoria=?;";
        StringBuilder res=new StringBuilder();

        PreparedStatement ps;
        ResultSet rs;

        int n_cat;
        try {
            n_cat = UtilArticulos.obtnerID(con,categoria);

            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1,n_cat);
            rs = ps.executeQuery();


            while (rs.next()){
                        res.append("Clave: ").append(rs.getString("clave")).append(", ")
                        .append("Nombre: ").append(rs.getString("nombre")).append(", ")
                        .append("Precio: ").append(rs.getInt("precio")).append("\n\n");
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return res.toString();
    }

    public static String atributosArticulo(Connection con, String clave){
        PreparedStatement ps;
        String sql = "SELECT clave, nombre, precio FROM ARTICULOS WHERE clave = ?;";
        ResultSet rs;
        StringBuilder res = new StringBuilder();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            res.append("Clave: ").append(rs.getString("clave")).append(", ")
                    .append("Nombre: ").append(rs.getString("nombre")).append(", ")
                    .append("Precio: ").append(rs.getInt("precio")).append("\n\n");
        } catch (SQLException sqle){
            res = new StringBuilder().append("Error al listar los datos del Articulo: ").append(clave);
        }
        return res.toString();
    }

    //public static String modificarArticulo(String categoria, String nombre, String clave, int id_categoria, int precio, Connection con){
    public static String modificarArticulo(String clave, Connection con){
        //String sql = "SELECT C.NOMBRE AS categoria, A.nombre AS nombre, CLAVE, id_categoria, PRECIO FROM ARTICULOS A JOIN CATEGORIAS C USING (id_categoria) WHERE clave = ?;";
        String sql = "SELECT  nombre , CLAVE, id_categoria, PRECIO FROM ARTICULOS  WHERE clave = ?;";

        StringBuilder res = new StringBuilder();

        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,clave);
            ps.executeUpdate();

            rs = ps.executeQuery();
            while (rs.next()){
                res.append("Nombre: ").append(rs.getString("nombre")).append(", ")
                        .append("Clave: ").append(rs.getString("CLAVE")).append(", ")
                        .append("id_categoria: ").append(rs.getInt("id_categoria")).append(", ")
                        .append("precio: ").append(rs.getInt("precio")).append(", ");
            }
            ps.close();


        }catch (SQLException sqle){
            res = new StringBuilder().append(sqle.getMessage());
        }

        //Articulo a = new Articulo(categoria,nombre,clave,id_categoria,precio);
        System.out.println(res);
        return res.toString();
    }
   // public static String modificarClave(){

   //}
}