package Examenes.E_Tema3;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        int num=31, aleatorio, aux, aleatorio_2;
        int [] resultado = new int[num];

        Scanner in = new Scanner(System.in);
        String texto;
        boolean continuar=true, valido=true;

        do {
            //Rellenar de números (ordenados) el array
            for (int i = 0; i < num; i++) {
                resultado[i]=i;
            }

            //Generación de resultados intercambiando de posición los valores del array
                for (int i = 0; i < num; i++) {
                    aleatorio = (int) (Math.random() * num);
                    aleatorio_2 = (int) (Math.random() * num);
                    aux = resultado[aleatorio];
                    resultado[aleatorio] = resultado[aleatorio_2];
                    resultado[aleatorio_2] = aux;
                }

            //Escribir los resultados por pantalla
            System.out.println("Premios:\n1ºPremio: "+resultado[0]+"\n2ºPremio: "
                    +resultado[1]+"\n3ºPremio: "+resultado[2]+"\nCuartos premios "+resultado[3]+" "+resultado[4]+" "+resultado[5]
                    + "\nPedrea: "+resultado[6]+" "+resultado[7]+" "+resultado[8]+" "+resultado[9]+" "+resultado[10]+" "+resultado[11]
                    +" "+resultado[12]+" "+resultado[13]+" "+resultado[14]+" "+resultado[15]);


            do {
                valido=true;
                System.out.println("¿Quieres volver a generar un sorteo? (sí/no)");
                texto=in.nextLine();
                if ((texto.trim().equalsIgnoreCase("SI") || texto.trim().equalsIgnoreCase("SÍ")))continuar=true;
                else if ((texto.trim().equalsIgnoreCase("NO")))continuar=false;
                else valido=false;
                if (!valido){
                    System.out.println("Respuesta incorrecta, vuelve a intentarlo");
                }
            }while (!valido);

        }while (continuar);

        System.out.println("¡Hasta pronto!");

        in.close();
    }
}
