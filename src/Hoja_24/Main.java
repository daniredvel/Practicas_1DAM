package Hoja_24;

public class Main {
    public static void main(String[] args) {
        Password p = new Password("COntrASEñaALeatOrIA354366364");
        Password p1 = new Password(27);
        Password p2 = new Password();
        System.out.println("1) "+p.getPass()+"\n2) "+p1.getPass()+"\n3) "+ p2.getPass());
        System.out.println("1) "+p.esFuerte()+"\n2) "+p1.esFuerte()+"\n3) "+ p2.esFuerte());

    }
}
