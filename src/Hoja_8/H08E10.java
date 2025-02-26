package Hoja_8;

import java.util.Scanner;

public class H08E10 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
double num, n;

        System.out.println("Escribe un número:");
        num = in.nextDouble();
            n = 0;
          if(num==0){
              System.out.println("0 decimales");
          } else {
              do {
                  num*=10;
                  n++;
              }while((int)  num*Math.pow(10,n)-num*Math.pow(10,n) != 0);
              System.out.println(n + " decminales");
          }

in.close();
    }
}
