package Hoja_9;

import java.util.Scanner;

public class H09E03 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num, n, intentos, partida;
        char continuar;

        intentos = 0;
        partida = 0;

        num = (int) Math.round(Math.random()*101+1);

        System.out.println("¡Adivina!");
        System.out.println(num);

        do{

        do {
            n = in.nextInt();
            if(num == n){
                System.out.println("Correcto");
            } else if (num < n){
                System.out.println("El número es menor");
            } else{
                System.out.println("El número es mayor");
            }
        intentos++;
        }while(n != num);
            System.out.println(intentos + " intentos");
        if(intentos == 1){
            System.out.println("¡¡¡¡Increíble!!!!");
        } else if(intentos > 1 && intentos <= 4){
            System.out.println("¡Espectacular!");
        }else if(intentos > 4 && intentos <= 6) {
            System.out.println("Muy bueno");
        }else if(intentos == 7){
            System.out.println("No esperaba menos");
        }else if(intentos > 7 && intentos <= 10){
            System.out.println("Flojo");
        }else if(intentos > 10){
            System.out.println("¡Muy malo!");
        }
        continuar = in.nextLine().charAt(0);
        partida++;
        intentos = 0;
        }while(continuar!='N'&& continuar !='n' );
        System.out.println(partida + " partidas");
        in.close();
    }
}
