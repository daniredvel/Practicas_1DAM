package Examenes.E_Tema1;

import java.util.Scanner;

public class Examen_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double apuesta=1, saldo=0, dinero_ganado=0;
        int caballo_apostado, caballo_ganador;
        while(apuesta!=0){
            caballo_ganador=(int)Math.round(Math.random()*7+1);
            //Calculo del caballo ganador entre uno y seis
            System.out.println("¿Cuánto quieres apostar (0 para abandonar)?");
            apuesta=in.nextDouble();
            if(apuesta==0) {
                //Si la apuesta vale 0, sale del programa
            break;
            }
            System.out.println("¿A que caballo apuestas?");
            caballo_apostado=in.nextInt();
            //Caballo apostado
            System.out.println("El caballo ganador es el: "+caballo_ganador);
            if(caballo_apostado==caballo_ganador){
                //Si el caballo apostado gana, el cliente gana su apuesta multiplicada por 4
                dinero_ganado=apuesta*4;
                System.out.println("¡Has ganado "+dinero_ganado+"€ !");
            }else{
                //Si el cliente pierde se le retira lo apostado del saldo
                dinero_ganado=-apuesta;//El dinero perdido es el dinero ganado en negativo
                System.out.println("Has perdido "+dinero_ganado+"€");
            }
            saldo+=dinero_ganado;
            //Se renueva el saldo con el dinero ganado (en negativo si ha perdido)
            dinero_ganado=0;
            //Se reinicia el dinero ganado pendiente de una nueva apuesta y un nuevo juego
            System.out.println("Tu saldo es de "+saldo+"€");
            //Se escribe el valor del nuevo saldo
        }
        System.out.println("Adiós, vueve pronto");
        //Si la apuesta ha sido de 0€, el cliente se ha ido, el programa se despide y finaliza
        in.close();
    }
}
