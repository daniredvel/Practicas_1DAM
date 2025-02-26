package Proyecto_espacios.Main;

import java.util.Scanner;
import DB.*;
import Models.*;
import Util.*;

public class Main {
    static Scanner teclado = null;
    private static final String pass = "pass";

    public static void main(String[] args) {
        int res = GestorConexion.crearConexion("PROYECTO_RESERVAS", "ADMIN_RESERVAS", "A12345a");
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
                case "1" -> menuAdmin();
                case "2" -> menuDep();
                case "3" -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción no valida");
            }
        } while (!opcionElegida.equalsIgnoreCase("3"));

    }
    public static void menuAdmin() {
        String opcionElegida;
        String leerPass;
        boolean salir = false;
        do {
            System.out.println("Indica la contraseña:\n(Dejar en blanco para cancelar)");
                leerPass = teclado.nextLine();

                if (pass.equals(leerPass)) {
                    salir = true;
                do {
                    System.out.println(Menu.getMensaje(Menu.MENU_ADMINISTRADOR) + "\n\nIndica una opción:");
                    opcionElegida = teclado.nextLine();
                    switch (opcionElegida) {
                        case "1" -> System.out.println(Util_departamentos.listarDepartamentos());
                        case "2" -> System.out.println(UtilMain.anadirDepartamento());
                        case "3" -> System.out.println(UtilMain.eliminarDepartamento());
                        case "4" -> System.out.println(Util_salas.listarSalas());
                        case "5" -> System.out.println(UtilMain.anadirSala());
                        case "6" -> System.out.println(UtilMain.eliminarSala());
                        case "7" -> System.out.println(Util_reservas.listarReservas());
                        case "8" -> System.out.println("¡Hasta pronto!");
                        default -> System.out.println("Opción no valida");
                    }

                } while (!opcionElegida.equalsIgnoreCase("8"));
            } else if (leerPass.isEmpty()) {
                salir = true;
            } else System.out.println("Contraseña incorrecta");

        } while (!salir);


    }
    public static void menuDep() {
        String opcionElegida, leerDep;
        boolean salir = false;
        do {
            System.out.println("Indica el departamento:\n(Dejar en blanco para cancelar)");
            leerDep = teclado.nextLine();

            if (UtilMain.existeDep(leerDep)) {
                salir = true;

                do {
                    System.out.println(Menu.getMensaje(Menu.MENU_DEPARTAMENTO) + "\n\nIndica una opción:");
                    opcionElegida = teclado.nextLine();
                    switch (opcionElegida) {
                        case "1" -> System.out.println(UtilMain.anadirReserva(leerDep));
                        case "2" -> System.out.println(UtilMain.eliminarReserva());
                        case "3" -> System.out.println(Util_reservas.listarReservasDep(leerDep));
                        case "4" -> System.out.println("¡Hasta pronto!");
                        default -> System.out.println("Opción no valida");
                    }
                } while (!opcionElegida.equalsIgnoreCase("4"));
            } else if (leerDep.isEmpty()) {
                salir = true;
            } else System.out.println("No existe ese departamento, indique otro.");

        } while (!salir);

    }
}