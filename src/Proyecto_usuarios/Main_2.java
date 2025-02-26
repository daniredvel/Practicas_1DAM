package Proyecto_usuarios;

import java.util.Scanner;

import java.sql.*;

public class Main_2 {
    public static void main(String[] args) {
        Connection con = null;

        if (GestorConexion.nuevaConexionMySQL("Usuarios","Gestor","A12345a")){
            con=GestorConexion.getConexion();
        } else {
            
            System.out.println(GestorConexion.getError());
        }
        
        final int OPCION_MAX=4, OPCION_MIN=1;
        int opcion=0;
        String lectura;
        Scanner teclado = new Scanner(System.in);
        boolean non, salida=false;
        //non se encarga de la validación del menú y salida de la salida del bucle de menú
        do{
            System.out.println("""
                               
                               --------------------
                               1) Añadir usuario
                               2) Borrar usuario
                               3) Consultar usuario
                               4) Salir
                               --------------------
                               
                               """);
            do {
                non=false;
                System.out.println("Escoge una opción");
                lectura=teclado.nextLine();
                try {
                    opcion=Integer.parseInt(lectura);
                    if (opcion<OPCION_MIN||opcion>OPCION_MAX) {
                        //Número de opciones
                        System.out.println("Opción no valida");
                        non=true;
                    }

                } catch (NumberFormatException nfe){
                    System.out.println("La opción depede de ser un número");
                    non=true;
                }
            } while (non);

            String nombre, pass, email, sql;

            switch (opcion){
                case 1:

                    try {
                        System.out.println("Escribe el nombre del usaurio");
                        nombre=teclado.nextLine();
                        System.out.println("Escribe el email del usaurio");
                        email=teclado.nextLine();
                        System.out.println("Escribe la contraseña del usaurio");
                        pass=teclado.nextLine();

                        sql = "INSERT INTO usuarios(NOMBRE, EMAIL, PASS) VALUES (?,?,?)";
                        //assert que asegura que con no sea null
                        assert con != null;
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,nombre);
                        ps.setString(2,email);
                        ps.setString(3,pass);
                        ps.executeUpdate();
                        System.out.println("Usuario añadido");
                        ps.close();


                    }catch (SQLException sqle){
                       if (sqle.getErrorCode()==1062){//Indice duplicado
                           if (sqle.getMessage().indexOf("uk")!=-1){
                               System.out.println("Ese usuario ya existe");
                           }
                       } else{
                           System.out.println("El email esta repetido");
                       }
                    }


                    break;

                case 2:
                    try {
                        System.out.println("Indica el usuario a borrar:");
                        nombre=teclado.nextLine();
                        sql="DELETE FROM usuarios WHERE nombre=?";
                        assert con != null;
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,nombre);
                        if (ps.executeUpdate()>0) System.out.println("Usuario borrado");
                        else System.out.println("No existe el usuario con nombre: " + nombre);
                        ps.close();
                    } catch (SQLException sqle){
                        System.out.println("Error al borrar el usuario");
                    }

                    break;

                case 3:

                    try {
                        System.out.println("Indica el nombre del usuario.");
                        nombre = teclado.nextLine();
                        sql="SELECT nombre, email, pass FROM usuarios WHERE nombre = ?";
                        assert con != null;
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, nombre);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()){
                            pass=rs.getString("pass");
                            email=rs.getString("email");
                            System.out.println("email: " + email + ", contraseña: " + pass);
                        } else System.out.println("El usuario con nombre: " + nombre + " no existe.");
                    }catch (SQLException sqle){
                        System.out.println("Error al ejecutar la consulta.");
                    }

                    break;

                case OPCION_MAX: //ultima opción, salida
                    if (GestorConexion.cerrarConexion()){
                        salida=true;
                        System.out.println("Adios\nConexión cerrada");
                    } else System.out.println(GestorConexion.getError());

                    break;

                default:
                    System.out.println("Opción no valida");

            }
        }while (!salida/*OPCION_MAX si esta es la opción de salida*/);

        teclado.close();

        
    }
}
