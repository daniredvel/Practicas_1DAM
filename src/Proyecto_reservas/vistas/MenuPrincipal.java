package Proyecto_reservas.vistas;
import controladores.DepartamentoBD;
import modelos.Departamento;

import java.util.Scanner;

public class MenuPrincipal {
    private static final String PASS_ADMIN = "A12345a";

    /**
     * Comprueba si el departamento introducido es correcto
     * @param teclado Scanner para leer datos
     * @return Departamento si es correcto, null si no lo es
     */
    private static Departamento validarDepartamento(Scanner teclado){
        String codDepartamento;
        System.out.println("Introduce el código del departamento");
        codDepartamento = teclado.nextLine();
        if(codDepartamento.length()!=3){
            System.out.println("Código de departamento incorrecto (deben ser 3 caracteres)");
            return null;
        }
        else{
            Departamento departamento = DepartamentoBD.buscar(codDepartamento);
            if(departamento==null){
                System.out.println("Departamento no encontrado");
            }
            return departamento;
        }
    }

    /**
     * Muestra el menú principal
     * @param teclado Scanner para leer datos
     */
    public static void mostrar(Scanner teclado){
        String opcion;
        do{
            System.out.println("-------------------------");
            System.out.println("     MENÚ PRINCIPAL");
            System.out.println("-------------------------");
            System.out.println("1) Login administrador ");
            System.out.println("2) Login departamento ");
            System.out.println("3) Salir ");
            System.out.println("-------------------------");
            System.out.print(">");
            opcion = teclado.nextLine();
            switch(opcion){
                case "1":
                    MenuAdmin.mostrar(teclado);
                    break;
                case "2":
                    Departamento departamento = validarDepartamento(teclado);
                    if(departamento!=null) {
                        MenuDepartamento.mostrar(departamento, teclado);
                    }
                    else{
                        Utiles.pausa(teclado);
                    }
                case "3":
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }while(!opcion.equals("3"));
    }
}
