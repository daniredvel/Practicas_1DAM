package Hoja_9;

import java.util.Scanner;

public class H09E01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String articulo; //nombre del articulo
        double cantidad, precio, total, total_final; // cantidad de producto, precio producto individual, precio producto*cantidad, precio factura total
        total_final = 0; //inicio variable
        do {
            System.out.println("Escriba el nombre del producto");
            articulo = in.nextLine(); //Pregunta por el nombre del producto

            System.out.println("Escriba la cantidad");
            cantidad = in.nextDouble();//Pregunta por la cantidad
            if(cantidad != 0) { //Si la cantidad es 0, sale del bucle
                System.out.println("Escribe el precio");
                precio = in.nextDouble(); //Pregunta el precio del producto
            }else{
                break; //Sale del bucle cantidad=0
            }
            total = cantidad * precio; //precio del prodducto por cantidad de producto
            total_final += total; //precio total de todos los productos mas su cantidad, se va acumulando en  lo que dure el bucle
            if(precio != 0){//Si la cantidad es 0, sale del bucle
            }else {
                break;//Sale del bucle
            }
            System.out.println("Articulo : " + articulo + ", cantidad :" + cantidad  + ", precio: " + precio + ", total: " + total + " euros");

        }  while (precio != 0 || cantidad != 0); //Bucle hasta que cantidad o precio sean iguales a cero

        System.out.println("-------------------------");
        System.out.println("Total de la factura: " + total_final + " euros"); //Factura final
        in.close();
    }
}