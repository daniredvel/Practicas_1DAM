package Proyecto_reservas.bd;

public class InfoError {
    public static final int OK = 0;
    public static final int FALLO_DRIVER = 1;
    public static final int FALLO_CONEXION = 2;
    public static final int FALLO_CERRAR_CONEXION = 3;
    public static final int NOMBRE_DEPARTAMENTO_DUPLICADO = 4;
    public static final int ERROR_INSERT = 5;
    public static final int ERROR_DELETE = 6;
    public static final int ERROR_SELECT = 7;
    public static final int DEPARTAMENTO_NO_ENCONTRADO = 8;
    public static final int COD_DEPARTAMENTO_DUPLICADO = 9;
    public static final int COD_SALA_DUPLICADA = 10;
    public static final int NOMBRE_SALA_DUPLICADA = 11;
    public static final int SALA_NO_ENCONTRADA = 12;
    public static final int RESERVA_DUPLICADA = 13;
    public static final int RESERVA_NO_ENCONTRADA = 14;





    private static final String[] MENSAJE = {
            "Correcto",
            "Error al conectar con la base de datos. Fallo en el conector",
            "Error al conectar con la base de datos",
            "No se pudo cerrar la conexión",
            "Ya hay un departamento con ese nombre",
            "No se pudieron añadir los datos a la base de datos",
            "No se pudieron borrar los datos",
            "No se pudieron consultar los datos",
            "No se encontró el departamento",
            "Ya existe ese código de departamento",
            "Ya existe ese código de sala",
            "Ya existe ese nombre de sala",
            "Sala no encontrada",
            "La sala está reservada en esa fecha",
            "No hay reservas de esa sala en esa fecha"
    };

    public static String getMensaje(int codigo){
        return MENSAJE[codigo];
    }
}
