package Hoja_20;

public class Carta {
    private int palo;
    //1-Oros 2-Espadas 3-Bastos 4-Copas
    private int valor;
    //8-Sota 9-Caballo 10-Rey

    //Carta por defecto (1,1) As de oros
    public Carta(int palo, int valor){
        this.palo=palo;
        this.valor=valor;
    }
    public Carta(){
        this.palo=1;
        this.valor=1;
    }

    public int getpalo() {
        return palo;
    }

    public int getvalor() {
        return valor;
    }

    public void setpalo(int palo) {
        this.palo = palo;
    }

    public void setvalor(int valor) {
        this.valor = valor;
    }
    public void darValor(int palo, int valor){
        int palo_aux=this.palo;
        int valor_aux=this.valor;
        if (!(palo>4||palo<1)){
            this.palo=palo;
        }else{
            System.out.println("¡Error, palo no existente!");
            this.palo=palo_aux;
        }
        if (!(valor>10||valor<1)){
            this.valor=valor;
        }else{
            System.out.println("¡Error, valor no existente!");
            this.valor=valor_aux;
        }
        }
    public void escribe(){
        String palo_aux="oros";
        String valor_aux="uno";
        if (this.palo == 1) palo_aux="oros";
        else if (this.palo == 2) palo_aux="espadas";
        else if (this.palo == 3) palo_aux="bastos";
        else if (this.palo == 4) palo_aux="copas";

        if(this.valor == 1) valor_aux = "uno";
        else if(this.valor == 2) valor_aux = "dos";
        else if(this.valor == 3) valor_aux = "tres";
        else if(this.valor == 4) valor_aux = "cuatro";
        else if(this.valor == 5) valor_aux = "cinco";
        else if(this.valor == 6) valor_aux = "seis";
        else if(this.valor == 7) valor_aux = "siete";
        else if(this.valor == 8) valor_aux = "sota";
        else if(this.valor == 9) valor_aux = "caballo";
        else if(this.valor == 10) valor_aux = "rey";

        System.out.print(valor_aux + " de "+ palo_aux+", ");

         }

    }

