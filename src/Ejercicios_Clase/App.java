package Ejercicios_Clase;/*import java.util.NoSuchElementException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String instruccion;
        Interprete inter = new Interprete(10);
        System.out.println("Escriba la instrucción\nFIN para salir del programa");
        instruccion = in.nextLine();
        while (!instruccion.equalsIgnoreCase("FIN")){
            try {
                inter.interpretar(instruccion);
            } catch (NumberFormatException nfe){
                System.out.println("Error formato no válido");
            } catch (NoSuchElementException nsee){
                System.out.println("Error\nFinaliza la instrucción");
            } catch (NoSuchFieldError nsfe){
                System.out.println(nsfe.getMessage());
            }
            System.out.println("Escribe la instrucción: ");
            instruccion = in.nextLine();
        }
    }
}
 */