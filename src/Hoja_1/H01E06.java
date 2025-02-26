package Hoja_1;

public class H01E06 {
    public static void main(String[] args) {
        long tiempo = 7360l;
        long horas = tiempo/3600;
        long minutos = (tiempo%3600)/60;
        long segundos = (tiempo % 3600)%60; 
        /*Dividir los segundos entre 3600 para obtener horas y luego usar el resto de la operación anterior 
        divido entre 60 para obtener los segundos y minutos */
        System.out.println( tiempo + "s son " + horas + " horas, " + minutos + " minutos y " + segundos + " ssegundos " );
       
    }

}



