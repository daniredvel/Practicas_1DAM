package Hoja_26;

public class UtilBin {
private static int n_dec;
private static String n_bin;

     //Pasar de binario a Decimal
    public static int obtenerInt(String binario) {
        //Este bucle recorre el String
        //El bucle podria ser un for each, pero al ser un fori almacenamos la posición para el calculo posterior
        for (int i = binario.length()-1; i >= 0; i--) {
            //Si el valor del caracter es '1' realizara el siguiente calculo, si es 0 es indiferente. No puede haber más valores
            if (binario.charAt(i)=='1'){
                //Conversión a binario. La base (2) elevada a la posición (i)
                n_dec+=(int) (Math.pow(2, i));
            }
        }
        //Devolvemos el número convertido a decimal
        return n_dec;
    }
    public static int obtenerInt(String binario, int nBits) {
        //Este bucle recorre el String
        //El bucle podria ser un for each, pero al ser un fori almacenamos la posición para el calculo posterior
        for (int i = binario.length()-1; i >= 0; i--) {
            //Si el valor del caracter es '1' realizara el siguiente calculo, si es 0 es indiferente. No puede haber más valores
            if (binario.charAt(i)=='1'){
                //Conversión a binario. La base (2) elevada a la posición (i)
                n_dec+=(int) (Math.pow(2, i));
            }
        }
        //Devolvemos el número convertido a decimal
        return n_dec;
    }


    //Este metodo externaliza la tarea de invertir el String.
    private static String invertir(String Str1) {
        //Iniciamos el String
        String StrInversa = "";
        //Recorremos de forma invertida el String, del final al inicio
        for (int i = Str1.length() - 1; i >= 0; i--) {
            //Asignamos los valores del String invertido a un nuevo String
            StrInversa +=  Str1.charAt(i);
        }
        //Devolvemos el String invertido
        return StrInversa;
    }

    //pasa de decimal a binarip
    public static String obtenerBin (int entero){
        //Iniciar el String
        n_bin="";
        int num=entero;

        /*
         *Mientras que num sea mayor a 0 se divide entre dos, si el resto es 0
         *se añade un 0 a binario, si es distinto de 0 se añade un 1
         */

        while (num > 0){
            if (num%2==0){
                n_bin+="0";
            }else n_bin+="1";
            num/=2;
        }

        /*
        *Se devuelve el String invertido debido a que los primeros numeros son los ultimos divididos
        *
        * Por ejemplo, para pasar el número 48 a binario
        * 48 entre 2 sobra 0
        * 24 entre 2 sobra 0
        * 12 entre 2 sobra 0
        * 6 entre 2 sobra 0
        * 3 entre 2 sobra 1
        * 1 entre 2 sobra 1
        *
        * El resultado seria 000011, por lo tanto es necesario invertirlo para obtener su valor binario real, es decir, 110000.
         */
        return UtilBin.invertir(n_bin);
    }    //pasa de decimal a binario indicando el número de bits
    public static String obtenerBin (int entero, int nBits){
        UtilBin.obtenerBin(entero);
        if (n_bin.length()<nBits) {
            int[] n_dec_array = new int[nBits];
            for (int i = nBits - 1; i >= 0; i--) {
                n_dec_array[i] = n_bin.charAt(i) - '0';
            }
            n_bin = "";
            for (int i = 0; i < nBits; i++) {
                n_bin += n_dec_array[i];
            }
        }
        return UtilBin.invertir(n_bin);
    }
    public static int  contarCifras(int num){
        int cont=0;
        int n=num;
        do {
            n/=10;
            cont++;
        }while(n!=0);
        return cont;
    }
}
