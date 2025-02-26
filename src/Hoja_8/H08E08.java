package Hoja_8;

import java.util.Scanner;
public class H08E08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num,k=0;
        System.out.println("Escribe un número:");

        num = in.nextInt();

      for(int i = 1; i<= num; i++ ){
        if(i%2==0){
          for(int j =1; j<= i; j++){
              System.out.print(j+" ");
              j=k;
          }
        }else{
            for(int j = k; j>= num; j--){
              System.out.print(j+" ");
              j=k;
          }
        }
          System.out.println();
      }
        in.close();
    }
}


