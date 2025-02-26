package Hoja_15;

public class H15E04 {
    public static void main(String[] args) {
        int k=10000,j=100;
        int[]dado=new int[k];
        int[]resultado=new int[6];
        for (int i = 0; i < k; i++) {
            dado[i]=(int)(Math.random()*6+1);
        }

        for (int i = 0; i < k; i++) {
            int m=dado[i];

                resultado[m-1]++;

        }
        for (int i = 0; i < 6; i++) {
            System.out.print("El número "+(i+1)+" ha salido "+(resultado[i])+" veces:  ");
           // int w = resultado[i]/j;
            for (int l = 0; l < (resultado[i]/j); l++) {
                System.out.print("*");
            }
            //w=0;
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.print(dado[i]+" ");
        }
    }
}
