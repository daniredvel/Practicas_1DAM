package Hoja_26;

import java.util.Objects;

public class Ordenador implements IPable {
    private int ip1;
    private int ip2;
    private int ip3;
    private int ip4;
    private String IP_dec;
    private String IP_bin;
    private String ipRed;
    private String ipHost;
    private int bitsRed;
    private String nombre;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public boolean equals(Object ob){
        if (ob instanceof Ordenador){
            Ordenador pc = (Ordenador) ob;
            return  this.ip1==pc.ip1 &&
                    this.ip2==pc.ip2 &&
                    this.ip3==pc.ip3 &&
                    this.ip4==pc.ip4 &&
                    Objects.equals(this.nombre, pc.nombre);
        }else return false;
    }
    @Override
    public String toString(){
        return  "Nombre: "+nombre+". IP_dec: "+ip1+"."+ip2+"."+ip3+"."+ip4+".";
    }
    public Ordenador (String nombre){
        this.nombre=nombre;
    }
    public Ordenador (int ip1, int ip2, int ip3, int ip4, int bitsRED){
        this.ip1=ip1;
        this.ip2=ip2;
        this.ip3=ip3;
        this.ip4=ip4;
        this.bitsRed=bitsRED;
    }
    public Ordenador (int ip1, int ip2, int ip3, int ip4, int bitsRED, String nombre){
        this.ip1=ip1;
        this.ip2=ip2;
        this.ip3=ip3;
        this.ip4=ip4;
        this.bitsRed=bitsRED;
        this.nombre=nombre;
    }

    public void establecer(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre) {
        this.ip1=ip1;
        this.ip2=ip2;
        this.ip3=ip3;
        this.ip4=ip4;
        this.bitsRed=bitsRed;
        this.nombre=nombre;
    }
    private String obtenerIp(int ip1, int ip2, int ip3, int ip4){
        IP_bin ="";

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
    private String obtenerIp_dec(int ip1, int ip2, int ip3, int ip4){
        IP_dec ="";

        for (int i = 0; i < UtilBin.contarCifras(ip1); i++) {
            IP_dec +=ip1;
        }
        for (int i = 0; i < UtilBin.contarCifras(ip2); i++) {
            IP_dec +=ip2;
        }
        for (int i = 0; i < UtilBin.contarCifras(ip3); i++) {
            IP_dec +=ip3;
        }
        for (int i = 0; i < UtilBin.contarCifras(ip4); i++) {
            IP_dec +=ip4;
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
