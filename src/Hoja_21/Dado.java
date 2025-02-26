package Hoja_21;

public class Dado {
    private int valor;

    public int getValor() {
        return valor;
    }
    public void tirar(){
        int x;
        x=(int)(Math.random()*6+1);
        valor=x;
        System.out.println(getValor());
    }
}
