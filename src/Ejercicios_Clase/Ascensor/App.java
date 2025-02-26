package Ejercicios_Clase.Ascensor;

public class App {
    public static void main(String[] args) {
        Ascensor ascensor1 = new Ascensor();
        ascensor1.setPiso(5);
        ascensor1.subir();
        ascensor1.bajar();
        ascensor1.bajar();
        //System.out.println(ascensor1.getPiso());

        Ascensor a2 = new Ascensor();
        Ascensor a3 = new Ascensor();
        a3.setPiso(5);
        a2.copiar(a3);
        System.out.println(a2.getPiso());

    }
}
