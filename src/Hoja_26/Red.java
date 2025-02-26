package Hoja_26;

public class Red implements IPable {
    private int ip1;
    private int ip2;
    private int ip3;
    private int ip4;
    private String IP_dec;
    private String IP_bin;
    private String ipRed;
    private String ipHost;
    private String nombre;
    private int bitsRed;
    private Ordenador[] lista;

    //Número maximo de ordenadores en una red
    private final int N_LISTA = 1024;

    //Marcador de la siguiente posición en la lista
    private int marca;

    public Red(String nombre) {
        this.nombre = nombre;
        lista = new Ordenador[N_LISTA];
        marca = 0;
    }

    public Red(int ip1, int ip2, int ip3, int ip4) {
        this.ip1 = ip1;
        this.ip2 = ip2;
        this.ip3 = ip3;
        this.ip4 = ip4;
        lista = new Ordenador[N_LISTA];
        marca = 0;
    }

    public Red(int ip1, int ip2, int ip3, int ip4, String nombre) {
        this.ip1 = ip1;
        this.ip2 = ip2;
        this.ip3 = ip3;
        this.ip4 = ip4;
        this.nombre = nombre;
        lista = new Ordenador[N_LISTA];
        marca = 0;
    }

    public void unir(Ordenador pc) {
        if (marca < N_LISTA) {
            lista[marca] = pc;
            marca++;
        } else System.out.println("Lista completa");
    }

    public void retirar(Ordenador pc) {
        int pc_retirado = 0;
        boolean encontrado = false;
        //Primero comprobar si la lista no esta vacía
        if (N_LISTA < marca) {
            //Este bucle busca cual es el pc a retirar
            for (int i = 0; i < marca; i++) {
                if (pc.equals(lista[i])) {
                    //Almcaenamos la posición a retirar
                    i = pc_retirado;
                    //Centinela del bucle que elimina el pc
                    encontrado = true;
                }
            }
            if (encontrado) {
                //Este bucle elimina el pc deseado reescribiendo su posición
                for (int i = pc_retirado; i < marca; i++) {
                    lista[i] = lista[i + 1];
                }
                //Al finalizar la sobreescritura reducimos en 1 la marca, puesto hemos quitado un pc
                marca--;
            }

        } else System.out.println("Lista vacia");
    }

    @Override
    public void establecer(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre) {
        this.ip1 = ip1;
        this.ip2 = ip2;
        this.ip3 = ip3;
        this.ip4 = ip4;
        this.bitsRed = bitsRed;
        this.nombre = nombre;
    }

    private String obtenerIp(int ip1, int ip2, int ip3, int ip4) {
        IP_bin = "";

        for (int i = 0; i < UtilBin.contarCifras(ip1); i++) {
            IP_bin += UtilBin.obtenerBin(ip1);
        }
        for (int i = 0; i < UtilBin.contarCifras(ip2); i++) {
            IP_bin += UtilBin.obtenerBin(ip2);
        }
        for (int i = 0; i < UtilBin.contarCifras(ip3); i++) {
            IP_bin += UtilBin.obtenerBin(ip3);
        }
        for (int i = 0; i < UtilBin.contarCifras(ip4); i++) {
            IP_bin += UtilBin.obtenerBin(ip4);
        }
        return IP_bin;
    }

    private String obtenerIp_dec(int ip1, int ip2, int ip3, int ip4) {
        IP_dec = "";

        for (int i = 0; i < UtilBin.contarCifras(ip1); i++) {
            IP_dec += ip1;
        }
        for (int i = 0; i < UtilBin.contarCifras(ip2); i++) {
            IP_dec += ip2;
        }
        for (int i = 0; i < UtilBin.contarCifras(ip3); i++) {
            IP_dec += ip3;
        }
        for (int i = 0; i < UtilBin.contarCifras(ip4); i++) {
            IP_dec += ip4;
        }
        return IP_dec;
    }
    @Override
    public ObjIPable obtenerHost() {
        char[] ipArray = new char[IP_bin.length()];
        for (int i = 0; i < IP_bin.length(); i++) {
            ipArray[i]= IP_bin.charAt(i);
        }
        for (int i =  IP_bin.length(); i >= bitsRed; i--) {
            ipArray[i]='0';
        }
        for (int i = 0; i < IP_bin.length(); i++) {
            ipHost+=ipArray[i];
        }
        ObjIPable o = new ObjIPable(this.ip1,this.ip2,this.ip3,this.ip4,this.bitsRed,this.nombre);
        return o;
    }

    @Override
    public ObjIPable obtenerRed() {
        char[] ipArray = new char[IP_bin.length()];
        for (int i = 0; i < IP_bin.length(); i++) {
            ipArray[i]= IP_bin.charAt(i);
        }
        for (int i = bitsRed; i < IP_bin.length(); i++) {
            ipArray[i]='0';
        }
        for (int i = 0; i < IP_bin.length(); i++) {
            ipRed+=ipArray[i];
        }
        ObjIPable o = new ObjIPable(this.ip1,this.ip2,this.ip3,this.ip4,this.bitsRed,this.nombre);
        return o;
    }

}