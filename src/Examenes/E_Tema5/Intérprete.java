package Examenes.E_Tema5;

public class Intérprete implements Interpretable {
    protected String[] buffer;
    private final int TAMBuffer;
    private int n;
    private String instruccion="";
    private String instruccionValidar="";
    private int marca;
    private byte nInst;
    //0 para linea
    //-5 no valido

    public Intérprete(int TAMBuffer) {
        this.TAMBuffer = TAMBuffer;
        this.buffer = new String[TAMBuffer];

    }

    public String toString() {
        String txt = "";
        for (int i = 0; i < TAMBuffer; i++) {
            txt += (buffer[i] + " ");
        }
        return txt;
    }

    @Override
    public void interpretar(String instruccion) {
        this.instruccion=instruccion;
        añadirBuffer(instruccion);

        if (nInst == 0) {
            Dibujador.linea(n);
            System.out.println();
            n=0;
        }

    }

    protected void validador(String instruccion) {
        dividirString(instruccion);
        if (instruccionValidar.equals("LIN")) {
            this.nInst = 0;
        } else {
            this.nInst = -5;
            System.out.println("Instrucción no valida");
        }
    }
    protected void dividirString(String instruccion) {
        this.instruccionValidar="";
            for (int i = 0; i < this.instruccion.length(); i++) {
                if (i < 3) {
                    this.instruccionValidar += this.instruccion.charAt(i);
                } else if (i > 3) {
                    this.n += (this.instruccion.charAt(i) - '0');
                }
            }
        }

    protected void añadirBuffer(String instruccion) {
            validador(instruccionValidar);
            if (marca >= TAMBuffer) marca = 0;
            buffer[marca] = instruccion;
            marca++;
        }
    }
