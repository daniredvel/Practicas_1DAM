package Proyecto_usuarios;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
final String SQL_DRIVER="com.mysql.cj.jdbc.Driver";
final String SQL_PROTOCOLO="jdbc:mysql://";
final String SQL_SERVIDOR="localhost:";
final String SQL_PUERTO="3306/";
final String SQL_BASE_DATOS="USUARIOS";
final String SQL_CONEXION=SQL_PROTOCOLO+SQL_SERVIDOR+SQL_PUERTO+SQL_BASE_DATOS;
final String SQL_USUSARIO="Gestor";
final String SQL_CONTRASENA="A12345a";
try {
    Class.forName(SQL_DRIVER);
    Connection con = DriverManager.getConnection(SQL_CONEXION,SQL_USUSARIO,SQL_CONTRASENA);


    con.close();
} catch (ClassNotFoundException cnfe){
    System.out.println("Error al cargar los Drivers");
} catch (SQLException sqle){
    System.out.println("Error al conectar con la base de datos");
}
    }
}
