package Examenes.E_Tema9.Main;

import java.util.Scanner;
import DB.*;
import Models.*;
import Util.UtilMenu;
import Util.UtilUsuario;

public class Main {
    static Scanner teclado = null;
    public static void main(String[] args) {
        int res = GestorConexion.crearConexion("EXAMEN_PENSAMIENTOS", "ADMIN_PENSAMIENTOS", "A12345a");
        if (res == InfoError.OK) {
            ejecutar();
        } else {
            System.out.println(InfoError.getMensaje(res));

        }
        GestorConexion.cerrarConexion();
    }
    public static void ejecutar() {
        teclado = new Scanner(System.in);
        String opcionElegida;
        do {
            System.out.println(Menu.getMensaje(Menu.MENU_INICIAL) + "\n\nIndica una opción:");
            opcionElegida = teclado.nextLine();
            switch (opcionElegida) {
                case "1" -> anadirUsuario();
                case "2" -> System.out.println(eliminarUser());
                case "3" -> UtilMenu.listarUsuario();
                case "4" -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción no valida");
            }
        } while (!opcionElegida.equalsIgnoreCase("4"));

    }
    public static void menuUsuario(String usuario) {
        String opcionElegida;
        boolean salir = false;

        if(buscarUser(usuario)){
        do {
            System.out.println(Menu.getMensaje(Menu.MENU_USUARIO) + "\n\nIndica una opción:");
            opcionElegida = teclado.nextLine();
            if (opcionElegida.isEmpty()) {
                salir = true;
            }

            switch (opcionElegida) {
                case "1" -> System.out.println(anadirPensamiento(usuario));
                case "2" -> UtilUsuario.listarPensamiento();
                case "3" -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción no valida");
            }

        } while (!opcionElegida.equalsIgnoreCase("3")||salir);
    }
    }
    private static String eliminarUser(){
        String usuario;
        System.out.println("Indica el usuario a borrar:\nVacio para cancelar.");
        usuario = teclado.nextLine();

        if (UtilMenu.buscarUser(usuario) == 1){
            return UtilMenu.borrarUsuario(usuario);
        } else if (UtilMenu.buscarUser(usuario) == 0) return InfoError.getMensaje(InfoError.USUARIOS_VACIO);
       else return InfoError.getMensaje(InfoError.USUARIO_NO_ENCONTRADO);
    }
    private static boolean buscarUser(String usuario){

        if (!usuario.isEmpty()) {
            if( UtilMenu.buscarUser(usuario) == 1) return true;
            else return false;
        }
        else return false;
    }
    private static void anadirUsuario(){
        String usuario;
        System.out.println("Indica el usuario:");
        usuario = teclado.nextLine();
        if (buscarUser(usuario)) menuUsuario(usuario);
        else{
            //if (usuario.toUpperCase().matches("[A-Z]") && usuario.length()>4 && !usuario.matches("[0-9]")){

                if (UtilMenu.anadirUsuario(usuario)){
                    menuUsuario(usuario);

                } else System.out.println("Error al añadir el usuario");
            }
        }
    //}
    private static String anadirPensamiento(String usuario){
        System.out.println("¿Cual es el pensamiento?");
        String pensaiento= teclado.nextLine();
        return UtilUsuario.anadirPensamiento(usuario, pensaiento);

    }
}