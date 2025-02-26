package Proyecto_juegoDB.Main;

import Util.UtilBD;
import bd.GestorConexion;
import bd.InfoError;
import bd.Poblacion;
import java.util.Scanner;

public class App {
    public static Scanner teclado;
    public static String poblacion;
    public static int  iPoblacion;
    public static Poblacion [] municipios;

    public static void ejecutar(){

        boolean non = false;
        do {
            try {
                System.out.println("Indica la población mínima que tienen que tener las localidades del juego");
                poblacion = teclado.nextLine();
                iPoblacion = Integer.parseInt(poblacion);
            }catch (NumberFormatException nfe){
                System.out.println("Introduce un número.");
                non = true;
            }
        }while (non);

        municipios = UtilBD.obtenerPoblaciones(iPoblacion, GestorConexion.getConexion());

        if (municipios != null) {
            App.preguntar();
        } else {
            System.out.println("Hay menos de 50 municipios con esa población o más\n" +
                    "¡Hasta pronto!");
            System.exit(0);
        }

    }

    public static void preguntar(){
        String respuesta="";
        int n;
        do {
                n = (int) (Math.random()*municipios.length);
            System.out.println(n);
            for (int i = 0; i < municipios.length; i++) {
                System.out.println(municipios[i].toString());
            }


                if (!municipios[n].isAcierto()){
                    System.out.println("¿Cual es la provincia de " + municipios[n].getNombre() + "?");
                    System.out.println(municipios[n].getProvincia());
                    respuesta = teclado.nextLine();
                    if (respuesta.equals(municipios[n].getProvincia())){
                        System.out.println("¡Correcto!");
                        municipios[n].setAcierto(true);
                    } else {
                        System.out.println("¡Incorrecto!");
                        int fallos = municipios[n].getFallos();
                        municipios[n].setFallos(fallos++);
                        System.out.println("Fallos: " + municipios[n].getFallos());
                    }
                }
            System.out.println("a");
        } while (!respuesta.equalsIgnoreCase("Salir"));

    }


    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        int res = GestorConexion.crearConexion("geografia","geografia","A12345a");
        if(res== InfoError.OK){
            ejecutar();
        }
        else{
            System.out.println(InfoError.getMensaje(res));

        }
        GestorConexion.cerrarConexion();
    }
}
