package Hoja_8;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class H08E01 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num, resulado, n;
        System.out.println("Escriba un número:");
        num = in.nextInt();
        if (num != 0){
            n=1;
            do{
                resulado=num*(num-n);
                n++;
            }while(n == num);
        }else {
            resulado = 1;
        }
        System.out.println(resulado);
    }
}