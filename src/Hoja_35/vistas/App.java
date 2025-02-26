package Hoja_35.vistas;
import java.util.Scanner;
import modelos.Localidad;
import bd.*;
public class App {
    /**
     * Scanner para leer de teclado, común a todas las funciones
     */
    public static Scanner teclado;


    /**
     * Función que busca una localidad en la base de datos y
     * muestra su provincia y comunidad autónoma
     * Si no la encuentra o hay un error, muestra un mensaje de error
     */
    public static void buscarLocalidad(){
        String nombre;
        Localidad localidad;
        System.out.println("Escribe el nombre de la localidad");
        nombre = teclado.nextLine();
        localidad = LocalidadBD.buscarLocalidad(nombre);
        if(localidad == null){
            LocalidadBD.mostrarError();
        }
        else{
            System.out.println(nombre+" está en "+localidad.getProvincia()+
                    " comunidad autónoma de "+localidad.getComunidad());
        }

    }

    /**
     * Función que pide una provincia y muestra la población total de la provincia
     * Si no la encuentra o hay un error, muestra un mensaje de error
     */
    public static void poblacionProvincia(){
        String provincia;
        int poblacion;
        System.out.println("Escribe el nombre de la provincia");
        provincia = teclado.nextLine();
        poblacion = LocalidadBD.poblacionProvincia(provincia);
        if(poblacion < 0){
            LocalidadBD.mostrarError();
        }
        else{
            System.out.println("La población total de "+provincia+
                    " es de "+poblacion+" habitantes");
        }
    }

    /**
     * Función que pide una comunidad autónoma y muestra la población total de la comunidad
     * Si no la encuentra o hay un error, muestra un mensaje de error
     */
    public static void poblacionComunidad(){
        String comunidad;
        int poblacion;
        System.out.println("Escribe el nombre de la comunidad");
        comunidad = teclado.nextLine();
        poblacion = LocalidadBD.poblacionComunidad(comunidad);
        if(poblacion < 0){
            LocalidadBD.mostrarError();
        }
        else{
            System.out.println("La población total de "+comunidad+
                    " es de "+poblacion+" habitantes");
        }
    }

    /**
     * Función que muestra una localidad aleatoria de la base de datos
     * Si no la encuentra o hay un error, muestra un mensaje de error
     */
    public static void localidadAleatoria(){
        Localidad localidad = LocalidadBD.localidadAleatoria();
        if(localidad==null){
            LocalidadBD.mostrarError();
        }
        else{
            String nombre = localidad.getNombre();
            String provincia = localidad.getProvincia();
            System.out.println("La localidad aleatoria es:");
            System.out.println(nombre +" ("+provincia+")");
        }
    }

    /**
     * Función que pide un número de habitantes y muestra el número de localidades
     * con más y menos habitantes que ese número
     * Si no la encuentra o hay un error, muestra un mensaje de error
     */
    public static void masYMenos(){
        System.out.println("Escriba el número de habitantes");
        try{
            int habitantes = Integer.parseInt(teclado.nextLine());
            int numeroMenos = LocalidadBD.localidadesMenos(habitantes);
            int numeroMas= LocalidadBD.localidadesMas(habitantes);
            System.out.println("Hay "+numeroMenos+" localidades de menos de "+
                    habitantes+" habitantes");
            System.out.println("Hay "+numeroMas+" localidades de más de "+
                    habitantes+" habitantes");
        }
        catch (NumberFormatException nfe){
            System.out.println("Número de habitantes no válido");
        }
    }

    /**
     * Método que ejecuta el menú de la aplicación y enlaza
     * cada opción del menú con cada función que la realiza
     */
    public static void ejecutar(){
        String res;
        do{
            System.out.println();
            System.out.println("1) Buscar Localidad");
            System.out.println("2) Población de una provincia");
            System.out.println("3) Población de una comunidad");
            System.out.println("4) Localidad aleatoria");
            System.out.println("5) Mostrar localidades con más y menos habitantes");
            System.out.println("6) Salir");
            res = teclado.nextLine();

            switch (res) {
                case "1" -> buscarLocalidad();
                case "2" -> poblacionProvincia();
                case "3" -> poblacionComunidad();
                case "4" -> localidadAleatoria();
                case "5" -> masYMenos();
                case "6" -> System.out.println("Adiós");
                default -> System.out.println("Opción incorrecta");
            }

        }while(!res.equals("6"));
    }

    /**
     * Método principal de la aplicación
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        int res = GestorConexion.crearConexion("geografia","geografia","A12345a");
        if(res!=InfoError.OK){
            System.out.println(InfoError.getMensaje(res));
        }
        else{
            ejecutar();
        }
        GestorConexion.cerrarConexion();
    }
}
