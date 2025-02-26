package Hoja_35.bd;
import modelos.Localidad;
import java.sql.*;
/**
 * Clase que contiene métodos para interactuar con la base de datos de localidades
 */
public class LocalidadBD {
    /**
     * Almacena, de manera estática, el código de error
     * acaecido durante la última operación sobre
     * la base de datos
     */
    private static int error = InfoError.OK;

    /**
     * Devuelve el código de error de la última operación
     * @return El código de error
     */
    public static int getError(){
        return error;
    }

    /**
     * Muestra el mensaje de error correspondiente al último error ocurrido
     */
    public static void mostrarError(){
        System.out.println(InfoError.getMensaje(error));
    }

    /**
     * Busca una localidad en la base de datos
     * @param nombre String con el nombre de la localidad a buscar
     * @return Un objeto Localidad con los datos de la localidad o null si no la encuentra o hay un error
     */
    public static Localidad buscarLocalidad(String nombre){
        Connection con = GestorConexion.getConexion();
        try{
            String sql = """
                    SELECT l.nombre AS nombre, p.nombre provincia,
                           c.nombre comunidad, poblacion
                    FROM localidades l
                    JOIN provincias p USING(n_provincia)
                    JOIN comunidades c USING(id_comunidad)
                    WHERE l.nombre = ?""";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Localidad(
                    rs.getString("nombre"),
                    rs.getInt("poblacion"),
                    rs.getString("provincia"),
                    rs.getString("comunidad")
                );
            }
            else{
                error = InfoError.LOCALIDAD_NO_ENCONTRADA;
                return null;
            }
        }
        catch(SQLException sqle){
            error = InfoError.FALLO_CONSULTA;
            return null;
        }
    }

    /**
     * Devuelve la población de una provincia
     * @param provincia String con el nombre de la provincia a buscar
     * @return La población de la provincia o -1 si no encuentra la provincia
     */
    public static int poblacionProvincia(String provincia){
        Connection con = GestorConexion.getConexion();
        try{
            String sql = """
                    SELECT SUM(poblacion) ASpoblacion
                    FROM localidades l
                    JOIN provincias p USING(n_provincia)
                    WHERE p.nombre = ?""";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,provincia);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int res = rs.getInt("poblacion");
                if(res == 0){ //Devuelve cero la suma si esa provincia no existe
                    error = InfoError.PROVINCIA_NO_ENCONTRADA;
                    return -1;
                }
                else {
                    error = InfoError.OK;
                    return res;
                }
            }
            else{
                error = InfoError.PROVINCIA_NO_ENCONTRADA;
                return -1;
            }
        }
        catch(SQLException sqle){
            error = InfoError.FALLO_CONSULTA;
            return -1;
        }
    }

    public static int poblacionComunidad(String comunidad){
        Connection con = GestorConexion.getConexion();
        try{
            String sql = """
                    SELECT SUM(poblacion) AS poblacion
                    FROM localidades l
                    JOIN provincias p USING(n_provincia)
                    JOIN comunidades c USING(id_comunidad)
                    WHERE c.nombre = ?""";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,comunidad);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int res = rs.getInt("poblacion");
                if(res == 0){ //Devuelve cero la suma si esa provincia no existe
                    error = InfoError.COMUNIDAD_NO_ENCONTRADA;
                    return -1;
                }
                else {
                    error = InfoError.OK;
                    return res;
                }
            }
            else{
                error = InfoError.COMUNIDAD_NO_ENCONTRADA;
                return -1;
            }
        }
        catch(SQLException sqle){
            error = InfoError.FALLO_CONSULTA;
            return -1;
        }
    }

    /**
     * Devuelve una localidad aleatoria
     * @return Un objeto Localidad con los datos de la localidad o null si hay un error o no se encuentra la localidad
     */
    public static Localidad localidadAleatoria(){
        Connection con = GestorConexion.getConexion();
        try{
            String sql = """
                    SELECT l.nombre AS nombre, p.nombre provincia,
                           c.nombre comunidad, poblacion
                    FROM localidades l
                    JOIN provincias p USING(n_provincia)
                    JOIN comunidades c USING(id_comunidad)
                    ORDER BY RAND()
                    LIMIT 1""";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Localidad(
                        rs.getString("nombre"),
                        rs.getInt("poblacion"),
                        rs.getString("provincia"),
                        rs.getString("comunidad")
                );
            }
            else{
                return null;
            }
        }
        catch(SQLException sqle){
            error = InfoError.FALLO_CONSULTA;
            return null;
        }
    }

    /**
     * Devuelve el número de localidades con menos de un número de habitantes
     * @param habitantes Número de habitantes
     * @return El número de localidades con menos de habitantes o -1 si hay un error
     */
    public static int localidadesMenos(int habitantes){
        Connection con = GestorConexion.getConexion();
        try{
            String sql = """
                    SELECT COUNT(*) numero
                    FROM localidades
                    WHERE poblacion < ?""";
            int numero;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,habitantes);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                numero = rs.getInt("numero");
                error = InfoError.OK;
                return numero;
            }
            else{
                error = InfoError.FALLO_CONSULTA;
                return -1;
            }
        }
        catch (SQLException sqle){
            error = InfoError.FALLO_CONSULTA;
            return -1;
        }
    }
    /**
     * Devuelve el número de localidades con más de un número de habitantes
     * @param habitantes Número de habitantes
     * @return El número de localidades con más de habitantes o -1 si hay un error
     */
    public static int localidadesMas(int habitantes){
        Connection con = GestorConexion.getConexion();
        try{
            String sql = """
                    SELECT COUNT(*) numero
                    FROM localidades
                    WHERE poblacion > ?""";
            int numero;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,habitantes);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                numero = rs.getInt("numero");
                error = InfoError.OK;
                return numero;
            }
            else{
                error = InfoError.FALLO_CONSULTA;
                return -1;
            }
        }
        catch (SQLException sqle){
            error = InfoError.FALLO_CONSULTA;
            return -1;
        }
    }
}
