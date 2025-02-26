package Examenes.E_Tema1;

public class Examen_01 {
    public static void main(String[] args) {
        char simbolo, simbolo_valor='L', simbolo_inicio='A',simbolo_final='Z';
        /*Las letras iniciales son la A y la Z, pero se puede cambiar por cualquier simbolo.
        *Para dar valor a los simbolos iniciales y finales, al ser char, entre comillas simples
        */
        int largo=simbolo_final-simbolo_inicio, simbolo_int, i;
        i=0;
        /*La variable i cuenta cuantas letras se han escrito antes que la "L"
        *Empieza en 0, si la 1 letra es la "L" ha habido 0 letras previas
        */
do {
   simbolo_int=(int)Math.round(Math.random()*largo+simbolo_inicio);
   //Letras aleatorias entre los valores previamente seleccionados
   simbolo = (char) simbolo_int;
   //convertir la variable numerica en un caracter ASCII
    System.out.println(simbolo);
    //Escribir el simbolo aleatorio
    i++; //Incremento del contador
}while (simbolo!=simbolo_valor); //El bucle se repite hasta que salga el simbolo deseado
        System.out.println("Han salido "+i+" letras antes de que saliera la \"L\"");
        //finalmente se escribe cuantas letras han salido antes que "L"
    }
}
