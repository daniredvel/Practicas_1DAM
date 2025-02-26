package Hoja_3;

import java.util.Scanner;
public class H03E04 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double ang1, ang2, ang3;
        System.out.println("Escribe los ángulos");
        ang1 = in.nextDouble();
        ang2 = in.nextDouble();
        ang3 = 180-(ang1 +ang2);
        System.out.println("El tercer ángulo mide " + ang3 + " grados");
        in.close();
    
    }
}
