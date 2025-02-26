package Proyecto_juegoDB.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    /**
     * Clase que se encarga de gestionar la conexión con la base de datos.
     */
    public class GestorConexion {
        /**
         * Objeto estático de conexión con la base de datos.
         */
        private static Connection conexion=null;


        /**
         * Método que crea una conexión con la base de datos.
         * @param bd Nombre de la base de datos.
         * @param usr Usuario de la base de datos.
         * @param pass Contraseña del usuario de la base de datos.
         * @return Código de error.
         */
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
                sqle.printStackTrace();
                return InfoError.FALLO_CONEXION;
            }
        }

        /**
         * Método que devuelve la conexión con la base de datos.
         * @return Conexión con la base de datos.
         */
        public static Connection getConexion() {
            return conexion;
        }

        /**
         * Método que cierra la conexión con la base de datos.
         * @return Código de error.
         */
        public static int cerrarConexion(){
            try {
                conexion.close();
                return InfoError.OK;
            }
            catch(SQLException | NullPointerException sqle){
                return InfoError.FALLO_CERRAR_CONEXION;
            }
        }
    }


