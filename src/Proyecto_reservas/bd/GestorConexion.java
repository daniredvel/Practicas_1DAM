package Proyecto_reservas.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexion {
    private static Connection conexion=null;

    public static int crearConexion(String bd,String usr,String pass){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+bd,
                    usr,
                    pass
            );
            return InfoError.OK;
        }
        catch(ClassNotFoundException cnfe){
            return InfoError.FALLO_DRIVER;
        }
        catch(SQLException sqle){
            return InfoError.FALLO_CONEXION;
        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static int cerrarConexion(){
        try {
            conexion.close();
            return InfoError.OK;
        }
        catch(SQLException sqle){
            return InfoError.FALLO_CERRAR_CONEXION;
        }
    }
}
