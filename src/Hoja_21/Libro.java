package Hoja_21;

public class Libro {
    private String Titulo;
    private String Autor;
    private int Año;
    public Libro(String Titulo, String Autor, int Año){
        this.Titulo=Titulo;
        this.Autor=Autor;
        this.Año=Año;
    }
    public Libro(String Titulo, int Año){
        this.Titulo=Titulo;
        this.Autor="Anónimo";
        this.Año=Año;
    }
    public Libro(String Titulo){
        this.Titulo=Titulo;
        this.Autor="Anónimo";
        this.Año=2024;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public void setAño(int año) {
        Año = año;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getAño() {
        return Año;
    }

    public String getAutor() {
        return Autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void escribir(){
        System.out.println(getTitulo()+", "+getAutor()+", año: "+getAño());
    }
}