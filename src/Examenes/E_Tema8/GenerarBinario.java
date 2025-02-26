package Examenes.E_Tema8;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GenerarBinario {
    public static void main(String[] args) {
        File f1=new File("estudios.csv");
        File f2=new File("estudios.dat");
        InfoAlumno info;

        try {
            FileOutputStream fos = new FileOutputStream(f2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Scanner in = new Scanner(f1);
            while (in.hasNextLine()) {
                info= new InfoAlumno();
                StringTokenizer st = new StringTokenizer(in.nextLine(), ",");
                info.setCodAlumno(Integer.parseInt(st.nextToken()));
                info.setNombre(st.nextToken());
                info.setApellido1(st.nextToken());
                info.setApellido2(st.nextToken());
                info.setCurso(Integer.parseInt(st.nextToken()));
                info.setCiclo(st.nextToken());
                info.setModulo(st.nextToken());
                info.setNota(Double.parseDouble(st.nextToken()));
                System.out.println(info);
                oos.writeObject(info);
            }
            in.close();
            oos.close();
            System.out.println("Fichero binario generado");
        }
        catch (NumberFormatException nfe) {
            System.out.println("Error en la conversión de datos");
            nfe.printStackTrace();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Error al abrir los archivos");
        }
        catch (IOException ioe) {
            System.out.println("Error en la escritura");
        }

    }
}
