package Hoja_7;

import java.util.Scanner;

public class H07E11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, index;
        
        do{
            index = 0;
            System.out.println("\nEscribe un número:");
        num = in.nextInt();
        while (num>index){
            System.out.print("*");
            index++;
        }
    
        }while(num!=0);
        in.close();
    }
}
