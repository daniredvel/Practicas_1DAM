package Hoja_6;

import java.util.Scanner;
public class H06E04 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n1, n2, n3;
        System.out.println("Escribe tres números:");
        n1 = in.nextInt();
        n2 = in.nextInt();
        n3 = in.nextInt();

        if(n1 == n2 && n1 == n3 && n2 == n3){
            System.out.println("Hay tres números iguales a " + n1);
        }

        else if(n1 == n2){
            System.out.println("Hay dos números iguales a " + n1);
        }

        else if(n1 == n3){
            System.out.println("Hay dos números iguales a " + n1);
        }
        else if(n2 == n3){
            System.out.println("Hay dos números iguales a " + n2);
        }
        else if (n1 != n2 && n2 != n3 && n3 != n1){
            System.out.println("No hay números iguales");
        }
        
        
        in.close();
    }
}
