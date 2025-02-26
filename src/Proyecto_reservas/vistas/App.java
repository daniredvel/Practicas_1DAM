package Proyecto_reservas.vistas;
import java.util.Scanner;
import bd.*;
public class App {
    public static Scanner teclado = null;


    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        if(GestorConexion.crearConexion("reservas","reservas","A12345a") == InfoError.OK){
            MenuPrincipal.mostrar(teclado);
            GestorConexion.cerrarConexion();
        }
        else{
            System.out.println("Error en la conexión");
        }
    }
}
