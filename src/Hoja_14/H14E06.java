package Hoja_14;

public class H14E06 {
    public static void main(String[] args) {
        int k = 5, n, n1, n2 = 0, cont = 0;
        int[] numeros = new int[k];
        int[] numeros2 = new int[k];
        int[] suma = new int[k+1];
        boolean salida=false;

        for (int i = 0; i < k; i++) {
            numeros[i] = (int) (Math.random() * 9 + 1);
            numeros2[i] = (int) (Math.random() * 9 + 1);

        }
        for (int i = 0; i < k||salida; i++) {
            if(i>=5){
                salida =true;
            }
            if (numeros[i] + numeros2[i] >= 10) {
                suma[i] = (numeros[i] + numeros2[i]) % 10;
                i++;
                suma[i] = (numeros[i] + numeros2[i]) +1;
            } else {
                suma[i] = (numeros[i] + numeros2[i]);
            }
        }
        for (int i=0; i<k;i++){
            System.out.print(numeros[i]+" ");
        }
        System.out.println();
        for (int i=0; i<k;i++){
            System.out.print(numeros2[i]+" ");
        }
        System.out.println();
        for (int i=0; i<k;i++){
            System.out.print(suma[i]+" ");
        }
    }
}
