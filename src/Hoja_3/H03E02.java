package Hoja_3;

import java.util.Scanner;
public class H03E02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
  double altura, base, area;
   System.out.println("Escriba la altura");
   altura = in.nextDouble();
        System.out.println("Escriba la base");
   base = in.nextDouble();
   area = (base*altura)/2;
   System.out.println("El area es " + area);
   in.close();
}
}
