package Hoja_27;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Festivo{
    private String nombre;
    private LocalDate fecha;

    public Festivo(int dia, int mes, String nombre){
        this.nombre=nombre;
        this.fecha=LocalDate.of(0, mes,dia);
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MMMM");
        return "Fecha: "+fecha.format(f)+" Festivo: "+nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public static Festivo nuevoFestivo(){
        Scanner in = new Scanner(System.in);
        int mes=0;
        int dia=0;
        String name="";
        Festivo f = null;
        boolean continuar;
        try{
            do {
                continuar=false;
                System.out.println("Dime el día:");
                dia = Integer.parseInt(in.nextLine());
                System.out.println("Dime el mes:");
                mes = Integer.parseInt(in.nextLine());
                if (((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && dia >= 31) ||
                        ((mes == 4 || mes == 6 || mes == 9 || mes == 10) && dia < 31 && dia > 28) ||
                        ((mes == 28) && dia == 28)) {
                    System.out.println("Dia no valído");
                    continuar = true;
                } else System.out.println("Día válido");
            } while (continuar);
        System.out.println("Dime el festivo:");
        name=in.nextLine();
        f = new Festivo(dia, mes, name);
        }catch (Exception e){

            System.out.println("Error al indicar el festivo");
        }
        return f;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
