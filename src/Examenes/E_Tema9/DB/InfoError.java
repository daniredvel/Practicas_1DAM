package Examenes.E_Tema9.DB;

public class InfoError {
    //Constantes de error
    public static final int OK = 0;
    public static final int FALLO_DRIVER = 1;
    public static final int FALLO_CONEXION = 2;
    public static final int FALLO_CERRAR_CONEXION = 3;
    public static final int USUARIOS_VACIO = 4;
    public static final int USUARIO_NO_ENCONTRADO = 5;
    public static final int ERROR_BORRAR = 6;


    /**
     * Array de mensajes de error, cada mensaje se relaciona
     * por posición con el código de error correspondiente.
     */
    private static final String[] MENSAJE = {
            "Correcto",
            "Error al conectar con la base de datos. Fallo en el conector",
            "Error al conectar con la base de datos",
            "No se pudo cerrar la conexión",
            "No hay usuarios registrados",
            "El usuario buscado no se ha encontrado",
            "Error al borrar el usuario"
    };

    /**
     * Método que devuelve el mensaje de error correspondiente al código
     * @param codigo Código de error
     * @return Mensaje de error
     */
    public static String getMensaje(int codigo){
        return MENSAJE[codigo];
    }
}
