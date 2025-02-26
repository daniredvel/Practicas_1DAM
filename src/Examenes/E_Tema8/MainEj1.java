package Examenes.E_Tema8;

import java.io.File;
import java.util.*;

public class MainEj1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        try{
            Scanner in = new Scanner(new File("estudios.csv"));
            StringTokenizer st;
            int codAlumno, curso, cont=0;
            double nota;
            String alumno, lectura, nombre, apellido1, apellido2, ciclo, modulo;
            LinkedList <InfoAlumno> lista = new LinkedList<>();
            ListIterator<InfoAlumno> iterador = lista.listIterator();

            try{
                while (in.hasNext()) {
                    lectura = in.nextLine();
                    st = new StringTokenizer(lectura,",");

                    //Obtención de datos de cada registro
                    codAlumno=Integer.parseInt(st.nextToken());
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

                    lista.add(a);
                    cont++;

                }
/*
                String alumnoMensaje = lista.getLast().toString();
                for (int i = cont-2; i > 0 ; i--) {
                    System.out.println(alumnoMensaje);
                    alumnoMensaje = lista.get(i).toString();
                }

                Collections.reverse(lista);
                for (InfoAlumno msg :
                        lista) {
                    System.out.println(msg.toString());
                }
*/




                /*
                InfoAlumno [] arrayLista = (InfoAlumno[]) lista.toArray();
                for (int i = arrayLista.length; i > 0; i--) {
                    System.out.println(arrayLista[i]);
                }

                 */



            } catch (NumberFormatException nfe){
                System.out.println("Error en la lectura del archivo");
            }


            teclado.close();
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
