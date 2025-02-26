package Ejercicios_Clase;

public class Dibujador {
    public static void linea(int longitud){
        //Escribe una linea con el tamaño indicado
        for(int i = 0; i < longitud; i++){
            System.out.print("X ");
        }
        System.out.println();
    }

    public static void linea(int longitud, char caracter){
        //Dibuja una linea con el largo y caracter indicado
        for(int i = 0; i < longitud; i++){
            System.out.print(caracter+" ");
        }
        System.out.println();
    }

    public static void cuadrado(int longitud){
        //Dibuja un cuadrado con el tamaño indicado
        for(int i = 0; i < longitud; i++){
            for(int j = 0; j < longitud; j++){
                System.out.print("X ");
            }
            System.out.println();
        }
    }

    public static void cuadrado(int longitud, char caracter){
        //Dibuja un cuadrado con el tamaño y caracter indicado
        for(int i = 0; i < longitud; i++){
            for(int j = 0; j < longitud; j++){
                System.out.print(caracter+" ");
            }
            System.out.println();
        }
    }

    public static void rectangulo(int ancho, int alto,char caracter){
        //Dibuja un rectangulo indicando alto, ancho y el caracter a dibujar
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                System.out.print(caracter+" ");
            }
            System.out.println();
        }
    }

    public static void rectangulo(int ancho, int alto){
        //Dibuja un rectangulo indicando alto y ancho
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                System.out.print('X'+" ");
            }
            System.out.println();
        }
    }


}
