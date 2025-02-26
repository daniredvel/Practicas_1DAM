package Hoja_15;

import java.util.Scanner;
public class H15E01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int producto=0,num;
        final int k=3;
        double [] precios=new double[k];
        for (int i=0; i<k;i++){
            System.out.println("Escribe el precio del "+i+" producto");
            precios[i]=in.nextDouble();
        }
        do {
            System.out.println("¿Que precio quieres saber? Escriba el indice del producto, del 0-9\nSi quiere salir escriba un número fuera de este rango.");
            num=in.nextInt();
            if(num>=0&&num<=k-1) {
                producto = num;
                System.out.println(precios[producto]);
            }
        }while(num>=0&&num<=k-1);
        System.out.println("Fin");
        in.close();
    }
}
