package Hoja_2;

import java.util.Scanner; //Importación del escáner
public class H02E06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //Declaración del escáner
        System.out.println("Introduzca un numero de segundos"); //Petición al usuario
        long tiempo = in.nextLong(); //Respuesta del usuario
        long horas = tiempo/3600; //De segundos a horas
        long minutos = (tiempo%3600)/60; //El resto de las horas (parte decimal) a segundos
        long segundos = (tiempo % 3600)%60; //El resto de la operación anterior son los segundos finales
        System.out.println( tiempo + "s son " + horas + " horas, " + minutos + " minutos y " + segundos + " ssegundos " );
        //Mensaje final
        in.close(); //Cierre del escáner
    }
}
