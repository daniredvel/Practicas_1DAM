package Examenes.E_Tema5;

public class Main {
    public static void main(String[] args) {
        IntérpreteV2 i2 = new IntérpreteV2(3);
        i2.interpretar("LIN 3");
        i2.interpretar("CUA 2");
        System.out.println(i2);
        i2.interpretar("LIN 3");
        i2.interpretar("CUA 2");
        System.out.println(i2);
    }
}
