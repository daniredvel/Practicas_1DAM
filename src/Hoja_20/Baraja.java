package Hoja_20;

import java.util.Arrays;
public class Baraja {
    private Carta[] cartas;


    public Baraja(){
        cartas=new Carta[40];
        int cont=0;
        for (int palo = 1; palo <= 4; palo++) {
            for (int valor = 1; valor <= 10; valor++) {
                cartas[cont]=new Carta(palo, valor);
                cont++;
            }
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public void barajear (){
        Carta aux;
        for (int i = 0; i < 50; i++) {
            int n1 = (int) (Math.random()*40);
            int n2 = (int) (Math.random()*40);
            aux=cartas[n1];
            cartas[n1]=cartas[n2];
            cartas[n2]=aux;
        }
    }

    public void escribir(){
        for(Carta carta : cartas){
            carta.escribe();
        }
    }
}


