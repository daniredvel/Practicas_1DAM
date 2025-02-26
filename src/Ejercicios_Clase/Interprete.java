package Ejercicios_Clase;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Interprete implements Interpretable{
    protected String[] buffer;
    private int cont;


    public Interprete(int tam){
        buffer = new String[tam];
        cont = 0;
    }
    @Override
    public void interpretar(String instruccion)
                    throws NumberFormatException, NoSuchElementException,NoSuchFieldError {
        StringTokenizer st = new StringTokenizer(instruccion, " ");
        //Si hay menos de dos token o mas de cuatro indica error Las instrucciones han de ser del tipo LIN 3
        if (st.countTokens() < 2 || st.countTokens() > 4) {
            throw new NoSuchFieldError ("Número de parametro invalido");
        }
        //Si no ha indicado error, la instruccion es correcta
        else {
            String comando = st.nextToken();
            //Recoge el 2 token transformandolo a numero en el proceso
            int numero = Integer.parseInt(st.nextToken());
            //Comprueba si la instrucción es LIN, linea
            if (comando.equalsIgnoreCase("LIN")) {
                //Si quedan más tokens los recoge en un String, el caracter con el que dibujar la figura de la instrucción
                if (st.hasMoreTokens()) {
                    String caracter = st.nextToken();
                    /* Dibujador;
                     * numero: tamaño de la figura
                     * caracter: caracter con el que dibujar la figura
                     */
                    Dibujador.linea(numero, caracter.charAt(0));
                } else {
                    //Al no indicarse un caracter, se dibuja simplemente una figura con el largo indicado
                    Dibujador.linea(numero);
                }
            } else if (comando.equalsIgnoreCase("CUA")) {
                if (st.hasMoreTokens()) {
                    //Si hay más tokens significa que existe una token más, el caracter con el que dibujar
                    //Se recoge el token
                    String caracter = st.nextToken();
                    //Se dibuja con el nuevo caracter
                    Dibujador.cuadrado(numero, caracter.charAt(0));


                    //Si no se ha encontrado un nuevo caracter, se dibuja con un valor por defecto indicado en el Dibujador
                } else Dibujador.cuadrado(numero);
            } else if (comando.equalsIgnoreCase("REC")) {
                //Si la instrucción ha sido REC, al menos hay otro parametro
                //Recogemos el nuevo parametro
                int alto = Integer.parseInt(st.nextToken());
                //Comprobamos si hay más tokens
                if (st.hasMoreTokens()) {
                    //Si hay más tokens recogemos el nuevo caracter
                    //Dibujamos el rectangulo
                    String caracter = st.nextToken();
                    Dibujador.rectangulo(numero /*ancho*/,alto, caracter.charAt(0));


                    //Si no hay un 4 token no hay caracter y por tanto se dibuja con el valor por defecto de la clase Dibujador
                } else Dibujador.rectangulo(numero, alto);
            } else {
                throw new NoSuchFieldError("Error\nComando no conocido");
            }
        }
    }

    @Override
    public String toString() {
        String salida="";
        for(int i=0;i<cont;i++){
            salida += buffer[i]+"\n";
        }
        return salida;
    }

    protected void gestionBuffer(String instruccion){
        if(cont<buffer.length){
            buffer[cont]=instruccion;
            cont++;
        }
        else{
            for(int i=0;i< buffer.length-1;i++){
                buffer[i]=buffer[i+1];
            }
            buffer[buffer.length-1]=instruccion;
        }
    }
}
