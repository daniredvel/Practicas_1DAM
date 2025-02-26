package Hoja_6;

import java.util.Scanner;
public class H06E011Switch {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num;
    num = 0;
    num =  (int) Math.random()*5;
    switch(num){
        case 0:
        System.out.println("Buenos dias");
        break;
        case 1:
        System.out.println("Hola");
        break;
        case 2:
        System.out.println("Un saludo");
        break;
        case 3:
        System.out.println("Bienvenido");
        break;
        default:
        System.out.println("Como estas");
    }
        in.close();
    }
}
