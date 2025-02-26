package Hoja_10;

import java.util.Scanner;
public class H10E08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Escriba un número:");
        num=in.nextInt();
        for(int i = 1, n=1; i<=num; i++){
            if(i%2!=0){
            for(int j = 1; j<=i; j++){
                System.out.print(n+" ");
                n++;
            }
            }else{
                for(int j = 1; j<=i; j++) {
                    System.out.print(n + " ");
                    n--;
                }
                n++;
                }
            System.out.println();
        }
        in.close();
    }
}
