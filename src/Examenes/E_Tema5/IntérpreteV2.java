package Examenes.E_Tema5;

public class IntérpreteV2 extends Intérprete{
    protected String[] buffer;
    private final int TAMBuffer;
    private String instruccionValidar="";

    private int n;
    private String instruccion="";
    private int marca;
    private byte nInst;
    //0 para linea
    //1 para cuadrado
    //-5 no valido

    public IntérpreteV2(int TAMBuffer){
        super(TAMBuffer);
        this.TAMBuffer=TAMBuffer;
    }
    @Override
    public void interpretar(String instruccion) {
        this.instruccion=instruccion;
        añadirBuffer(instruccion);
        if (nInst==0) Dibujador.linea(n);
        else if (nInst==1) Dibujador.cuadrado(n);
        System.out.println();
    }
    @Override
    protected void validador(String instruccion) {
        dividirString(instruccion);
        //El interpreteV2 no funciona porque no entra en el bucle del validador lo que hace que las instrucciones no se validen y sean  simpre no validas
        if (instruccionValidar.equals("LIN")) {
            this.nInst = 0;
        } else if (instruccionValidar.equals("CUA")) {
            this.nInst= 1 ;
        } else {
            this.nInst = -5;
            System.out.println("Instrucción no valida");
        }
    }
}
