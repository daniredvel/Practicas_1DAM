package Hoja_34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexion {
    private static Connection conexion = null;
    private static String error = "";

    public static boolean nuevaConexionMySQL(String baseDatos, String usuario, String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDatos,usuario,pass);
            return true;
        } catch (ClassNotFoundException cnfe){
            error = "Error al preparar la conexión con la base de datos";
            return false;
        } catch (SQLException sqle){
            error = "Error al conectar con la base de datos";
            return false;
        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static String getError() {
        return error;
    }
    public static boolean cerrarConexion(){
        try {
            conexion.close();
            return true;
        } catch (SQLException | NullPointerException ex){
            error="No se pudo cerrar la conexión";
            return false;
        }
    }
}
