package Hoja_32.H32E01;
//152 bytes
public class Vivienda {
    private String sNombre;
    private String sDireccion;
    private double dMetros;
    private long lnCatastro;
    private char[] nombre;
    private char[] direccion;
    public static final int TAM_NOMBRE=20;
    public static final int TAM_DIRECCION=50;

    @Override
    public String toString() {
        String dir=this.sDireccion.replace("\u0000","");
        String n=this.sNombre.replace("\u0000","");
        return
                "Nombre: " + n +
                ", direccion: " + dir +
                ", metros: " + dMetros +
                ", nCatastro: " + lnCatastro;
    }

    public long getnCatastro() {
        return lnCatastro;
    }
    public Vivienda(int lnCatastro, char [] nombre, char[] direccion,double dMetros){

    }
    public Vivienda(int lnCatastro, String sNombre, String sDireccion,double dMetros){
        int i=0;
        this.lnCatastro=lnCatastro;
        this.nombre=new char[TAM_NOMBRE];
        try{
            /*
             * En este caso se sale del bucle sin generar execpción.
             * Se sale cuando el String es más largo que el tamaño máximo
             * o el o el contador i ya ha llegado al largo del String
             */

            while (i<sNombre.length() && i<TAM_NOMBRE){
                this.nombre[i]=sNombre.charAt(i);
                i++;
            }
        } catch (StringIndexOutOfBoundsException siobe){}
    }
}
