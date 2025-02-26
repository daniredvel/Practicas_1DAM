package Hoja_14;

public class H14E01 {
    public static void main(String[] args) {
        int [] numeros = new int [20];
        for(int i=1;i<=19; i++) {
            numeros[i] = (int) Math.round(Math.random() * 201 + 1);
            for(int j=1; j<=numeros[i]; j++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
