package Examenes.E_Tema2;

import java.util.Scanner;

public class Examen_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    int num,n,fila,cont=0;
        System.out.println("Escriba un número impar mayor que tres:");
        num=in.nextInt();
        n=num-1;
        fila=n/2;
        /*Calculo de las filas completas de astericos
         n=num-1  fila=n/2    se escriba una fila de astericos por
         cada valor de la variable fila, multiplicado
         por el valor de filas ya escritas
         */
        for(int i=0; i<num; i++){
            /*Contador de filas escritas,
             *se escriben las mismas filas que el número introducido
             */
            if(i==cont*fila){
                //Bucle para escribir las filas completas de asteriscos
            for (int k=1; k<=num; k++){
                System.out.print("*");
            }
                cont++;
            /*Por cada fila completa de asteriscos,
            el contador aumenta una para así calcular la sigiente*/
            }else{
                if(cont%2!=0) {
                    /*Si solo se ha escrito una fila completa de asteriscos,
                     *el contador tiene valor impar
                     * si es impar solo puede valer uno o 3,
                     * si vale 3 el programa ya habra escrito el total de lineas indicadas antes
                     * por tanto solo puede valer uno, es decir, esta en la parte superior del 2
                     * por tanto ha de escribir los asteeriscos a la derecha*/
                    for (int k = 1; k <= num - 1; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }else{
                    /*Como el contador no ha sido impar, solo puede ser par
                    * y si es par, solo puede valor 2,
                    * es decir, se ha pasado la mitad del 2
                    * y al pasarse la mitad del dos, se ha de escribir la parte inferior de este
                    * con los asteriscos a la izquierda*/
                    System.out.print("*");
                }
            }


            System.out.println();
        }
        in.close();
    }
}
