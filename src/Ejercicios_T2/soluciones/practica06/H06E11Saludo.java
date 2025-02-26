package Ejercicios_T2.soluciones.practica06;

public class H06E11Saludo {
    public static void main(String[] args) {
        int aleatorio=(int)(Math.random()*5+1);
        if(aleatorio==1){
            System.out.println("Hola");
        }
        else if(aleatorio==2){
            System.out.println("Buenos días");
        }
        else if(aleatorio==3){
            System.out.println("Cómo estás");
        }
        else if(aleatorio==4){
            System.out.println("Un saludo");
        }
        else {
            System.out.println("Bienvenido");
        }

    }

}
