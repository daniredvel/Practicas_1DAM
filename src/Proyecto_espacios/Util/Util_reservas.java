package Proyecto_espacios.Util;

import DB.GestorConexion;
import Models.Reserva;

import java.io.EOFException;
import java.sql.*;
import java.time.LocalDateTime;

public class Util_reservas {
    public static String listarReservas(){
        Connection con = GestorConexion.getConexion();
        PreparedStatement ps;
        StringBuilder res= new StringBuilder();
        Reserva reserva = new Reserva();

        try {
            String sql = "SELECT COD_RESERVAS AS CODIGO_RESERVA, COD_DEPARTAMENTO AS CODIGO_DEPARTAMENTO, d.NOMBRE AS DEPARTAMENTO, COD_SALAS AS CODIGO_SALAS, s.NOMBRE AS SALAS, FECHA_INICIO AS INICIO, FECHA_FIN AS FIN " +
                    "FROM reservas r " +
                    "JOIN salas s ON s.CODIGO = COD_SALAS " +
                    "JOIN departamentos d ON d.CODIGO = COD_DEPARTAMENTO;";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //Bucle de lectura de la Base de datos
            while (rs.next()){

                reserva.setCod_reservas(rs.getString("CODIGO_RESERVA"));
                reserva.setCod_departamento(rs.getString("CODIGO_DEPARTAMENTO"));
                reserva.setDepartamento(rs.getString("DEPARTAMENTO"));
                reserva.setCod_salas(rs.getString("CODIGO_SALAS"));
                reserva.setSala(rs.getString("SALAS"));
                reserva.setFechaInicio(rs.getTimestamp("INICIO").toLocalDateTime());
                reserva.setFechaFin(rs.getTimestamp("FIN").toLocalDateTime());

                System.out.println(reserva);
            }


        } catch (SQLException sqle){
            res = new StringBuilder(("Error al leer la base de datos"));
        }
        return res.toString();
    }
    public static String listarReservasDep(String departamento){
        Connection con = GestorConexion.getConexion();
        PreparedStatement ps;
        StringBuilder res= new StringBuilder();
        Reserva reserva = new Reserva();

        try {
            String sql = "SELECT COD_RESERVAS AS CODIGO_RESERVA, COD_DEPARTAMENTO AS CODIGO_DEPARTAMENTO, d.NOMBRE AS DEPARTAMENTO, COD_SALAS AS CODIGO_SALAS, s.NOMBRE AS SALAS, FECHA_INICIO AS INICIO, FECHA_FIN AS FIN" +
                    "                    FROM reservas r" +
                    "                    JOIN salas s ON s.CODIGO = COD_SALAS" +
                    "                    JOIN departamentos d ON d.CODIGO = COD_DEPARTAMENTO" +
                    "                    WHERE d.nombre = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1,departamento);
            ResultSet rs = ps.executeQuery();

            //Bucle de lectura de la Base de datos
            while (rs.next()){

                reserva.setCod_reservas(rs.getString("CODIGO_RESERVA"));
                reserva.setCod_departamento(rs.getString("CODIGO_DEPARTAMENTO"));
                reserva.setDepartamento(rs.getString("DEPARTAMENTO"));
                reserva.setCod_salas(rs.getString("CODIGO_SALAS"));
                reserva.setSala(rs.getString("SALAS"));
                reserva.setFechaInicio(rs.getTimestamp("INICIO").toLocalDateTime());
                reserva.setFechaFin(rs.getTimestamp("FIN").toLocalDateTime());

                System.out.println(reserva);
            }


        } catch (SQLException sqle){
            res = new StringBuilder(("Error al leer la base de datos"));
        }
        return res.toString();
    }
    public static String anadirReserva(String codigo, String departamaneto, String sala, LocalDateTime fechaIncio, LocalDateTime fechaFin) throws EOFException {
        PreparedStatement ps;
        Connection con = GestorConexion.getConexion();
        String sql;
        try{
            sql = "INSERT INTO reservas VALUES (?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo);
            ps.setString(2,Util_salas.obtenerCod(sala));
            ps.setString(3,Util_departamentos.obtenerCod(departamaneto));
            ps.setTimestamp(4,Timestamp.valueOf(fechaIncio));
            ps.setTimestamp(5,Timestamp.valueOf(fechaFin));
            ps.executeUpdate();
            ps.close();
            return "Reserva añadida";
        } catch (SQLException sqle2){
            return ("ERROR");
        }
    }
    public static String eliminarReserva(String codigo){
        PreparedStatement ps;
        Connection con = GestorConexion.getConexion();
        String sql;
        try{
            sql = "DELETE FROM reservas WHERE COD_RESERVAS = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo);
            ps.executeUpdate();
            ps.close();
            return "Reserva eliminada";
        } catch (SQLException sqle2){
            return ("ERROR");
        }
    }

    public static int nReservas() throws SQLException {
        Connection con = GestorConexion.getConexion();
        String sql = "SELECT COUNT(COD_RESERVAS) AS NRESERVAS FROM reservas;";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) return rs.getInt("NRESERVAS");
        else return 0;
    }

}