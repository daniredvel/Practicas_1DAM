package Hoja_14;

public class H14E02 {
    public static void main(String[] args) {
        int num=50;
        double [] numeros = new double [20];
        for(int i=0; i<=19; i++){
            numeros[i] = Math.random() * 10 + 1;
        }
        for(int i=0;i<num; i++) {
            System.out.print(numeros[i]+" ");
        }
        System.out.println();
        for(int j=num-1; j>0;j--){
            System.out.print(numeros[j]+" ");
            }
        }
    }

