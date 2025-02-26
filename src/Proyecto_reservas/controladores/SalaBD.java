package Proyecto_reservas.controladores;

import bd.GestorConexion;
import bd.InfoError;
import modelos.Sala;

import java.sql.*;


public class SalaBD extends ControlBD{

    public static boolean insertar(Sala sala){
        Connection conexion = GestorConexion.getConexion();
        try{
            PreparedStatement ps = conexion.prepareStatement(
                    "INSERT INTO salas(cod_sala,nombre) " +
                            "VALUES(?,?)"
            );
            ps.setString(1,sala.getCodSala());
            ps.setString(2,sala.getNombre());
            ps.executeUpdate();
            error = InfoError.OK;
            return true;
        }
        catch(SQLException sqle){
            if(sqle.getErrorCode()==1062) {
                if (sqle.getMessage().contains("PRIMARY"))
                    error = InfoError.COD_SALA_DUPLICADA;
                else
                    error = InfoError.NOMBRE_SALA_DUPLICADA;
            }
            else
                error = InfoError.ERROR_INSERT;
            return false;
        }
    }

    public static boolean eliminar(String codSala){
        Connection conexion = GestorConexion.getConexion();
        try{
            PreparedStatement ps = conexion.prepareStatement(
                    "DELETE FROM salas WHERE cod_sala=?"
            );
            ps.setString(1,codSala);
            if(ps.executeUpdate()>0){
                error = InfoError.OK;
                return true;
            }
            else{
                error = InfoError.SALA_NO_ENCONTRADA;
                return false;
            }
        }
        catch(SQLException sqle){
            error = InfoError.ERROR_DELETE;
            return false;
        }
    }

    public static boolean listar(){
        Connection conexion = GestorConexion.getConexion();
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT cod_sala,nombre " +
                    "FROM salas");
            int cont = 0;
            System.out.println("Lista de Salas: ");
            while(rs.next()){
                cont++;
                System.out.println("\t"+rs.getString("cod_sala") + " - " + rs.getString("nombre"));
            }
            if(cont==0){
                System.out.println("No hay salas");
            }
            error = InfoError.OK;
            return true;
        }
        catch(SQLException sqle){
            error = InfoError.ERROR_SELECT;
            return false;
        }
    }

    public static Sala buscar(String codSala){
        Connection conexion = GestorConexion.getConexion();
        try{
            PreparedStatement ps = conexion.prepareStatement(
                    "SELECT nombre FROM salas WHERE cod_sala=?"
            );
            ps.setString(1,codSala);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                error = InfoError.OK;
                return new Sala(codSala,rs.getString("nombre"));
            }
            else{
                error = InfoError.SALA_NO_ENCONTRADA;
                return null;
            }
        }
        catch(SQLException sqle){
            error = InfoError.ERROR_SELECT;
            return null;
        }
    }

}
