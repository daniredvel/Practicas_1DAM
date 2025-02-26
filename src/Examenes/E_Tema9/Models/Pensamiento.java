package Examenes.E_Tema9.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pensamiento {
    private String pensamiento;
    private int codigo;
    private String usuario;
    private LocalDateTime fecha;
    private final DateTimeFormatter f = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy 'a las' kk:mm:ss");


    public String getPensamiento() {
        return pensamiento;
    }

    public void setPensamiento(String pensamiento) {
        this.pensamiento = pensamiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Usuario " + usuario + "\nPensamiento " + pensamiento + "\n Fecha: " + fecha.format(f);
    }
}
