package Hoja_28;

public class Util {
    public static boolean[] contadorMayusculas(String token){
        /*
         * Este método nos permite obtener un array donde se indique que letras son mayusculas o minusculas
         * Se crea un array de boolenas del tamaño del token
         * Se recorro el token marcando como True aquellos elementos del array
         *                  donde en la misma posición del token sea mayuscula
         */
        boolean [] plantilla = new boolean[token.length()];
        for (int i = 0; i < token.length(); i++) {
            plantilla[i]= token.charAt(i) >= 65 && token.charAt(i) <= 97;
        }
        return plantilla;
    }
    public static String cifradoCesar(String token, int clave){
        String tokenCifrado="";

        for (int i = 0; i < token.length(); i++) {
            tokenCifrado=Util.cifrar(token, clave, i);
            /*Le pasamos a cifrar el token, la clave y la variable i, que controla el caracter que se esta manipulando*/
        }

        return tokenCifrado;
    }
    public static String cifradoAugsto(String token, String clave){
        String tokenCifrado="";
        int [] claveNum=new int[clave.length()];
        //Creamos un array donde guardamos por separado cada elemento de la clave
        try {
            for (int i = 0; i < clave.length(); i++) {
                claveNum[i]= (clave.charAt(i)-'0');
                /*
                 * Trasformamos cada caracter del String clave a un int restandole el Unicode del caracter '0'
                 * Como los numeros van seguidos, restar el Unicode de 0 (48) al Unicode de 1 (49) devuelve el 1, su valor numerico
                 */
            }
        }catch (NumberFormatException nfe){
            System.out.println("La clave debe ser un número");
        }

        for (int i = 0, j=0; i < token.length(); i++,j++) {
            if(j>clave.length()-1) j=0;
            tokenCifrado+=Util.cifrar(token, claveNum[j], i);
            /*Le pasamos a cifrar el token, la clave y la variable i, que controla el caracter que se esta manipulando*/
        }

        return tokenCifrado;
    }
    private static String cifrar(String token, int clave, int i){
        String tokenCifrado="";
        if ((token.charAt(i)+clave<='Z')||(token.charAt(i)+clave<='z')){
            //Comprobamos que la suma de la clave y la del caracter sea menor o igual a z (mayusucla o minuscula)
            tokenCifrado+=(char)(token.charAt(i)+clave);
            //Si se ha validado se cifra sumando el caracter y la clave
        } else {
            /*
             * Si la suma de clave y el Unicode del caracter es más que el Unicode de z:
             * Creamos una variable int n que almacene el valor Unicode de la Z si es mayuscula el caracter y si no el de z
             * Recogemos en clave2 la clave menos el Unicode de la z
             * ciframos el token con el caracter z o Z menos 26, la diferencia entre A y Z o a y z y le añadimos la clave
             * De esta manera se cifra a partir de la A sumando el número de clave restante de restar el Unicode de la letra y el Unicode de la z
             */
            int n = ((token.charAt(i)+clave<='Z')&&(token.charAt(i)+clave>='A')) ? 'Z':'z';
            int clave2=(token.charAt(i)+clave)-n;
            tokenCifrado+=(char)((n-26)+clave2);
        }
        return tokenCifrado;
    }
}
