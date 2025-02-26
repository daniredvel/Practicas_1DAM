package Hoja_14;

public class H14E02_2 {
        public static void main(String[] args) {
            int num=5;
            int [] numeros = new int [20];
            for(int i=0; i<=19; i++){
                numeros[i] = (int) Math.round(Math.random() * 10 + 1);
            }
            for(int i=0;i<num; i++) {
                System.out.print(numeros[i]+" ");
            }
            System.out.println();
            for(int j=num-1; j>=0;j--){
                System.out.print(numeros[j]+" ");
            }
        }
    }

