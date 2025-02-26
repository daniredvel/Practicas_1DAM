package Proyecto_espacios.Modelos;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Reserva {
    private String nombre;
    private String cod_reservas;
    private String cod_salas;
    private String cod_departamento;
    private String sala;
    private String departamento;
    private Duration tiempo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private final DateTimeFormatter f = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy 'a las' kk:mm:ss");
    private static final int HORA_MAX = 14;
    private static final int HORA_MIN = 9;

    public static int getHORA_MAX() {
        return HORA_MAX;
    }
    public static int getHORA_MIN() {
        return HORA_MIN;
    }
    public Reserva(){

    }
    public Reserva(String nombre, String cod_reservas, String sala, String departamento, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.nombre = nombre;
        this.cod_reservas = cod_reservas;
        this.sala = sala;
        this.departamento = departamento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiempo = Reserva.obtenerTiempo(fechaInicio,fechaFin);

    }

    @Override
    public String toString() {
        return "Reserva: " + cod_reservas + ". Sala: " + sala + ". Departamento: " + departamento + ". Desde: " + fechaInicio.format(f) + ". Hasta: " + fechaFin.format(f) + ". Tiempo de reserva: " + Reserva.formatoDuration(tiempo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_reservas() {
        return cod_reservas;
    }

    public void setCod_reservas(String cod_reservas) {
        this.cod_reservas = cod_reservas;
    }

    public String getCod_salas() {
        return cod_salas;
    }

    public void setCod_salas(String cod_salas) {
        this.cod_salas = cod_salas;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Duration getTiempo() {
        return tiempo;
    }



    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public Duration setTiempo() {
        //Realiza el calculo del tiempo entre fecha_inicio y fecha_fin
        return Reserva.obtenerTiempo(fechaInicio,fechaFin);
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
        //Invoca al método setTiempo(), el cual pose el calculo para obtener la duración,
        this.tiempo=setTiempo();
    }

    private static Duration obtenerTiempo(LocalDateTime f1, LocalDateTime f2){
        return Duration.between(f1,f2);
    }
    private static String formatoDuration(Duration d){
        int s = (int) d.getSeconds();
        int h = s/3600;
        int m = (s%3600)/60;
        s = (s%3600)%60;
        return h+"h :"+m+"m :"+s+"s";
    }
}
