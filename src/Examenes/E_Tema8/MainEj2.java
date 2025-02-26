package Examenes.E_Tema8;

import java.io.*;
import java.util.*;

public class MainEj2 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int n;
       try  {
           File f = new File("estudios.dat");
           ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
           InfoAlumno a;
           ArrayList<InfoAlumno> lista = new ArrayList<>();
           Iterator iterador = lista.iterator();
           try{
               while (true){
                    a = (InfoAlumno) in.readObject();
                    lista.add(a);
               }
           } catch (Exception e){
               in.close();
           }

           System.out.println("Indica el código del alumno:");
           n=Integer.parseInt(lectura.nextLine());
           StringTokenizer st;
           String nota="";
           LinkedList<Integer> listaNotas = new LinkedList<>();
           while(iterador.hasNext()){
                st = new StringTokenizer(((InfoAlumno)(iterador.next())).toString(),",");
               while (st.hasMoreTokens()){
                    nota=st.nextToken();
               }
               listaNotas.add(Integer.parseInt(nota));
           }

           Integer[] listaNotasArray= (Integer[]) listaNotas.toArray();



           lectura.close();
       } catch (Exception e){
           e.printStackTrace();
       }

    }
}
