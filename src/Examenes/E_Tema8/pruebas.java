package Examenes.E_Tema8;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pruebas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File file = new File("estudios.csv");
        try {
            Scanner in = new Scanner(file);
            String lectura = null;
            StringTokenizer st;
            int codAlumno, curso;
            double nota;
            String nombre, apellido1, apellido2, ciclo, modulo;

            try{
                lectura = in.nextLine();
                st = new StringTokenizer(lectura,",");

                //Obtención de datos de cada registro
                String n = st.nextToken();
                System.out.println(n);
                codAlumno=Integer.parseInt(n);
                nombre=st.nextToken();
                apellido1=st.nextToken();
                apellido2=st.nextToken();
                curso=Integer.parseInt(st.nextToken());
                ciclo=st.nextToken();
                modulo=st.nextToken();
                nota=Double.parseDouble(st.nextToken());

                InfoAlumno a = new InfoAlumno();
                a.setCodAlumno(codAlumno);
                a.setNombre(nombre);
                a.setApellido1(apellido1);
                a.setApellido2(apellido2);
                a.setCurso(curso);
                a.setCiclo(ciclo);
                a.setModulo(modulo);
                a.setNota(nota);

                System.out.println(a.toString());


            } catch (NumberFormatException nfe){
                nfe.printStackTrace();
                System.out.println("Error en la lectura del archivo");
            }
            teclado.close();
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }






    }
}
