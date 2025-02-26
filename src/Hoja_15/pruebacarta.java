package Hoja_15;

public class pruebacarta {
    public static void main(String[] args) {
        int [] carta = new int[40];
        int indice1, indice2, aux;
        for (int i = 0; i < 40; i++) {
            carta[i]=i+1;
        }
        for (int i = 0; i < 40; i++) {
            System.out.print(carta[i]+" ");
        }
        for (int cont = 1; cont<=100; cont++){
            indice1=(int) (Math.random()*40);
            indice2=(int) (Math.random()*40);
            aux=carta[indice1];
            carta[indice1]=carta[indice2];
            carta[indice2]= aux;
        }
        System.out.println();
        /*
        *for (int i = 0; i < 40; i++) {
        *   System.out.print(carta[i]+" ");
        *  }
            */
        for (int cartas:carta) {
            System.out.print(carta[cartas-1]+" ");
        }

    }
}
