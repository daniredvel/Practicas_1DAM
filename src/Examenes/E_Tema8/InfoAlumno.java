package Examenes.E_Tema8;

import java.io.Serializable;

public class InfoAlumno implements Serializable {
    private int codAlumno;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int curso;
    private String ciclo;
    private String modulo;
    private double nota;

    public InfoAlumno(int codAlumno, String nombre, String apellido1, String apellido2, int curso, String ciclo, String modulo, double nota) {
        this.codAlumno = codAlumno;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.curso = curso;
        this.ciclo = ciclo;
        this.modulo = modulo;
        this.nota = nota;
    }

    public InfoAlumno(){
        this.codAlumno = 0;
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.curso = 0;
        this.ciclo = "";
        this.modulo = "";
        this.nota = 0.0;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "codAlumno=" + codAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", curso=" + curso +
                ", ciclo='" + ciclo + '\'' +
                ", modulo='" + modulo + '\'' +
                ", nota=" + nota ;
    }
}
