package Proyecto_espacios.BD;

public class InfoError {
    //Constantes de error
    public static final int OK = 0;
    public static final int FALLO_DRIVER = 1;
    public static final int FALLO_CONEXION = 2;
    public static final int FALLO_CERRAR_CONEXION = 3;


    /**
     * Array de mensajes de error, cada mensaje se relaciona
     * por posición con el código de error correspondiente.
     */
    private static final String[] MENSAJE = {
            "Correcto",
            "Error al conectar con la base de datos. Fallo en el conector",
            "Error al conectar con la base de datos",
            "No se pudo cerrar la conexión",
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
