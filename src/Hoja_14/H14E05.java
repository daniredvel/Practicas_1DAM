package Hoja_14;

import java.util.Scanner;

public class H14E05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num,k=10,n=0;
        int [] numeros = new int[10];
        for(int i=0; i<k; i++){
            System.out.println("Escriba el "+(i+1)+" numero");
            numeros [i] = in.nextInt();
        }
      for(int i =0, l=k-1; i<l ; i++, l--){
          if(numeros[i]==numeros[l]){
              n++;
          }else{
              break;
          }
      }
      if(n>1) {
          System.out.println("El número es capicua");
      }else{
          System.out.println("El número no es capicua");
      }
        in.close();
    }
}
