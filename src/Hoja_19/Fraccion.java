package Hoja_19;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){
        this.denominador=denominador;
        this.numerador=numerador;
    }
    public Fraccion(){
        this.denominador=1;
        this.numerador=1;
    }
    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }
    public void cambiarFraccion(int denominador, int numerador){
        this.denominador=denominador;
        this.numerador=numerador;
    }
    public void escribir(){
        System.out.println(this.numerador+"/"+this.denominador);
    }
    public void decimal(){
        System.out.println((double) (numerador)/(double) (denominador));
    }
    public void mcd(int n1, int n2){
        double mayor=Math.max(n1,n2);
        double menor=Math.min(n1,n2);
        double mcd=menor;
        while(mayor%mcd!=0 || menor%mcd!=0){
            mcd--;
        }
        System.out.println(mcd);
    }
    public void mcm(int n1, int n2){
        double mayor=Math.max(n1,n2);
        double menor=Math.min(n1,n2);
        double mcd=menor;
        while(mayor%mcd!=0 || menor%mcd!=0){
            mcd--;
        }
        double mcm = (n1*n2)/mcd;
        System.out.println(mcm);
    }
    public void simplificar(){
        double mayor=Math.max(this.numerador,this.denominador);
        double menor=Math.min(this.numerador,this.denominador);
        double mcd=menor;
        while(mayor%mcd!=0 || menor%mcd!=0){
            mcd--;
        }
        this.numerador/=mcd;
        this.denominador/=mcd;
    }
    public void suma(Fraccion f){
        double mayor=Math.max(numerador,denominador);
        double menor=Math.min(numerador,denominador);
        double mcd=menor;
        while(mayor%mcd!=0 || menor%mcd!=0){
            mcd--;
        }
        double mcm = (numerador*denominador)/mcd;
        this.denominador=(int)(mcm);
        this.numerador+=f.numerador;
        this.simplificar();
        this.escribir();
    }
    public void resta(Fraccion f){
        double mayor=Math.max(numerador,denominador);
        double menor=Math.min(numerador,denominador);
        double mcd=menor;
        while(mayor%mcd!=0 || menor%mcd!=0){
            mcd--;
        }
        double mcm = (numerador*denominador)/mcd;
        this.denominador=(int)(mcm);
        this.numerador-=f.numerador;
        this.simplificar();
        this.escribir();
    }
    public void multiplicacion(Fraccion f){
        this.numerador*=f.numerador;
        this.denominador*=f.denominador;
    this.escribir();
    }
    public void division(Fraccion f){
        this.numerador*=f.denominador;
        this.denominador*=f.numerador;
        this.simplificar();
    this.escribir();
    }
}
